import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    JTextField num1Field, num2Field;
    JLabel resultLabel;
    JButton addButton, subButton, mulButton, divButton;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Input fields
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);

        // Result label
        resultLabel = new JLabel("Result: ");

        // Buttons
        addButton = new JButton("Addition");
        subButton = new JButton("Subtraction");
        mulButton = new JButton("Multiplication");
        divButton = new JButton("Division");

        // Add components
        add(new JLabel("Enter First Number:"));
        add(num1Field);

        add(new JLabel("Enter Second Number:"));
        add(num2Field);

        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);

        add(resultLabel);

        // Add action listeners
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            }
            else if (e.getSource() == subButton) {
                result = num1 - num2;
            }
            else if (e.getSource() == mulButton) {
                result = num1 * num2;
            }
            else if (e.getSource() == divButton) {
                if (num2 == 0) {
                    resultLabel.setText("Result: Cannot divide by zero");
                    return;
                }
                result = num1 / num2;
            }

            resultLabel.setText("Result: " + result);

        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
