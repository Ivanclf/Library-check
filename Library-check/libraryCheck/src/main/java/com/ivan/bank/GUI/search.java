package com.ivan.bank.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

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
    boolean isIdException;
    boolean isNameException;
    boolean isAuthorException;
    boolean isPublisherException;
    searchOperate so;

    public search(mode mode) {
        JFrame frame = new JFrame("search");
        frame.setContentPane(this.search);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isIdException = false;
                isNameException = false;
                isAuthorException = false;
                isPublisherException = false;
                listModel.clear();
                listResult.setModel(listModel);
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
                        author.addAll(Arrays.asList(temp));
                    }
                }

                publisher = publisherInput.getText();
                try {
                    isNoInput(publisher);
                } catch (NoInputException ed){
                    isPublisherException = true;
                }

                so = new searchOperate(id, name, author, publisher);
                so.setJudge(isIdException, isNameException, isAuthorException, isPublisherException);
                ArrayList<String> result = so.readJson();

                for (String s : result) {
                    listModel.addElement(s);
                }

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
                if(e.getClickCount() == 2){
                    switch (mode){
                        case SEARCH:
                            JOptionPane.showMessageDialog(null, "Only for searching", "Title",JOptionPane.WARNING_MESSAGE);
                            break;
                        case BORROW:
                            int index = listResult.locationToIndex(e.getPoint());
                            try {
                                if(so.isAvailable (index) == null){
                                    JOptionPane.showMessageDialog(null, "There have been no book to be borrowed!", "Title",JOptionPane.WARNING_MESSAGE);

                                }
                                else {
                                    JOptionPane.showMessageDialog(null, "Borrow success!");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case RETURN:break;
                        case ADD:break;
                        case DECLINE:break;
                        case CHANGE:break;
                        case VIEW:break;
                    }
                }
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
