package functions;
import java.awt.*;
import java.awt.event.*;

class HelloButtonApp1 {
  private final Button button = new Button();

  static class HelloActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println("Hello There: event received: " + e);
    }
  }

  public HelloButtonApp1() {
    button.addActionListener(new HelloActionListener());
  }
}