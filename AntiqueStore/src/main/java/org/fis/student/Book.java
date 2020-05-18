package org.fis.student;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    private SimpleStringProperty title, author, publishingHouse;
    private SimpleStringProperty year, quantity;
    private SimpleStringProperty price;

    public Book(String title, String author, String publishingHouse, String year, String price, String quantity){
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.publishingHouse = new SimpleStringProperty(publishingHouse);
        this.year = new SimpleStringProperty(year);
        this.quantity = new SimpleStringProperty(quantity);
        this.price = new SimpleStringProperty(price);
    }

    public String getTitle(){
        return title.get();
    }

    public String getAuthor() {
        return author.get();
    }

    public String getPublishingHouse(){
        return publishingHouse.get();
    }

    public String getYear(){
        return year.get();
    }

    public String getQuantity(){
        return quantity.get();
    }

    public void setTitle(String title){
        this.title.set(title);
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse.set(publishingHouse);
    }

    public void setYear(String year){
        this.year.set(year);
    }

    public void setQuantity(String quantity){
        this.quantity.set(quantity);
    }


    public String getPrice() {
        return price.get();
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
}
