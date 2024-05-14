package com.ivan.bank.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.ivan.bank.GUI.search.mode;

public class operatorAdminisrators {
    private JLabel tipDo;
    private JPanel operator;
    private JButton search;
    private JButton addBook;
    private JButton declineBook;
    private JButton modifyData;
    private JList<String> bookSelect;
    private JLabel tipView;
    private JScrollPane scrollPane;
    public operatorAdminisrators(){
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
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addInfo();
            }
        });
        declineBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search(mode.DECLINE);
            }
        });
        modifyData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search(mode.CHANGE);
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
        new operatorAdminisrators();
    }
}
