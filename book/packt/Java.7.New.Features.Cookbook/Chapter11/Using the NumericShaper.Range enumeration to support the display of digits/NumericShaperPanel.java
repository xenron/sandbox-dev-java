package packt;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.NumericShaper;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.util.HashMap;
import javax.swing.JPanel;

public class NumericShaperPanel extends JPanel {

    private TextLayout layout;

    public NumericShaperPanel() {
        String text = "0 1 2 3 4 5 6 7 8 9";
        HashMap map = new HashMap();
        Font font = new Font("Mongolian Baiti", Font.PLAIN, 32);
        map.put(TextAttribute.FONT, font);
        map.put(TextAttribute.NUMERIC_SHAPING,
                NumericShaper.getShaper(NumericShaper.Range.MONGOLIAN));
        FontRenderContext fontRenderContext = 
                new FontRenderContext(null, false, false);
        layout = new TextLayout(text, map, fontRenderContext);    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        layout.draw(g2d, 10, 50);
    }
}

