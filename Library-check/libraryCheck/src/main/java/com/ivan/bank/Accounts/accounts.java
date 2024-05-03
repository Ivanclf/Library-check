package com.ivan.bank.Accounts;

import java.util.*;

public abstract class accounts {
    public enum info{
        id, password, name
    }
    Map<info, Object> accountsData = new HashMap<>();

    accounts(int id, String password, String name){
        accountsData.put(info.id, id);
        accountsData.put(info.password, password);
        accountsData.put(info.name, name);
    }
}
