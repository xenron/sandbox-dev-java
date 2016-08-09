package functions;
import java.awt.*;
import java.awt.event.*;

class HelloButtonApp2 {
	private final Button button = new Button();

  public HelloButtonApp2() {
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("Hello There: event received: " + e);
      } 
    });
  }
}