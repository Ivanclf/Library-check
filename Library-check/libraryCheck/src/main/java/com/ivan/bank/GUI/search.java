package com.ivan.bank.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

import com.ivan.bank.*;

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
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    protected JList<String> listResult;
    private JLabel tipResult;
    private JScrollPane scrollPane;
    private int id = 0;
    private String name;
    private ArrayList<String> author = new ArrayList<>();
    private String publisher;
    boolean isIdException = false;
    boolean isNameException = false;
    boolean isAuthorException = false;
    boolean isPublisherException = false;

    public search(mode mode) {
        JFrame frame = new JFrame("search");
        frame.setContentPane(this.search);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        done.setText((mode.toString()).toLowerCase());

        done.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                if(!(listModel == null || listModel.isEmpty())){
                    listModel.clear();
                }
                try {
                    id = Integer.parseInt(idInput.getText());
                }catch (NumberFormatException ea){
                    isIdException = true;
                }
                name = nameInput.getText();
                try {
                    isNoInput(name);
                } catch (NoInputException eb) {
                    isNameException = true;
                }
                String[] temp = authorInput.getText().split(" ");
                try {
                    isNoInput(temp);
                } catch (NoInputException ec){
                    isAuthorException = true;
                } finally {
                    if (!isAuthorException) {
                        author = (ArrayList<String>) Arrays.asList(temp);
                    }
                }
                publisher = publisherInput.getText();
                try {
                    isNoInput(publisher);
                } catch (NoInputException ed){
                    isPublisherException = true;
                }
                searchOperate so = new searchOperate(id, name, author, publisher);
                so.setJudge(isIdException, isNameException, isAuthorException, isPublisherException);
                ArrayList<String> result = so.readJson();
                for (String s : result) {
                    listModel.addElement(s);
                }
                listResult.setModel(listModel);
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
    private void isNoInput(String s) throws NoInputException{
        if(s == null || s.isEmpty()){
            throw new NoInputException("This string is empty!");
        }
    }
    private void isNoInput(String[] s) throws NoInputException{
        if(s == null || s[0].isEmpty()){
            throw new NoInputException("This string is empty!");
        }
    }
}
