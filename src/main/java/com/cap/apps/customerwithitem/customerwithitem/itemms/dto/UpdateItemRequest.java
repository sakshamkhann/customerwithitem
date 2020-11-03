package com.cap.apps.customerwithitem.customerwithitem.itemms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UpdateItemRequest {

    @NotBlank
    private String itemId;


    @NotBlank @Size(min=2, max=20)
    private  String description;

    public UpdateItemRequest(){

    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
