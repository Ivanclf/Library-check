package com.ivan.bank.GUI.login_register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class administratorsLogin {

    private JPanel administratorsLogin;
    private JTextField idInput;
    private JLabel tipId;
    private JLabel tipPassword;
    private JPasswordField passwordInput;
    private JButton done;
    private JButton cancel;

    public administratorsLogin() {
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("administratorsLogin");
        frame.setContentPane(new administratorsLogin().administratorsLogin);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
