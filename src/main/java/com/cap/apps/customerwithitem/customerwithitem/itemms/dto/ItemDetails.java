package com.cap.apps.customerwithitem.customerwithitem.itemms.dto;

import com.cap.apps.customerwithitem.customerwithitem.customermss.entities.Customer;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class ItemDetails {

    private String itemId;

    private String description;

    private Long id;

    private  String firstName;

    private String lastName;

    public ItemDetails(String itemId, String description, Long id, String firstName, String lastName) {
        this.itemId = itemId;
        this.description = description;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ItemDetails() {

    }



}
