package com.ivan.bank;

import com.ivan.bank.Book.book;

import java.util.ArrayList;

public class addBook {
    public static void main(String[] args){
        var name = "haoHao: a billionaire";
        var author = new ArrayList<String>(){{add("haoHao"); add("aBin");}};
        var publisher = "XJTU Publisher";
        new book(String.join(name, author.toString(), publisher).hashCode(), 50, name, author, publisher);
    }
}
