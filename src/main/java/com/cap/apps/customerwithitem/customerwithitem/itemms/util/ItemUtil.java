package com.cap.apps.customerwithitem.customerwithitem.itemms.util;


import com.cap.apps.customerwithitem.customerwithitem.customermss.entities.Customer;
import com.cap.apps.customerwithitem.customerwithitem.itemms.dto.ItemDetails;
import com.cap.apps.customerwithitem.customerwithitem.itemms.entities.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ItemUtil {

    public ItemDetails getItemDetails(Item item){
     ItemDetails details=new ItemDetails();
     details.setItemId(item.getItemId());
     details.setDescription(item.getDescription());
        Customer customer=item.getCustomer();
        if(customer!=null) {
            details.setId(customer.getId());
            details.setFirstName(customer.getFirstName());
            details.setLastName(customer.getLastName());
        }
        return details;
    }


}
