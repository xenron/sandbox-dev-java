package com.joshondesign.gwtbox2d.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

/**
 * Created by IntelliJ IDEA.
 * User: josh
 * Date: 11/6/11
 * Time: 9:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Blob1 implements EntryPoint {

    private CanvasDebugDraw canvasDraw;
    public void onModuleLoad() {
        canvasDraw = new CanvasDebugDraw(1024,700);

        Canvas canvas = canvasDraw.getCanvas();
        RootLayoutPanel.get().add(canvas);
        Context2d ctx = canvas.getContext2d();
        ctx.setFillStyle("black");
        ctx.fillRect(0,0, canvasDraw.getWidth(), canvasDraw.getHeight());

        ctx.setFillStyle("red");
        ctx.beginPath();
        ctx.moveTo(300, 300);
        ctx.lineTo(500,350);
        ctx.lineTo(350, 500);
        ctx.lineTo(300, 300);
        ctx.closePath();
        ctx.fill();


        ctx.setFillStyle("#00FF00");
        ctx.fillRect(100,100,100,100);
        ctx.setStrokeStyle("white");
        ctx.setLineWidth(15);
        ctx.strokeRect(100,100,100,100);

    }
}
