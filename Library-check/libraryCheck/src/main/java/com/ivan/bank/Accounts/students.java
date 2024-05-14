package com.ivan.bank.Accounts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class students extends accounts{
    public students(int id, String password, String userName) {
        super(id, password, userName);
    }
    public void save() {
        ObjectMapper accounts = new ObjectMapper();
        try(FileWriter temp = new FileWriter("dataBase/students/" + accountsData.get(info.id) + ".json")) {
            try {
                temp.write(accounts.writerWithDefaultPrettyPrinter().writeValueAsString(accountsData) + "\n");
                temp.close();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void addBook(ArrayList<Integer> id){
        accountsData.put(info.borrow, id);
    }
    public void declineBook(ArrayList<Integer> id){

    }
}
