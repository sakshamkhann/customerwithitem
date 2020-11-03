package com.cap.apps.customerwithitem.customerwithitem.itemms.service;




import com.cap.apps.customerwithitem.customerwithitem.itemms.entities.Item;

import java.util.List;

public interface ItemService {
    public Item add(Item item);
    public Item update(Item item);
    public Item buyItem(Long customerId, String itemId);
    public Item findById(String id);
    public List<Item> findAll();
}
