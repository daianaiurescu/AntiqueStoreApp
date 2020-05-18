package org.fis.student;

public class Donation {
    private String donorFirstName, donorLastName, donorEmail, donorPhoneNumber;
    private String bookTitle, bookAuthor, bookPublishingHouse, bookYearOfPublishing;

    public Donation(String donorFirstName, String donorLastName, String donorEmail,  String donorPhoneNumber,
                    String bookTitle, String bookAuthor, String bookPublishingHouse, String bookYearOfPublishing){
        this.donorFirstName = donorFirstName;
        this.donorLastName = donorLastName;
        this.donorEmail = donorEmail;
        this.donorPhoneNumber = donorPhoneNumber;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublishingHouse = bookPublishingHouse;
        this.bookYearOfPublishing = bookYearOfPublishing;
    }

    public String getDonorFirstName() {
        return donorFirstName;
    }

    public void setDonorFirstName(String donorFirstName) {
        this.donorFirstName = donorFirstName;
    }

    public String getDonorLastName() {
        return donorLastName;
    }

    public void setDonorLastName(String donorLastName) {
        this.donorLastName = donorLastName;
    }

    public String getDonorEmail() {
        return donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public String getDonorPhoneNumber() {
        return donorPhoneNumber;
    }

    public void setDonorPhoneNumber(String donorPhoneNumber) {
        this.donorPhoneNumber = donorPhoneNumber;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublishingHouse() {
        return bookPublishingHouse;
    }

    public void setBookPublishingHouse(String bookPublishingHouse) {
        this.bookPublishingHouse = bookPublishingHouse;
    }

    public String getBookYearOfPublishing() {
        return bookYearOfPublishing;
    }

    public void setBookYearOfPublishing(String bookYearOfPublishing) {
        this.bookYearOfPublishing = bookYearOfPublishing;
    }
}
