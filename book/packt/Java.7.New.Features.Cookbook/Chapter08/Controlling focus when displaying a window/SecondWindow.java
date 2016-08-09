package packt;

import javax.swing.JFrame;

public class SecondWindow extends JFrame {
    
    public SecondWindow() {
        this.setTitle("Second Window");
        this.setBounds(400, 100, 200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setAutoRequestFocus(false);
    }
}

