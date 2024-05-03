package com.ivan.bank.GUI.administrators;

import com.ivan.bank.GUI.search;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class operator {
    private JLabel tipDo;
    private JPanel operator;
    private JButton search;
    private JButton addBook;
    private JButton declineBook;
    private JButton modifyData;
    private JList<String> bookSelect;
    private JLabel tipView;
    private JScrollPane scrollPane;
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
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search(com.ivan.bank.GUI.search.mode.ADD);
            }
        });
        declineBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search(com.ivan.bank.GUI.search.mode.DECLINE);
            }
        });
        modifyData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search(com.ivan.bank.GUI.search.mode.CHANGE);
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
