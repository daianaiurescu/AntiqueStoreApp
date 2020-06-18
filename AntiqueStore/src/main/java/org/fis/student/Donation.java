package org.fis.student;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class Donation {
    private SimpleStringProperty bookTitle, bookAuthor, bookPublishingHouse, bookYear;
    private SimpleStringProperty donorFirstName, donorLastName, donorEmail, donorPhoneNumber;

    public Donation(String bookTitle, String bookAuthor, String bookPublishingHouse, String bookYear,
                    String donorFirstName, String donorLastName, String donorEmail, String donorPhoneNumber){
        this.bookTitle = new SimpleStringProperty(bookTitle);
        this.bookAuthor = new SimpleStringProperty(bookAuthor);
        this.bookPublishingHouse = new SimpleStringProperty(bookPublishingHouse);
        this.bookYear = new SimpleStringProperty(bookYear);
        this.donorFirstName = new SimpleStringProperty(donorFirstName);
        this.donorLastName = new SimpleStringProperty(donorLastName);
        this.donorEmail = new SimpleStringProperty(donorEmail);
        this.donorPhoneNumber = new SimpleStringProperty(donorPhoneNumber);
    }


    public String getBookTitle() {
        return bookTitle.get();
    }

    public String getBookAuthor() {
        return bookAuthor.get();
    }

    public String getBookPublishingHouse() {
        return bookPublishingHouse.get();
    }

    public String getBookYear() {
        return bookYear.get();
    }

    public String getDonorFirstName() {
        return donorFirstName.get();
    }

    public String getDonorLastName() {
        return donorLastName.get();
    }

    public String getDonorEmail() {
        return donorEmail.get();
    }

    public String getDonorPhoneNumber() {
        return donorPhoneNumber.get();
    }

    public boolean equals(Object d){
        if(d instanceof Donation){
        if(((Donation) d).getBookTitle().equals(this.getBookTitle()) && ((Donation) d).getBookAuthor().equals(this.getBookAuthor()) &&
                ((Donation) d).getBookPublishingHouse().equals(this.getBookPublishingHouse()) &&
                ((Donation) d).getBookYear().equals(this.getBookYear()) && ((Donation) d).getDonorFirstName().equals(this.getDonorFirstName())
                && ((Donation) d).getDonorLastName().equals(this.getDonorLastName()) &&
        ((Donation) d).getDonorEmail().equals(this.getDonorEmail()) && ((Donation) d).getDonorPhoneNumber().equals(this.getDonorPhoneNumber()))
            return true;}
        return false;
    }

}