package com.cap.apps.customerwithitem.customerwithitem.itemms.service;



import com.cap.apps.customerwithitem.customerwithitem.customermss.entities.Customer;
import com.cap.apps.customerwithitem.customerwithitem.customermss.repository.CustomerRepository;
import com.cap.apps.customerwithitem.customerwithitem.customermss.service.CustomerService;
import com.cap.apps.customerwithitem.customerwithitem.customermss.util.ValidateCustomer;
import com.cap.apps.customerwithitem.customerwithitem.itemms.entities.Item;
import com.cap.apps.customerwithitem.customerwithitem.itemms.exceptions.ItemNotExistException;
import com.cap.apps.customerwithitem.customerwithitem.itemms.repository.ItemRepository;
import com.cap.apps.customerwithitem.customerwithitem.itemms.util.ValidateItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    CustomerService customerService;

    @Autowired
    ItemRepository itemRepo;

    @Override
    public Item add(Item item) {
        ValidateItem.checkItemExist(item);
        ValidateItem.checkItemDescription(item.getDescription());
        itemRepo.save(item);
        return item;
    }

    @Override
    public Item update(Item item) {
        ValidateItem.checkItemExist(item);
        ValidateItem.checkItemDescription(item.getDescription());
        ValidateItem.checkItemId(item.getItemId());
        Item itemfound = findById(item.getItemId());
        return itemRepo.save(itemfound);
    }

    @Override
    public Item buyItem(Long customerId, String itemId) {
        ValidateCustomer.checkId(customerId);
        ValidateItem.checkItemId(itemId);
        Customer customer = customerService.findById(customerId);
        Item item = findById(itemId);
        item.setCustomer(customer);
        item = itemRepo.save(item);
        List<Item> items = customer.getItems();
        if(items == null){
            items =  new ArrayList<>();
            customer.setItems(items);
        }
        items.add(item);
        return item;
    }

    @Override
    public Item findById(String id) {
        ValidateItem.checkItemId(id);
        Optional<Item> optional = itemRepo.findById(id);
        if(!optional.isPresent()){
            throw new ItemNotExistException("Item not found");
        }
        return optional.get();

    }

    @Override
    public List<Item> findAll() {
        return itemRepo.findAll();
    }
}
