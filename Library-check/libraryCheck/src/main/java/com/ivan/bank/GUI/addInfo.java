package com.ivan.bank.GUI;

import com.ivan.bank.Book.book;
import com.ivan.bank.Book.info;
import com.ivan.bank.NoInputException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import static com.ivan.bank.App.*;

public class addInfo {
    private JTextField nameInput;
    private JLabel tipName;
    private JLabel tipAuthor;
    private JTextField authorInput;
    private JLabel tipPublisher;
    private JTextField publisherInput;
    private JButton done;
    private JButton cancel;
    private JPanel addInfo;

    public static void main(String[] args) {
        new addInfo();
    }

    public addInfo() {
        JFrame frame = new JFrame("addInfo");
        frame.setContentPane(this.addInfo);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var option = JOptionPane.showConfirmDialog(null, "Add this book?", "Add this book", JOptionPane.YES_NO_OPTION);
                if(option == 0){
                    String name, publisher;
                    var author = new ArrayList<String>();
                    name = nameInput.getText();
                    try {
                        isNoInput(name);
                    } catch (NoInputException ex) {
                        name = "Unknown";
                    }
                    String[] temp = authorInput.getText().split(" ");
                    try {
                        isNoInput(temp);
                    } catch (NoInputException ec){
                        author.add("Unknown");
                    }

                    publisher = publisherInput.getText();
                    try {
                        isNoInput(publisher);
                    } catch (NoInputException ed){
                        publisher = "Unknown";
                    }
                    String path = "dataBase/book/";
                    int id = String.join(name, author.toString(), publisher).hashCode();

                    while (hasFile(path, id + ".json")){
                        id += 1;
                    }
                    new book(id, 50, name, author, publisher);
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
    public addInfo(Map<String, Object> book) {
        JFrame frame = new JFrame("addInfo");
        frame.setContentPane(this.addInfo);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var option = JOptionPane.showConfirmDialog(null, "Change this book?", "Change this book?", JOptionPane.YES_NO_OPTION);
                if (option == 0) {
                    String name, publisher;
                    nameInput.setText(book.get("name").toString());
                    authorInput.setText(book.get("author").toString().replace("[", "").replace("]", ""));
                    publisherInput.setText(book.get("publisher").toString());
                    int id = (int) book.get("id");
                    var author = new ArrayList<String>();
                    name = nameInput.getText();
                    try {
                        isNoInput(name);
                    } catch (NoInputException ex) {
                        name = "Unknown";
                    }
                    String[] temp = authorInput.getText().split(" ");
                    try {
                        isNoInput(temp);
                    } catch (NoInputException ec){
                        author.add("Unknown");
                    }

                    publisher = publisherInput.getText();
                    try {
                        isNoInput(publisher);
                    } catch (NoInputException ed){
                        publisher = "Unknown";
                    }
                    new book(id, 50, name, author, publisher);
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

    public static boolean hasFile(String path, String fileName) {
        Path directory = Paths.get(path);

        if (!Files.exists(directory) || !Files.isDirectory(directory)) {
            System.out.println("Not in this tree");
            return false;
        }

        Path targetFile = directory.resolve(fileName);
        return Files.exists(targetFile) && Files.isRegularFile(targetFile);
    }
}
