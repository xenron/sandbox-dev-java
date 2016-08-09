package packt;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.DialogTypeSelection;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ApplicationWindow extends JFrame {
    
    public ApplicationWindow() {        
        this.setTitle("Example");
        this.setSize(200, 100);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        this.setLayout(new FlowLayout());
                
                JColorChooser.showDialog(this, null, Color.blue);
        JButton printDialogButton = new JButton("Print Dialog");    
        printDialogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                final PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
                attributes.add(DialogTypeSelection.COMMON);
                PrinterJob printJob = PrinterJob.getPrinterJob();
                printJob.printDialog(attributes);

            }
        });
        this.add(printDialogButton);
        
        JButton exitButton = new JButton("Exit");    
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        this.add(exitButton);
    }

}
