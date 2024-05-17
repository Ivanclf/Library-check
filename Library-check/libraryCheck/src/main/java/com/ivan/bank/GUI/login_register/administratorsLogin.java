package com.ivan.bank.GUI.login_register;

import com.ivan.bank.GUI.operatorAdministrators;
import com.ivan.bank.GUI.start;

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
        JFrame frame = new JFrame("administratorsLogin");
        frame.setContentPane(this.administratorsLogin);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new operatorAdministrators();
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new start();
                frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new administratorsLogin();
    }
}
