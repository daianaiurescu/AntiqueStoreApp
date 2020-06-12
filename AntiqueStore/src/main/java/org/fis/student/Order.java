package org.fis.student;

import javafx.collections.ObservableList;

public class Order {
    private Cart cart;
    private Client client;
    public Order(Cart c, Client cl){
        cart=c;
        client=cl;
    }
    public Cart getCart(){return cart;}
    public Client getClient(){return client;}
    public void setClient(Client c){client=c;}
    public void setCart(Cart c){cart=c;}
}
