package com.ivan.bank;

import com.ivan.bank.Book.book;

import java.util.ArrayList;

public class addBook {
    public static void main(String[] args){
        new book(10001, 2, "haoHao: a crazy successor", new ArrayList<>(){{add("haoHao"); add("aBin");}}, "XJTU Publisher");
    }
}
