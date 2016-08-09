package packt;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ApplicationDriver {

    public static void main(String[] args) {               
//        JFrame.setDefaultLookAndFeelDecorated(true);
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ApplicationWindow window = new ApplicationWindow();
                window.setVisible(true);
            }
        });

    }
}
