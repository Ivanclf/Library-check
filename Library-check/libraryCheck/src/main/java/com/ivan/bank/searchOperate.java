package com.ivan.bank;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivan.bank.Book.info;;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
public class searchOperate {
    private final Map<info, Object> book = new HashMap<>();
    private Map<String, Object> fileDocument = new HashMap<>();
    public searchOperate(int id, String name, ArrayList<String> author, String publisher){
        book.put(info.id, id);
        book.put(info.name, name);
        book.put(info.author, author);
        book.put(info.publisher, publisher);
    }
    public void setJudge(boolean isIdException, boolean isNameException, boolean isAuthorException, boolean isPublisherException) {
        if(isIdException){
            book.remove(info.id);
        }
        if(isNameException){
            book.remove(info.name);
        }
        if(isAuthorException){
            book.remove(info.author);
        }
        if(isPublisherException){
            book.remove(info.publisher);
        }
    }
    public ArrayList<String> readJson(){
        String path = "dataBase/";
        File file = new File(path + "book");
        ObjectMapper om = new ObjectMapper();
        File[] fs = file.listFiles();
        ArrayList<String> result = new ArrayList<>();
        if (fs != null) {
            for(File f: fs){
                if(!f.isDirectory()){
                    fileDocument.clear();
                    try {
                        fileDocument = om.readValue(f, Map.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(isEqual(fileDocument)){
                    result.add(fileDocument.get("name") + ", " + fileDocument.get("author").toString() + ", " +  fileDocument.get("amount") + ", " + fileDocument.get("id").toString());
                }
            }
        }
        return result;
    }
    private boolean isEqual(Map<String, Object> temp){
        if(book.containsKey(info.id)){
            if (!temp.get("id").equals(book.get(info.id))){
                return false;
            }
        }
        if(book.containsKey(info.name)){
            if (!temp.get("name").equals(book.get(info.name))){
                return false;
            }
        }
        if(book.containsKey(info.author)){
            if (!temp.get("author").equals(book.get(info.author))){
                return false;
            }
        }
        if(book.containsKey(info.publisher)){
            if (!temp.get("publisher").equals(book.get(info.publisher))){
                return false;
            }
        }
        return true;
    }
}
