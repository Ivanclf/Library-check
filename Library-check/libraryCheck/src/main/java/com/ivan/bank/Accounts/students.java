package com.ivan.bank.Accounts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class students extends accounts{
    public students(int id, String password, String userName) {
        super(id, password, userName);
    }
    public void save() throws Exception{
        ObjectMapper accounts = new ObjectMapper();
        FileWriter temp = new FileWriter("dataBase/students/" + accountsData.get(info.id) + ".json");
        temp.write(accounts.writerWithDefaultPrettyPrinter().writeValueAsString(accountsData) + "\n");
        temp.close();
    }
    public void addBook(int id){
        accountsData.put(info.borrow, id);
    }
    public void declineBook(int id){

    }
}
