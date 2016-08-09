package packt;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

class StopPanel extends JPanel {

    public StopPanel() {
        this.setBackground(Color.red);
        this.setForeground(Color.red);
        this.setLayout(null);

        JButton okButton = new JButton("YES");
        JButton cancelButton = new JButton("NO");
        okButton.setBounds(90, 225, 65, 50);
        cancelButton.setBounds(150, 225, 65, 50);

        okButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        this.add(okButton);
        this.add(cancelButton);

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int pageHeight = this.getHeight();
        int pageWidth = this.getWidth();
        int bigHeight = (pageHeight + 80) / 2;
        int bigWidth = (pageWidth - 305) / 2;
        int smallHeight = (pageHeight + 125) / 2;
        int smallWidth = (pageWidth - 225) / 2;

        Font bigFont = new Font("Castellar", Font.BOLD, 112);
        Font smallFont = new Font("Castellar", Font.PLAIN, 14);

        g2d.setFont(bigFont);
        g2d.setColor(Color.white);
        g2d.drawString("STOP", bigWidth, bigHeight);
        g2d.setFont(smallFont);
        g2d.drawString("Are you sure you want to continue?", smallWidth, smallHeight);
    }
}
