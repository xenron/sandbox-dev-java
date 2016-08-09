package com.joshondesign.gwtbox2d.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.googlecode.gwtphonegap.client.*;
import com.googlecode.gwtphonegap.client.accelerometer.Acceleration;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerationCallback;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerationOptions;
import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.joints.ConstantVolumeJointDef;
import org.jbox2d.dynamics.joints.Joint;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class BlobGame extends Composite implements EntryPoint, MouseMoveHandler,
        MouseDownHandler, MouseUpHandler {

    public World m_world;
    private CanvasDebugDraw canvasDraw;
    Timer renderTimer;
    private List<Body> blobBodies = new ArrayList<Body>();
    private ConstantVolumeJointDef blob;
    private Body ground;
    final Logger logger = Logger.getLogger("BlobGame");
    private Body ramp;
    private Body exit;

    private boolean showSplash = true;
    private boolean won = false;


    public void onModuleLoad() {
        logger.info("loading the module");

        logger.info("about to start phonegap");
        final PhoneGap phoneGap = GWT.create(PhoneGap.class);
        phoneGap.addHandler(new PhoneGapAvailableHandler() {
            public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
                logger.info("inside phonegap is ready: ");
                AccelerationOptions options = new AccelerationOptions();
                options.setFrequency(50);
                phoneGap.getAccelerometer().watchAcceleration(options,new AccelerationCallback() {
                    public void onSuccess(Acceleration acceleration) {
                        if(showSplash) return;
                        if(won) return;
                        //logger.severe("real accell  " + acceleration.getX() + " " + acceleration.getY());
                        Vec2 gravity = new Vec2((float)-acceleration.getY()*10f,(float)acceleration.getX()*10f);
                        //logger.log(Level.SEVERE,"accell succeeded: " + gravity);
                        m_world.setGravity(gravity);
                    }
                    public void onFailure() {
                        logger.severe("accell failed: ");
                    }
                });
            }
        });
        phoneGap.addHandler(new PhoneGapTimeoutHandler() {
                public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
                    logger.severe("insides phonegap failed. :(");
                }
        });
        phoneGap.initializePhoneGap();
        logger.info("finished intializing phone gap");

        //create an HTML canvas
        canvasDraw = new CanvasDebugDraw(1024,768);
        Canvas canvas = canvasDraw.getCanvas();
        
        canvas.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if(showSplash) showSplash = false;
                if(won) {
                    won = false;
                    showSplash = false;
                    resetGame();
                }
            }
        });
        canvas.addMouseDownHandler(this);
        canvas.addMouseUpHandler(this);
        canvas.addMouseMoveHandler(this);
        logger.info("set up handlers");



        //set up the camera and the world
        //the world is scale 20
        canvasDraw.setCamera(0f, 10f, 20f);
        Vec2 gravity = new Vec2(0, -10f);
        m_world = new World(gravity, true);
        //attach to a debug draw
        m_world.setDebugDraw(canvasDraw);



        //create the ground
        ground = null;
        {
            PolygonShape sd = new PolygonShape();


            BodyDef bd = new BodyDef();
            bd.position.set(0.0f, 0.0f);
            ground = m_world.createBody(bd);

            //bottom edge
            sd.setAsBox(71.0f, 0.4f, new Vec2(48.5f,-5), 0f);
            ground.createFixture(sd, 0f);
            //top edge
            sd.setAsBox(60.0f, 0.4f, new Vec2(-5,26), 0f);
            ground.createFixture(sd, 0f);
            //left edge
            sd.setAsBox(0.4f, 40.0f, new Vec2(-23.0f, 29.5f), 0.0f);
            ground.createFixture(sd, 0f);
            //right edge
            sd.setAsBox(0.4f, 28.0f, new Vec2(120.0f, 22.5f), 0.0f);
            ground.createFixture(sd, 0f);

            sd.setAsBox(60.0f, 0.4f, new Vec2(60,50), 0f); ground.createFixture(sd, 0f);
            sd.setAsBox(90.0f, 0.4f, new Vec2(55,70), 0f); ground.createFixture(sd, 0f);
            sd.setAsBox(0.4f, 80f, new Vec2(140,0), 0f); ground.createFixture(sd, 0f);
            sd.setAsBox(120.0f, 0.4f, new Vec2(45,-30), 0f); ground.createFixture(sd, 0f);
            sd.setAsBox(0.4f, 80f, new Vec2(-60,0), 0f); ground.createFixture(sd, 0f);

            //ramp
            bd.position.set(60f,1f);
            bd.angle = 10f;
            ramp = m_world.createBody(bd);
            sd.setAsBox(10.0f, 0.4f, new Vec2(0,0f), 0f);  ramp.createFixture(sd, 0f);

            bd = new BodyDef();
            bd.active = false;
            bd.position.set(-49f, 5f);
            bd.angle = 0;
            exit = m_world.createBody(bd);
            sd = new PolygonShape();
            sd.setAsBox(10.0f,10.0f,new Vec2(0,0),0);
            FixtureDef fd = new FixtureDef();
            fd.density = 10f;
            fd.restitution = 1;
            fd.shape = sd;
            Fixture fix = exit.createFixture(fd);
            //exit.createFixture(sd,10f);
        }




        //create the blob structure
        blob = new ConstantVolumeJointDef();

        float cx = 0.0f;
        float cy = 10.0f;
        float rx = 5.0f;
        float ry = 5.0f;
        int nBodies = 10; //number of points in the blob field
        float bodyRadius = 0.5f;
        for (int i = 0; i < nBodies; ++i) {
            float angle = MathUtils.map(i, 0, nBodies, 0, 2 * 3.1415f);
            BodyDef bd = new BodyDef();
            bd.fixedRotation = true;

            float x = cx + rx * (float) Math.sin(angle);
            float y = cy + ry * (float) Math.cos(angle);
            bd.position.set(new Vec2(x, y));
            bd.type = BodyType.DYNAMIC;
            Body body = m_world.createBody(bd);

            FixtureDef fd = new FixtureDef();
            CircleShape cd = new CircleShape();
            cd.m_radius = bodyRadius;
            fd.shape = cd;
            fd.density = 1.0f;
            fd.filter.groupIndex = -2;
            body.createFixture(fd);
            blob.addBody(body);
            blobBodies.add(body);
        }

        blob.frequencyHz = 5.0f;
        blob.dampingRatio = 0.5f;
        m_world.createJoint(blob);


        //attach the canvas to the scene
        RootLayoutPanel.get().add(canvas);


        //start a timer to render everything
        renderTimer = new Timer() {
            @Override
            public void run() {
                check();
                step();
                //step();
                //step();
                render();
                fpsCounter++;
            }
        };
        renderTimer.scheduleRepeating(30);
    }

    private void resetGame() {
        logger.severe("reseting the game");
        float cx = 0.0f;
        float cy = 10.0f;
        float rx = 5.0f;
        float ry = 5.0f;
        for(int i=0; i<blobBodies.size(); i++) {
            Body body = blobBodies.get(i);
            float angle = MathUtils.map(i, 0, blobBodies.size(), 0, 2 * 3.1415f);
            float x = cx + rx * (float) Math.sin(angle);
            float y = cy + ry * (float) Math.cos(angle);
            body.setTransform(new Vec2(x,y),0);
            body.setLinearVelocity(new Vec2(0,0));
        }
        m_world.setGravity(new Vec2(0,-10));
    }

    private void check() {
        //logger.severe("exit = " + exit.getPosition() + " " + blobBodies.get(0).getPosition());
        Vec2 p1 = blobBodies.get(0).getPosition();
        Vec2 p2 = exit.getPosition();
        if(p2.x > p1.x - 5 && p2.x < p1.x + 5) {
            if(p2.y > p1.y -5 && p2.y < p1.y + 5) {
                //logger.severe("collided");
                won = true;
            }
        }
    }


    long fpsCounter;

    //on each step run the physics
    public void step() {
        float timeStep = 1 / 30f;
        m_world.setWarmStarting(true);
        m_world.setContinuousPhysics(true);
        m_world.step(timeStep, 4, 3);
    }

    //on each render draw the screen
    public void render() {
        canvasDraw.clear();
        renderDebug();

        if(true) return;
        //do the real gfx ontop
        Context2d ctx = canvasDraw.getCanvas().getContext2d();
        ctx.setFillStyle("#aaaaaa");
        ctx.fillRect(0, 0, canvasDraw.getWidth(), canvasDraw.getHeight());


        calcCenter();
        ctx.save();
        ctx.translate(canvasDraw.getWidth() / 2, canvasDraw.getHeight() / 2 + 200);
        ctx.scale(8,-8);
        ctx.translate(-centerX,-centerY+10f);
        drawBorders(ctx);
        drawRamp(ctx);
        drawExit(ctx);
        //drawBrick(ctx);
        drawBlob(ctx);

        //ctx.setFillStyle("green");
        //ctx.fillRect(centerX,centerY,1,1);
        ctx.restore();


        if(showSplash){
            drawSplash(ctx);
        }
        if(won) {
            drawWon(ctx);
        }
        logger.info("rendered");
    }

    private void drawWon(Context2d ctx) {
        ctx.save();
        ctx.translate(250, 300);
        ctx.setFont("100pt Georgia");
        ctx.setFillStyle("white");
        ctx.fillText("You won!", 0, 0);
        ctx.setFillStyle("black");
        ctx.strokeText("You won!", 0, 0);


        ctx.setFont("60pt Georgia");
        ctx.setFillStyle("white");
        ctx.fillText("tap to play again", 0, 100);
        ctx.setFillStyle("black");
        ctx.strokeText("tap to play again", 0, 100);
        ctx.restore();
    }

    private void drawSplash(Context2d ctx) {
        ctx.setFillStyle("white");
        ctx.save();
        ctx.translate(0, 100);
        ctx.setFont("100pt Georgia");
        ctx.fillText("Blob Hope", 260,100);
        ctx.setFont("30pt Arial");
        ctx.fillText("in  ", 430, 200);
        ctx.setFont("60pt Georgia");
        ctx.fillText("The Road to Splitsville", 150, 300);

        ctx.setFillStyle("white");
        ctx.setFont("100pt Georgia");
        ctx.strokeText("Blob Hope", 260, 100);
        ctx.setFont("30pt Arial");
        ctx.strokeText("in ", 430, 200);
        ctx.setFont("60pt Georgia");
        ctx.strokeText("The Road to Splitsville", 150, 300);


        ctx.setFillStyle("black");
        ctx.fillText("tap to play",400,500);
        ctx.restore();
    }


    float centerX = 0.0f;
    float centerY = 0.0f;
    float prevCenterX = 0;
    float prevCenterY = 0;

    private void calcCenter() {
        float totalX = 0;
        float totalY = 0;
        for(Body body : blobBodies) {
            totalX += body.getPosition().x;
            totalY += body.getPosition().y;
        }
        prevCenterX = centerX;
        prevCenterY = centerY;
        centerX = (totalX/((float)blobBodies.size()));
        centerY = (totalY/((float)blobBodies.size()));
        //logger.info("center = " + centerX + " " + centerY);
    }

    private void drawBlob(Context2d ctx) {
        //draw the blob
        ctx.setFillStyle("black");
        ctx.beginPath();
        //Body first = blobBodies.get(0);
        //ctx.moveTo(first.getPosition().x,first.getPosition().y);
        //int count = 0;
        Body prev = blobBodies.get(blobBodies.size()-1);
        ctx.moveTo(prev.getPosition().x,prev.getPosition().y);
        for(int i=0; i<blobBodies.size(); i++) {
            Body body = blobBodies.get(i);
            Body next = blobBodies.get((i+1) % blobBodies.size());
            Vec2 p = body.getPosition();
            Vec2 pp = prev.getPosition();
            Vec2 pn = next.getPosition();
            double ap = calcAngle(p,pp);
            double an = calcAngle(p,pn);

            Vec2 cp = calcPoint(p, ap, 0.1);
            Vec2 cn = calcPoint(p, an, -1);
            ctx.bezierCurveTo(
                    pp.x,pp.y,
                    cn.x,cn.y,
                    p.x,p.y);
            //ctx.lineTo(p.x,p.y);
            prev = body;
        }
        ctx.closePath();
        //ctx.setLineWidth(0.1);
        //ctx.setStrokeStyle("black");
        ctx.stroke();
        ctx.fill();

        ctx.setFillStyle("white");
        float threshold = 0.2f;
        if(prevCenterX < centerX - threshold) {
            prevCenterX =  centerX -threshold;
        }
        if(prevCenterX > centerX + threshold) {
            prevCenterX = centerX + threshold;
        }
        if(prevCenterY < centerY - threshold) {
            prevCenterY =  centerY -threshold;
        }
        if(prevCenterY > centerY + threshold) {
            prevCenterY = centerY + threshold;
        }
        fillCircle(ctx,prevCenterX,prevCenterY,1.5f,"white");
        fillCircle(ctx,prevCenterX+2,prevCenterY,1.5f,"white");
        //ctx.fillRect(prevCenterX,prevCenterY,2,2);
        //ctx.fillRect(prevCenterX+2,prevCenterY,2,2);
        //ctx.setFillStyle("black");
        fillCircle(ctx, centerX, centerY, 0.7f, "black");
        fillCircle(ctx,centerX+2,centerY,0.7f,"black");

        //ctx.fillRect(centerX+0.4,centerY+0.2,0.5,0.5);
        //ctx.fillRect(centerX+2+0.4,centerY+0.2,0.5,0.5);
    }

    private void fillCircle(Context2d ctx, float x, float y, float radius, String fill) {
        ctx.setFillStyle(fill);
        ctx.beginPath();
        ctx.arc(x,y,radius,0,Math.PI*2);
        ctx.closePath();
        ctx.fill();
    }

    private void drawBorders(Context2d ctx) {
        Fixture fixtures = ground.getFixtureList();
        while(fixtures != null) {
            PolygonShape poly = (PolygonShape) fixtures.getShape();
            fillPoly(ctx,poly,"yellow","black");
            fixtures = fixtures.getNext();
        }
    }

    private void drawRamp(Context2d ctx) {
        ctx.save();
        ctx.translate(ramp.getPosition().x,ramp.getPosition().y);
        ctx.rotate(ramp.getAngle());
        Fixture fixtures = ramp.getFixtureList();
        while(fixtures != null) {
            PolygonShape poly = (PolygonShape) fixtures.getShape();
            fillPoly(ctx,poly,"yellow","black");
            fixtures = fixtures.getNext();
        }
        ctx.restore();
    }
    private void drawExit(Context2d ctx) {
        ctx.save();
        ctx.translate(exit.getPosition().x,exit.getPosition().y);
        ctx.rotate(exit.getAngle());
        Fixture fixtures = exit.getFixtureList();
        while(fixtures != null) {
            PolygonShape poly = (PolygonShape) fixtures.getShape();
            fillPoly(ctx,poly,"red","black");
            fixtures = fixtures.getNext();
        }
        ctx.restore();
    }
    private void fillPoly(Context2d ctx, PolygonShape poly, String fillColor, String strokeColor) {
        ctx.setFillStyle(fillColor);
        ctx.setStrokeStyle(strokeColor);
        ctx.beginPath();
        for(int i =0; i<poly.getVertexCount(); i++) {
            Vec2 v = poly.getVertex(i);
            if(i == 0) {
                ctx.moveTo(v.x,v.y);
            } else {
                ctx.lineTo(v.x,v.y);
            }
        }
        ctx.closePath();
        ctx.fill();
        //ctx.setLineWidth(0.2);
        //ctx.stroke();
    }

    private void renderDebug() {
        //do the debug drawing
        canvasDraw.setFlags(DebugDraw.e_shapeBit + DebugDraw.e_jointBit);
        m_world.drawDebugData();
    }

    private void p(String s) {
        System.out.println(s);
    }

    //event handlers
    public void onMouseDown(MouseDownEvent mouseDownEvent) {
        if(showSplash) return;
        //System.out.println("clicked at : " + mouseDownEvent.getClientX() + " " + mouseDownEvent.getClientY());
        logger.info("cliecked : " + mouseDownEvent);
        Vec2 gravity = new Vec2(
                (mouseDownEvent.getClientX()-canvasDraw.getWidth()/2)/30f,
                -(mouseDownEvent.getClientY()-canvasDraw.getHeight()/2)/30f
                );
        m_world.setGravity(gravity);
    }

    public void onMouseMove(MouseMoveEvent mouseMoveEvent) {
    }

    public void onMouseUp(MouseUpEvent mouseUpEvent) {
    }

    public static class Pt {
        private double x;
        private double y;

        public Pt(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Vec2 calcPoint(Vec2 point, double angle, double dist) {
        return new Vec2(
                (float)(point.x+Math.sin(Math.toRadians(angle))*dist),
                (float)(point.y+Math.cos(Math.toRadians(angle))*dist)
        );
    }

    public static double calcAngle(Vec2 point1, Vec2 point2) {
        return Math.toDegrees(Math.atan2(point2.x-point1.x,point2.y-point1.y));
    }
}
