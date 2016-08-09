/*
<APPLET CODE=tuning.threads.PaintTest WIDTH=300 HEIGHT=300>
</APPLET>
 */
package tuning.threads;
import java.awt.*;
import java.applet.*;
import java.util.*;

public class PaintTest
  extends Applet
{
  public void paint(Graphics g)
  {
    for (;;)
    {
      paintOnce(g);
      try{Thread.sleep(250);}catch(InterruptedException e){}
    }
  }
  public void paintOnce(Graphics g)
  {
    int h = size().height;
    int w = size().width;
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    g.clearRect(0, 0, w, h);
    paintDial(w, h, g);
    paintHand(cal.get(Calendar.SECOND), 30, w, h, g, Color.red, 9);
    paintHand(cal.get(Calendar.MINUTE), 30, w, h, g, Color.blue, 8);
    paintHand(cal.get(Calendar.HOUR), 6, w, h, g, Color.green, 6);
//    repaint();
  }
  public void paintDial(int width, int height, Graphics g)
  {
    g.setColor(Color.blue);
    for (int i = 0; i < 60; i += 5)
    {
      int x = width/2 + (int) (9*width*Math.sin((Math.PI*(30-i))/30))/20;
      int y = height/2 + (int) (9*height*Math.cos((Math.PI*(30-i))/30))/20;
      g.fillOval(x-5 , y-5, 10, 10);
    }
  }
  public void paintHand(int sector, int full, int w, int h, Graphics g, Color c, int scale)
  {
    int x = w/2 + (int) (scale*w*Math.sin((Math.PI*(full-sector))/full))/20;
    int y = h/2 + (int) (scale*h*Math.cos((Math.PI*(full-sector))/full))/20;
    g.setColor(c);
    g.drawLine(w/2, h/2, x, y);
  }
}
