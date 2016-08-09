package tuning.graphics;
import java.awt.*;
import java.awt.event.*;

public class Ball
  extends Frame
{
  static Color RED = Color.red;
  public static void main(String args[])
  {
    new Ball();
  }

  public Ball()
  {
    //Create a graph window and start it in a separate thread
    super("Ball");
    this.setSize(600,400);
    this.show();
  }

  public void paint(Graphics g)
  {
    Point xy = new Point();
    int x = 0;
    int y = 0;
    int radius = 40;
    int height, width;
    int xmotion = 1;
    int ymotion = 1;
    Dimension d = getSize();
    Color bcolor = getBackground();
    long time = System.currentTimeMillis();
    for (int i = 10000; i > 0 ; i--)
    {
      d = getSize();
      height = d.height;
      width = d.width;
      g.setColor(bcolor);
      g.fillOval(x,y,radius,radius);
      if (x+radius >= width)
        xmotion = -1;
      else if (x <= 0)
        xmotion = 1;
      if (y+radius >= height)
        ymotion = -1;
      else if (y <= 0)
        ymotion = 1;
      x += xmotion;
      y += ymotion;
      g.setColor(RED);
      g.fillOval(x,y,radius,radius);
    }
    System.out.println("Time: " + (System.currentTimeMillis()-time));
    System.exit(0);
  }
}
