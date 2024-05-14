package com.ivan.bank.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.ivan.bank.GUI.search.mode;

public class operatorStudents {
    private JLabel tipDo;
    private JButton returnBook;
    private JButton borrowBook;
    private JButton search;
    private JList<String> bookSelect;
    private JLabel tipView;
    private JScrollPane scrollPane;
    private JPanel operator;
    public operatorStudents(){
        JFrame frame = new JFrame("operator");
        frame.setContentPane(this.operator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search(mode.VIEW);
            }
        });
        borrowBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search(mode.BORROW);
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
        new operatorStudents();
    }
}
