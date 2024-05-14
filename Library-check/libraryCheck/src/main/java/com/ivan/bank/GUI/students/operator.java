package com.ivan.bank.GUI.students;

import com.ivan.bank.GUI.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class operator {
    private JLabel tipDo;
    private JButton returnBook;
    private JButton borrowBook;
    private JButton search;
    private JList<String> bookSelect;
    private JLabel tipView;
    private JScrollPane scrollPane;
    private JPanel operator;
    public operator(){
        JFrame frame = new JFrame("operator");
        frame.setContentPane(this.operator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search(com.ivan.bank.GUI.search.mode.SEARCH);
            }
        });
        borrowBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search(com.ivan.bank.GUI.search.mode.BORROW);
            }
        });
        returnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search(com.ivan.bank.GUI.search.mode.RETURN);
            }
        });
        bookSelect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }
    public static void main(String[] args) {
        new operator();
    }
}
