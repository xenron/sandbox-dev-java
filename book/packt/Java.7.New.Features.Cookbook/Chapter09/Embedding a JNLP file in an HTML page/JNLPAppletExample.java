package packt;

import java.applet.Applet;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JNLPAppletExample extends Applet {

    TextField subtotal = new TextField(10);
    TextField taxRate = new TextField(10);
    Button Calculate = new Button("Calculate");
    TextArea grandTot = new TextArea("Total = $", 2, 15, TextArea.SCROLLBARS_NONE);

    @Override
    public void init() {
        this.setLayout(new GridLayout(3,2));
        this.add(new Label("Subtotal = "));
        this.add(subtotal);
        this.add(new Label("Tax Rate = "));
        this.add(taxRate);
        this.add(Calculate);
        grandTot.setEditable(false);
        this.add(grandTot);
        Calculate.addActionListener(new CalcListener());
    }

    class CalcListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            double subTot;
            double tax;
            double grandTot;

            subTot = validateSubTot(subtotal.getText());
            tax = validateSubTot(taxRate.getText());
            grandTot = calculateTotal(subTot, tax);
            JNLPAppletExample.this.grandTot.setText("Total = $" + grandTot);
        }
    }

    double validateSubTot(String s) {
        double answer;
        Double d;
        try {
            d = new Double(s);
            answer = d.doubleValue();
        } catch (NumberFormatException e) {
            answer = Double.NaN;
        }
        return answer;
    }

    double calculateTotal(double subTot, double taxRate) {
        double grandTotal;
        taxRate = taxRate / 100;
        grandTotal = (subTot * taxRate) + subTot;
        return grandTotal;
    }
}
