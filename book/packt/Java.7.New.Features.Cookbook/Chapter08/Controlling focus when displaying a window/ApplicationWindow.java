package packt;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicationWindow extends JFrame {

    private SecondWindow second;

    public ApplicationWindow() {
        this.setTitle("Example");
        this.setBounds(100, 100, 200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        second = new SecondWindow();
        second.setVisible(true);

        JButton secondButton = new JButton("Hide");
        this.add(secondButton);
        secondButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                second.setVisible(false);
            }
        });
        
 
        JButton thirdButton = new JButton("Reveal");
        this.add(thirdButton);
        thirdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                second.setVisible(true);
            }
        });

        JButton exitButton = new JButton("Exit");
        this.add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    }
}
