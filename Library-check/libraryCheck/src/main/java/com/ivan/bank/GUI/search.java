package com.ivan.bank.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.ivan.bank.*;

import static com.ivan.bank.App.isNoInput;

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
    private String name, publisher;
    private ArrayList<String> author = new ArrayList<>();
    boolean isIdException, isNameException, isAuthorException, isPublisherException;
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
                } catch (NumberFormatException ea) {
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
                } catch (NoInputException ec) {
                    isAuthorException = true;
                }

                publisher = publisherInput.getText();
                try {
                    isNoInput(publisher);
                } catch (NoInputException ed) {
                    isPublisherException = true;
                }

                so = new searchOperate(id, name, author, publisher);
                so.setJudge(isIdException, isNameException, isAuthorException, isPublisherException);
                ArrayList<String> result = so.readJsonAll();

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
                if (e.getClickCount() == 2) {
                    int index = listResult.locationToIndex(e.getPoint());
                    int id = so.getIdCheck().get(index);
                    switch (mode) {
                        case SEARCH:
                            JOptionPane.showMessageDialog(null, "Only for searching", "Title", JOptionPane.WARNING_MESSAGE);
                            break;
                        case BORROW:

                            try {
                                if (so.isAvailable(index) == null) {
                                    JOptionPane.showMessageDialog(null, "There have been no book to be borrowed!", "Title", JOptionPane.WARNING_MESSAGE);
                                } else {

                                    JOptionPane.showMessageDialog(null, "Borrow success!");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            break;
                        case DECLINE:
                            var option = JOptionPane.showConfirmDialog(null, "Delete?", "Delete?", JOptionPane.YES_NO_OPTION);
                            if (option == 0) {
                                try {
                                    so.delete(index);
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                listModel.remove(index);
                                listResult.repaint();
                            }
                            break;
                        case CHANGE:
                            new addInfo(so.readJsonOne(id));
                            break;
                        case VIEW:
                            id = so.getIdCheck().get(index);
                            new view(so.readJsonOne(id));
                            break;
                        default:
                            System.out.println("Unexpected value: " + mode);
                    }
                }
            }
        });
    }
    public static void main(String[] args) {
        new search(mode.DECLINE);
    }
}