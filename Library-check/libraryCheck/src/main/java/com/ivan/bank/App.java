package com.ivan.bank;

import com.ivan.bank.GUI.*;

public class App {
    public static void main( String[] args ) {
        new start();
    }
    public static void isNoInput(String s) throws NoInputException {
        if(s == null || s.isEmpty()){
            throw new NoInputException("This string is empty!");
        }
    }
    public static void isNoInput(String[] s) throws NoInputException{
        if(s == null || s[0].isEmpty()){
            throw new NoInputException("This string is empty!");
        }
    }
}
