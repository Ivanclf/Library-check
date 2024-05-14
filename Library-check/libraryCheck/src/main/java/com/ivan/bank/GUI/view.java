package com.ivan.bank.GUI;

import javax.swing.*;
import java.util.Map;

public class view {
    private JLabel tipId;
    private JLabel idPut;
    private JLabel tipName;
    private JLabel namePut;
    private JLabel tipAuthor;
    private JLabel tipPublisher;
    private JLabel publisherPut;
    private JLabel authorPut;
    private JPanel view;
    public view(Map<String, Object> book){
        JFrame frame = new JFrame("view");
        frame.setContentPane(this.view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        idPut.setText(book.get("id").toString());
        namePut.setText(book.get("name").toString());
        authorPut.setText(book.get("author").toString().replace("[", "").replace("]", ""));
        publisherPut.setText(book.get("publisher").toString());
    }

    public static void main(String[] args) {
        new view(null);
    }
}
