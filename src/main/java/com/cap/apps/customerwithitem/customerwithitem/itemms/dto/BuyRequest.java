package com.cap.apps.customerwithitem.customerwithitem.itemms.dto;

public class BuyRequest {

    private String itemId;

    private Long id;

    public BuyRequest(){

    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
