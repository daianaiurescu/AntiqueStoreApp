package org.fis.student.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.fis.student.Book;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BookService {
    public static ObservableList<Book> books;

    public static ObservableList<Book> readFromFile(String fileName) throws IOException, ParseException {
        books = FXCollections.observableArrayList();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(fileName);
        Object obj = jsonParser.parse(reader);

        JSONArray bookList = (JSONArray) obj;

        for (Object book : bookList) {
            JSONObject o = (JSONObject) book;
            Book b = new Book(o.get("title").toString(), o.get("author").toString(), o.get("publishingHouse").toString(), o.get("year").toString(),
                    o.get("price").toString(), o.get("quantity").toString());
            books.add(b);
        }
        return books;

    }

    public static void writeBooks(String fileName, ObservableList<Book> bookList) throws IOException {
        FileWriter file = new FileWriter(fileName);

        JSONArray books = new JSONArray();
        for (Book aux: bookList){
            JSONObject bookDetails = new JSONObject();
            bookDetails.put("title", aux.getTitle());
            bookDetails.put("author", aux.getAuthor());
            bookDetails.put("publishingHouse", aux.getPublishingHouse());
            bookDetails.put("price", aux.getPrice());
            bookDetails.put("year", aux.getYear());
            bookDetails.put("quantity", aux.getQuantity());

            JSONObject obj = new JSONObject();
            books.add(bookDetails);
        }

        file.write(books.toJSONString());
        file.flush();
    }
}
