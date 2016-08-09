package packt;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicationWindow extends JFrame {

    public ApplicationWindow() {
        this.setTitle("Example");
        this.setBounds(100, 100, 200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setType(Type.UTILITY);
        this.setLayout(new FlowLayout());
        
        JButton exitButton = new JButton("Exit");
        this.add(exitButton);
        exitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    }
}
