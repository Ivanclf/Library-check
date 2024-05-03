package com.ivan.bank.GUI.login_register.registerAccount;

import com.ivan.bank.GUI.start;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerAccount {
    private JPanel registerAccount;
    private JLabel tipMode;
    private JRadioButton students;
    private JRadioButton administrators;
    private JLabel tipId;
    private JTextField idInput;
    private JLabel tipPassword1;
    private JPasswordField passwordInput1;
    private JLabel tipPassword2;
    private JPasswordField passwordInput2;
    private JLabel tipInviCode1;
    private JTextField inviCode;
    private JButton done;
    private JButton cancel;

    public registerAccount() {
        JFrame frame = new JFrame("register");
        frame.setContentPane(this.registerAccount);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        students.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        administrators.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        new registerAccount();
    }


}
