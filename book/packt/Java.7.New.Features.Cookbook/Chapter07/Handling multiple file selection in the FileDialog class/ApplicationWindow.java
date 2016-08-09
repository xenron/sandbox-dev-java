package packt;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ApplicationWindow extends JFrame {
    
    public ApplicationWindow() {        
        this.setTitle("Example");
        this.setSize(200, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        this.setLayout(new FlowLayout());
        
        final FileDialog fileDialog = new FileDialog(this, "FileDialog");
        fileDialog.setMultipleMode(true);
        
        JButton fileDialogButton = new JButton("File Dialog");    
        fileDialogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fileDialog.setVisible(true);
                File files[] = fileDialog.getFiles();
                for (File file : files) {
                    System.out.println("File: " + file.getName());
                }
                
            }
        });

        this.add(fileDialogButton);
        
        JButton exitButton = new JButton("Exit");    
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        this.add(exitButton);
    }

}
