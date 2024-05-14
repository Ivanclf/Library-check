package com.ivan.bank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivan.bank.Book.info;

import java.io.*;
import java.util.*;

import static java.lang.System.in;

public class searchOperate {
    private final Map<info, Object> book = new HashMap<>();
    private Map<String, Object> fileDocument = new HashMap<>();
    private ArrayList<Integer> idCheck = new ArrayList<>();
    String path = "dataBase/book";

    public searchOperate(int id, String name, ArrayList<String> author, String publisher) {
        book.put(info.id, id);
        book.put(info.name, name);
        book.put(info.author, author);
        book.put(info.publisher, publisher);
    }

    public void setJudge(boolean isIdException, boolean isNameException, boolean isAuthorException, boolean isPublisherException) {
        if (isIdException) {
            book.remove(info.id);
        }
        if (isNameException) {
            book.remove(info.name);
        }
        if (isAuthorException) {
            book.remove(info.author);
        }
        if (isPublisherException) {
            book.remove(info.publisher);
        }
    }

    public ArrayList<String> readJson() {
        File file = new File(path);
        var om = new ObjectMapper();
        File[] fs = file.listFiles();
        var result = new ArrayList<String>();
        if (fs != null) {
            for (File f : fs) {
                if (!f.isDirectory()) {
                    fileDocument.clear();
                    try {
                        fileDocument = om.readValue(f, Map.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (isEqual(fileDocument)) {
                    idCheck.add((Integer) fileDocument.get("id"));
                    result.add(fileDocument.get("name") + ", " + fileDocument.get("author").toString() + ", " + fileDocument.get("amount") + ", " + fileDocument.get("id").toString());
                }
            }
        }
        return result;
    }

    private boolean isEqual(Map<String, Object> temp) {
        if (book.containsKey(info.id)) {
            if (!temp.get("id").toString().matches("(.*)" + book.get(info.id).toString() + "(.*)")) {
                return false;
            }
        }
        if (book.containsKey(info.name)) {
            if (!temp.get("name").toString().matches("(.*)" + book.get(info.name).toString() + "(.*)")) {
                return false;
            }
        }
        /*
           存在尚未解决的问题：永真
         */
        if (book.containsKey(info.author)) {
            boolean test = temp.get("author").toString().matches("(.*)" + book.get(info.author).toString() + "(.*)");
            if (!temp.get("author").toString().matches("(.*)" + book.get(info.author).toString() + "(.*)")) {
                return false;
            }
        }
        if (book.containsKey(info.publisher)) {
            if (!temp.get("publisher").toString().matches("(.*)" + book.get(info.publisher).toString() + "(.*)")) {
                return false;
            }
        }
        return true;
    }

    public Integer isAvailable(int index) throws Exception{
        var om = new ObjectMapper();
        var file = new File(path + "/" + idCheck.get(index) + ".json");
        if (!file.isDirectory()) {
            fileDocument.clear();
            fileDocument = om.readValue(file, Map.class);
        }
        if (fileDocument.get("amount").toString().equals("0")){
            return null;
        }
        else {
            fileDocument.put("amount", (Integer) fileDocument.get("amount") - 1);
            FileWriter temp = new FileWriter( path  + "/" + fileDocument.get("id") + ".json");
            temp.write(om.writerWithDefaultPrettyPrinter().writeValueAsString(fileDocument) + "\n");
            temp.close();
            return (Integer) fileDocument.get("amount");
        }
    }
}
