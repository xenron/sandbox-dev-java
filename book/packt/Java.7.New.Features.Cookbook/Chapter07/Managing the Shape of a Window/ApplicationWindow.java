package packt;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicationWindow extends JFrame {

    public ApplicationWindow() {
        this.setTitle("Example");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new StopPanel());
        final Polygon myShape = getPolygon();

        this.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                setShape(myShape);
                ((JFrame) e.getSource()).setForeground(Color.red);
                ((JFrame) e.getSource()).setBackground(Color.red);
            }
        });

        this.setUndecorated(true);
    }

    private Polygon getPolygon() {
        int x1Points[] = {0, 0, 100, 200, 300, 300, 200, 100};
        int y1Points[] = {100, 200, 300, 300, 200, 100, 0, 0};
        Polygon polygon = new Polygon();
        for (int i = 0; i < y1Points.length; i++) {
            polygon.addPoint(x1Points[i], y1Points[i]);
        }
        return polygon;
    }
}
