package packt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.plaf.LayerUI;

public class ApplicationWindow extends JFrame {

    public ApplicationWindow() {
        this.setTitle("Example");
        this.setSize(300, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LayerUI<JPanel> layerUI = new PasswordLayerUI();
        JLayer<JPanel> jlayer = new JLayer<JPanel>(getPanel(), layerUI);

        this.add(jlayer);
    }

    private JPanel getPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel gridPanel = new JPanel(new GridLayout(1, 2));
        JLabel quantityLabel = new JLabel("Password");
        gridPanel.add(quantityLabel);
        JPasswordField passwordField = new JPasswordField();
        gridPanel.add(passwordField);
        panel.add(gridPanel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton okButton = new JButton("OK");
        buttonPanel.add(okButton);
        JButton cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }
}
