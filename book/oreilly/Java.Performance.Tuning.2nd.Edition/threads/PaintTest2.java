/*
<APPLET CODE=tuning.threads.PaintTest2 WIDTH=300 HEIGHT=300>
</APPLET>
 */
package tuning.threads;
import java.awt.*;
import java.applet.*;
import java.util.*;

public class PaintTest2
  extends PaintTest
  implements Runnable
{
  public void init()
  {
    (new Thread(this)).start();
  }
  public void run()
  {
    for(;;)
      repaint();
  }
  public void paint(Graphics g)
  {
    paintOnce(g);
  }
}
