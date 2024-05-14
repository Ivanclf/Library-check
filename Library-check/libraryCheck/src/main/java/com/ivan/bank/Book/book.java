package com.ivan.bank.Book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class book {

    private final Map<info, Object> bookData = new HashMap<>();

    public book(int id, int amount, String name, ArrayList<String> author, String publisher) {
        bookData.put(info.id, id);
        bookData.put(info.amount, amount);
        bookData.put(info.name, name);
        bookData.put(info.author, author);
        bookData.put(info.publisher, publisher);
        try {
            this.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save() throws Exception{
        ObjectMapper book = new ObjectMapper();
        String path = "dataBase/book/";

        FileWriter temp = new FileWriter( path + bookData.get(info.id) + ".json");
        temp.write(book.writerWithDefaultPrettyPrinter().writeValueAsString(bookData) + "\n");
        temp.close();
    }
}
