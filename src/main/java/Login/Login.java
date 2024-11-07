package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel newHereLabel;
    private JButton registerButton;

    public Login() {
        setTitle("Colorful Login Interface");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, Color.CYAN, getWidth(), getHeight(), Color.MAGENTA);
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(new GridBagLayout());
        add(mainPanel);

        JLabel titleLabel = new JLabel("Hi There! Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);

        usernameField = new JTextField(15);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        passwordField = new JPasswordField(15);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);

        newHereLabel = new JLabel("New here?");
        newHereLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        newHereLabel.setForeground(Color.WHITE);

<<<<<<< HEAD
        registerButton = createStyledButton("Register", "#ffffff", "#343a40");
        registerButton.addActionListener(e -> JOptionPane.showMessageDialog(mainPanel, "Redirecting to Registration Page..."));

        // Create a sub-panel to hold "New here?" and "Register" button side by side
        JPanel newHerePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0)); // 5px gap, no vertical gap
        newHerePanel.setOpaque(false); // Transparent background for the panel
        newHerePanel.add(Box.createHorizontalStrut(80)); // Horizontal spacing
        newHerePanel.add(newHereLabel);
        newHerePanel.add(Box.createHorizontalStrut(-10)); // Horizontal spacing
        newHerePanel.add(registerButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 50, 10, 10);
=======
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "Redirecting to Registration Page...");
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
>>>>>>> fd018781fb295ca2b1bc8f4290994871808d0d4c

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 40, 10, 10); // 40px padding on the left
        mainPanel.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10); // extra padding
        mainPanel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 70, 10, 10); // 70px padding on the left
        mainPanel.add(loginButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 0, 0); // No extra padding for "New here?" and "Register" panel
        mainPanel.add(newHerePanel, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = getUsername();
                String password = getPassword();
                JOptionPane.showMessageDialog(mainPanel, "Login attempt by: " + username);
            }
        });
    }

<<<<<<< HEAD
    private JButton createStyledButton(String text, String textColorHex, String bgColorHex) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setForeground(Color.decode(textColorHex));
        button.setBackground(Color.decode(bgColorHex));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false); // Transparent background
        return button;
    }

=======
>>>>>>> fd018781fb295ca2b1bc8f4290994871808d0d4c
    public String getUsername() {
        return usernameField.getText();
    }

    public void setUsername(String username) {
        this.usernameField.setText(username);
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void setPassword(String password) {
        this.passwordField.setText(password);
    }
<<<<<<< HEAD

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login frame = new Login();
            frame.setVisible(true);
        });
    }
=======
>>>>>>> fd018781fb295ca2b1bc8f4290994871808d0d4c
}
