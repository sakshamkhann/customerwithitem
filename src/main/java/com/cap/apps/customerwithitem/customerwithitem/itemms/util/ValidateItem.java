package com.cap.apps.customerwithitem.customerwithitem.itemms.util;


import com.cap.apps.customerwithitem.customerwithitem.itemms.entities.Item;
import com.cap.apps.customerwithitem.customerwithitem.itemms.exceptions.ItemIdException;
import com.cap.apps.customerwithitem.customerwithitem.itemms.exceptions.ItemDescriptionException;
import com.cap.apps.customerwithitem.customerwithitem.itemms.exceptions.ItemNotExistException;

public class ValidateItem{
    public static void  checkItemDescription(String description){
        if( description==null || description.isEmpty())
        {
            throw new ItemDescriptionException("name is not valid");
        }
    }

    public static void  checkItemId(String Id){
        if(Id==null || Id.isEmpty())
        {
            throw new ItemIdException("Id is not valid");
        }
    }

    public static void  checkItemExist(Item item){
        if(item==null)
        {
            throw new ItemNotExistException("customer is not existing");
        }
    }
}
