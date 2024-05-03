package com.ivan.bank.Book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;

public class book {
    public enum info{
        id, amount, name, author, publisher
    }
    private final Map<info, Object> bookData = new HashMap<>();

    public book(int id, int amount, String name, ArrayList<String> author, String publisher) {
        bookData.put(info.id, id);
        bookData.put(info.amount, amount);
        bookData.put(info.name, name);
        bookData.put(info.author, author);
        bookData.put(info.publisher, publisher);
        this.save();
    }

    private void save() {
        ObjectMapper book = new ObjectMapper();
        try(FileWriter temp = new FileWriter("dataBase/book/" + bookData.get(info.id) + ".json")) {
            try {
                temp.write(book.writerWithDefaultPrettyPrinter().writeValueAsString(bookData) + "\n");
                temp.close();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
