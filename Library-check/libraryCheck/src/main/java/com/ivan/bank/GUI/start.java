package com.ivan.bank.GUI;

import com.ivan.bank.GUI.login_register.*;
import com.ivan.bank.GUI.login_register.registerAccount.registerAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class start {
    private JPanel selectPage;
    private JButton student;
    private JButton administrator;
    private JButton register;

    public start() {
        JFrame frame = new JFrame("start");
        frame.setContentPane(this.selectPage);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new studentsLogin();
            }
        });
        administrator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new administratorsLogin();
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new registerAccount();
            }
        });
    }

    public static void main(String[] args) {
        new start();
    }
}
