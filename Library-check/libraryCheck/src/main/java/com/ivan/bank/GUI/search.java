package com.ivan.bank.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class search {
    public enum mode {
        ADD, BORROW, CHANGE, DECLINE, RETURN, SEARCH, VIEW
    }
    private JPanel search;
    private JLabel tipId;
    private JTextField idInput;
    private JLabel tipName;
    private JTextField nameInput;
    private JLabel tipAuthor;
    private JTextField authorInput;
    private JLabel tipPublisher;
    private JTextField publisherInput;
    private JButton done;
    private JButton cancel;
    protected JList<String> listResult;
    private JLabel tipResult;
    private JScrollPane scrollPane;

    public search(mode mode) {
        JFrame frame = new JFrame("search");
        frame.setContentPane(this.search);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        done.setText((mode.toString()).toLowerCase());
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        listResult.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    public static void main(String[] args) {
        new search(mode.SEARCH);
    }
}
