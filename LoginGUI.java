package com.paperless.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Paperless World - Login");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JLabel message = new JLabel();

        frame.add(userLabel);
        frame.add(userText);
        frame.add(passLabel);
        frame.add(passText);
        frame.add(loginButton);
        frame.add(message);

        loginButton.addActionListener(e -> {
            String user = userText.getText();
            String pass = new String(passText.getPassword());
            if (user.equals("admin") && pass.equals("admin123")) {
                message.setText("Login Successful!");
            } else {
                message.setText("Invalid Credentials");
            }
        });

        frame.setVisible(true);
    }
}

