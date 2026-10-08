import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {

    JLabel usernameLabel, passwordLabel, messageLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;

    public LoginForm() {
        setTitle("Login Form");
        setSize(350, 250);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Username
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);

        // Password
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);

        // Login button
        loginButton = new JButton("Login");

        // Message
        messageLabel = new JLabel("");

        // Add components
        add(usernameLabel);
        add(usernameField);

        add(passwordLabel);
        add(passwordField);

        add(loginButton);
        add(messageLabel);

        // Event handling
        loginButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Simple login validation
        if (username.equals("admin") && password.equals("1234")) {
            messageLabel.setText("Login Successful!");
        } else {
            messageLabel.setText("Invalid Username or Password");
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}