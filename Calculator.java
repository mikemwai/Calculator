import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener
{
    JButton[] numbers;
    JButton plus;
    JButton minus;
    JButton mult;
    JButton div;
    JButton equals;
    JButton dot;
    JTextField output;
    JTextField operand1;
    JTextField operand2;

    public Calculator() {
        super("Calculator");
        numbers = new JButton[10];
        for (int i = 0; i < 10; i++)
            numbers[i] = new JButton("" + i);
        plus = new JButton("+");
        plus.addActionListener(this);
        minus = new JButton("-");
        minus.addActionListener(this);
        mult = new JButton("x");
        mult.addActionListener(this);
        div = new JButton("/");
        div.addActionListener(this);
        equals = new JButton("=");
        equals.addActionListener(this);
        dot = new JButton(".");
        dot.addActionListener(this);
        for (int i = 0; i < 10; i++) {
            numbers[i].addActionListener(this);
        }

        setSize(400, 500);
        operand1 = new JTextField(7);
        operand2 = new JTextField(7);
        output = new JTextField(15);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(2,1));
        add(top, BorderLayout.NORTH);
        JPanel input = new JPanel();
        input.add(operand1);
        input.add(operand2);
        top.add(input);


        JPanel results = new JPanel();
        results.add(output);
        top.add(results);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(4,1));
        center.add(getRow(numbers[7], numbers[8], numbers[9], plus));
        center.add(getRow(numbers[4], numbers[5], numbers[6], minus));
        center.add(getRow(numbers[1], numbers[2], numbers[3], mult));
        center.add(getRow(dot, numbers[0], equals, div));
        add(center);

        add(center);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();
        if (input.equals("+"))
        {
            double operand1Value = Double.parseDouble(operand1.getText());
            double operand2Value = Double.parseDouble(operand2.getText());
            double result = operand1Value + operand2Value;
            output.setText("" + result);
        }
        else if (input.equals("-"))
        {
            double operand1Value = Double.parseDouble(operand1.getText());
            double operand2Value = Double.parseDouble(operand2.getText());
            double result = operand1Value - operand2Value;
            output.setText("" + result);
        }
        else if (input.equals("x"))
        {
            double operand1Value = Double.parseDouble(operand1.getText());
            double operand2Value = Double.parseDouble(operand2.getText());
            double result = operand1Value * operand2Value;
            output.setText("" + result);
        }
        else if (input.equals("/"))
        {
            double operand1Value = Double.parseDouble(operand1.getText());
            double operand2Value = Double.parseDouble(operand2.getText());
            double result = operand1Value / operand2Value;
            output.setText("" + result);
        }
        else if (input.equals("="))
        {
            double operand1Value = Double.parseDouble(operand1.getText());
            double operand2Value = Double.parseDouble(operand2.getText());
            double result = 0;
            if (plus.getModel().isPressed()) {
                result = operand1Value + operand2Value;
            } else if (minus.getModel().isPressed()) {
                result = operand1Value - operand2Value;
            } else if (mult.getModel().isPressed()) {
                result = operand1Value * operand2Value;
            } else if (div.getModel().isPressed()) {
                result = operand1Value / operand2Value;
            }
            output.setText("" + result);
        }
        else if (input.equals(".")) {
            operand1.setText(operand1.getText() + ".");
        }
        else {
            operand1.setText(operand1.getText() + input);
        }
    }
    private JPanel
    getRow(JButton b1, JButton b2, JButton b3, JButton b4)
    {
        JPanel row = new JPanel();
        row.setLayout(new BoxLayout(row,BoxLayout.X_AXIS));
        row.add(Box.createHorizontalGlue());
        row.add(b1);row.add(b2);row.add(b3);row.add(b4);
        row.add(Box.createHorizontalGlue());
        return row;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
