package com.cap.apps.customerwithitem.customerwithitem.itemms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddItemRequest {

    @NotBlank
    String itemId;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @NotBlank @Size(min=2, max=20)
    private  String description;

    public AddItemRequest(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
