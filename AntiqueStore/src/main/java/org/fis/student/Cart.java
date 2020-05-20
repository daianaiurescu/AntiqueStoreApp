package org.fis.student;

import javafx.collections.ObservableList;

public class Cart {
    private ObservableList<Book> books;
    private Double total;
    public Cart(ObservableList<Book> books){
        this.books=books;
    }
    public void setBooks(ObservableList<Book> books) {
        this.books = books;
    }
    public void setTotal(Double total){
        this.total=total;
    }
    public ObservableList<Book> getBooks(){
        return books;
    }
    public Double getTotal(){
        return total;
    }
}
