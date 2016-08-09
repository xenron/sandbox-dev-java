package packt;

import java.awt.FlowLayout;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicationWindow extends JFrame 
        implements MouseListener, MouseWheelListener{

    public ApplicationWindow() {
       this.setTitle("Example");
       this.setSize(200, 100);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setLayout(new FlowLayout());
       JButton exitButton = new JButton("Exit");
       this.add(exitButton);

       int totalButtons = MouseInfo.getNumberOfButtons();
       System.out.println(Toolkit.getDefaultToolkit().areExtraMouseButtonsEnabled());
       System.out.println("You have " + totalButtons + " total buttons");

       
       this.addMouseListener(this);
       this.addMouseWheelListener(this);


       exitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent event) {
               System.exit(0);
           }
       });

    }
   public void mousePressed(MouseEvent e) {
       System.out.println("" + e.getButton());

   }

   public void mouseWheelMoved(MouseWheelEvent e) {
       System.out.println("" + e.getPreciseWheelRotation() +
               " - " + e.getWheelRotation());
   }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
}
