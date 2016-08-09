package packt;

import java.awt.Container;
import javax.swing.JFrame;

public class NumericShaperExample extends JFrame {

    public NumericShaperExample() {
        Container container = this.getContentPane();
        container.add("Center", new NumericShaperPanel());
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("NumericShaper Example");
        this.setSize(250, 120);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new NumericShaperExample();
    }
}

