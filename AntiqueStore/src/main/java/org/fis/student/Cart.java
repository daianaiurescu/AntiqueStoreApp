package org.fis.student;

import javafx.collections.ObservableList;

public class Cart {
    private ObservableList<Book> books;
    private String total;
    public Cart(ObservableList<Book> books){
        this.books=books;
    }
    public void setBooks(ObservableList<Book> books) {
        this.books = books;
    }
    public void setTotal(String total){
        this.total=total;
    }
    public ObservableList<Book> getBooks(){
        return books;
    }
    public String getTotal(){
        return total;
    }
}
