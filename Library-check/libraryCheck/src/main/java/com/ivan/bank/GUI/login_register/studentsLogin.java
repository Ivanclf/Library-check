package com.ivan.bank.GUI.login_register;

import com.ivan.bank.GUI.start;
import com.ivan.bank.GUI.students.operator;

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
        JFrame frame = new JFrame("studentsLogin");
        frame.setContentPane(this.studentsLogin);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new operator();
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
        new studentsLogin();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
