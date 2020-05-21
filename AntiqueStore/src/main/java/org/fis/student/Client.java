package org.fis.student;

public class Client {
    private String firstName, lastName, address, phoneNumber, city;
    public Client(String fn, String ln, String a, String pn, String c){
        firstName=fn;
        lastName=ln;
        address=a;
        phoneNumber=pn;
        city=c;
    }
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getAddress(){return address;}
    public String getPhoneNumber(){return phoneNumber;}
    public String getCity(){return city;}
}
