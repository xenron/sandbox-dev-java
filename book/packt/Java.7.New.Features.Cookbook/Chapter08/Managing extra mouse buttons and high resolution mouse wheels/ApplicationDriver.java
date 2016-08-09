package packt;

import javax.swing.SwingUtilities;

public class ApplicationDriver {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ApplicationWindow window = new ApplicationWindow();
                window.setVisible(true);
            }
        });

    }
}
