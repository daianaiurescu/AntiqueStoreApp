package Exceptions;

public class WrongPassword extends Exception{

    public WrongPassword() {
        System.out.println("Wrong Password!");
        System.out.println("Please try again :)");
    }
}
