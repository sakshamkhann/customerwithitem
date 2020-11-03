package com.cap.apps.customerwithitem.customerwithitem.itemms.entities;

import com.cap.apps.customerwithitem.customerwithitem.customermss.entities.Customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Item {

    @Id
    private String itemId;

    private  String description;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @ManyToOne
    Customer customer ;

    public Item(){

    }

    public Item(String description, Customer customer) {
        this.description = description;
        this.customer = customer;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
