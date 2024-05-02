package com.ivan.bank.GUI.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class studentsLogin {
    private JPanel studentsLogin;
    private JTextField idInput;
    private JPasswordField passwordInput;
    private JLabel tipId;
    private JLabel tipPassword;
    private JButton done;
    private JButton cancel;

    public studentsLogin() {
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
