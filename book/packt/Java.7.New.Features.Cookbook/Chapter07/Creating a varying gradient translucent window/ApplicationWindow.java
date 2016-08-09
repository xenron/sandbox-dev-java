package packt;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationWindow extends JFrame {

    public ApplicationWindow() {
        this.setTitle("Gradient Translucent Window");
        setBackground(new Color(0, 0, 0, 0));
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {

            @Override
            protected void paintComponent(Graphics gradient) {
                if (gradient instanceof Graphics2D) {
                    final int Red = 120;
                    final int Green = 50;
                    final int Blue = 150;
                    Paint paint = new GradientPaint(0.0f, 0.0f,
                            new Color(Red, Green, Blue, 0),
                            getWidth(), getHeight(),
                            new Color(Red, Green, Blue, 255));
                    Graphics2D gradient2d = (Graphics2D) gradient;
                    gradient2d.setPaint(paint);
                    gradient2d.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        this.setContentPane(panel);
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
