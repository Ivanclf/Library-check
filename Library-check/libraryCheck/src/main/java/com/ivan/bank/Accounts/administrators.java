package com.ivan.bank.Accounts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class administrators extends accounts{
    public administrators(int id, String password, String userName) {
        super(id, password, userName);
        this.save();
    }
    private void save() {
        ObjectMapper accounts = new ObjectMapper();
        try(FileWriter temp = new FileWriter("dataBase/administrators/" + accountsData.get(info.id) + ".json")) {
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
}
