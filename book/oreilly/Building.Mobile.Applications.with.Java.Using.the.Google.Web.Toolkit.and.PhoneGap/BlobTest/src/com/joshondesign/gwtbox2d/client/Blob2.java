package com.joshondesign.gwtbox2d.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.googlecode.gwtphonegap.client.*;
import org.jbox2d.callbacks.DebugDraw;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.World;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: josh
 * Date: 11/6/11
 * Time: 10:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Blob2 implements EntryPoint {
    private CanvasDebugDraw canvasDraw;
    private World world;
    private Body ground;
    private Timer renderTimer;

    public void onModuleLoad() {

        canvasDraw = new CanvasDebugDraw(1024,700);

        Canvas canvas = canvasDraw.getCanvas();
        RootLayoutPanel.get().add(canvas);




        //setup the world
        Vec2 gravity = new Vec2(0, -10f);
        world = new World(gravity, true);
        world.setDebugDraw(canvasDraw);
        canvasDraw.setCamera(0f, 10f, 20f);



        //create a floor
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(0.0f, 0.0f);
        ground = world.createBody(bodyDef);
        PolygonShape sd = new PolygonShape();
        sd.setAsBox(10, 1, new Vec2(0,0), 0f);
        ground.createFixture(sd, 0f);




        //create a circle
        bodyDef.position.set(0,10);
        bodyDef.type = BodyType.DYNAMIC;
        Body circle = world.createBody(bodyDef);
        CircleShape circleDef = new CircleShape();
        circleDef.m_radius = 3f;
        circle.createFixture(circleDef, 1f);




        renderTimer = new Timer() {
            @Override
            public void run() {
                //processInput();
                step();
                //step();
                //step();
                render();
            }
        };
        renderTimer.scheduleRepeating(1000/30);
    }



    public void step() {
        float timeStep = 1 / 30f;
        world.setWarmStarting(true);
        world.setContinuousPhysics(true);
        world.step(timeStep, 4, 3);
    }



    public void render() {
        canvasDraw.clear();
        canvasDraw.setFlags(DebugDraw.e_shapeBit + DebugDraw.e_jointBit);
        world.drawDebugData();
    }

}
