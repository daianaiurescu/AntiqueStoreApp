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

    public SimpleStringProperty bookTitleProperty() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle.set(bookTitle);
    }

    public String getBookAuthor() {
        return bookAuthor.get();
    }

    public SimpleStringProperty bookAuthorProperty() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor.set(bookAuthor);
    }

    public String getBookPublishingHouse() {
        return bookPublishingHouse.get();
    }

    public SimpleStringProperty bookPublishingHouseProperty() {
        return bookPublishingHouse;
    }

    public void setBookPublishingHouse(String bookPublishingHouse) {
        this.bookPublishingHouse.set(bookPublishingHouse);
    }

    public String getBookYear() {
        return bookYear.get();
    }

    public SimpleStringProperty bookYearProperty() {
        return bookYear;
    }

    public void setBookYear(String bookYear) {
        this.bookYear.set(bookYear);
    }

    public String getDonorFirstName() {
        return donorFirstName.get();
    }

    public SimpleStringProperty donorFirstNameProperty() {
        return donorFirstName;
    }

    public void setDonorFirstName(String donorFirstName) {
        this.donorFirstName.set(donorFirstName);
    }

    public String getDonorLastName() {
        return donorLastName.get();
    }

    public SimpleStringProperty donorLastNameProperty() {
        return donorLastName;
    }

    public void setDonorLastName(String donorLastName) {
        this.donorLastName.set(donorLastName);
    }

    public String getDonorEmail() {
        return donorEmail.get();
    }

    public SimpleStringProperty donorEmailProperty() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail.set(donorEmail);
    }

    public String getDonorPhoneNumber() {
        return donorPhoneNumber.get();
    }

    public SimpleStringProperty donorPhoneNumberProperty() {
        return donorPhoneNumber;
    }

    public void setDonorPhoneNumber(String donorPhoneNumber) {
        this.donorPhoneNumber.set(donorPhoneNumber);
    }

    public Donation getDonation(){
        return this;
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