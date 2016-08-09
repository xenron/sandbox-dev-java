package packt;

import java.awt.AWTEvent;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.LayerUI;

class PasswordLayerUI extends LayerUI<JPanel> {

    private String errorMessage = "Password too short";

    @Override
    public void paint(Graphics g, JComponent c) {
        FontMetrics fontMetrics;
        Font font;
        int height;
        int width;
        
        super.paint(g, c);
        Graphics2D g2d = (Graphics2D) g.create();
        int componentWidth = c.getWidth();
        int componentHeight = c.getHeight();

        // Display error message
        g2d.setFont(c.getFont());
        fontMetrics = g2d.getFontMetrics(c.getFont());
        height = fontMetrics.getHeight();
        g2d.drawString(errorMessage, 
                componentWidth / 2 + 10, componentHeight / 2 + height);
        
        // Display watermark
        String displayText = "Beta Version";
        font = new Font("Castellar",Font.PLAIN, 16);
        fontMetrics = g2d.getFontMetrics(font);
        g2d.setFont(font);
        width = fontMetrics.stringWidth(displayText);
        height = fontMetrics.getHeight();
        
        Composite com = g2d.getComposite();
        AlphaComposite ac = AlphaComposite.getInstance(
                ((AlphaComposite)com).getRule(),0.25f);
        g2d.setComposite(ac);
        g2d.drawString(displayText, 
                (componentWidth - width) / 2, 
                (componentHeight - height) / 2);
        
        g2d.dispose();
    }

    @Override
    public void installUI(JComponent component) {
        super.installUI(component);
        ((JLayer) component).setLayerEventMask(AWTEvent.KEY_EVENT_MASK);
    }

    @Override
    public void uninstallUI(JComponent component) {
        super.uninstallUI(component);
        ((JLayer) component).setLayerEventMask(0);
    }

    protected void processKeyEvent(KeyEvent event, JLayer layer) {
        JTextField f = (JTextField) event.getSource();
        if (f.getText().length() < 6) {
            errorMessage = "Password too short";
        } else {
            errorMessage = "";
        }
        layer.repaint();
    }

}

