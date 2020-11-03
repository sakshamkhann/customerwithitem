package com.cap.apps.customerwithitem.customerwithitem.itemms.controllers;



import com.cap.apps.customerwithitem.customerwithitem.itemms.dto.AddItemRequest;
import com.cap.apps.customerwithitem.customerwithitem.itemms.dto.BuyRequest;
import com.cap.apps.customerwithitem.customerwithitem.itemms.dto.ItemDetails;
import com.cap.apps.customerwithitem.customerwithitem.itemms.dto.UpdateItemRequest;
import com.cap.apps.customerwithitem.customerwithitem.itemms.entities.Item;
import com.cap.apps.customerwithitem.customerwithitem.itemms.service.ItemService;
import com.cap.apps.customerwithitem.customerwithitem.itemms.util.ItemUtil;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;


@Validated
@RequestMapping("/items")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

   @Autowired
   ItemUtil itemUtil;

    @GetMapping()
    public List<ItemDetails> findAll(){
        List<Item> list = itemService.findAll();
        List<ItemDetails> response = list.stream().map(item->itemUtil.getItemDetails(item)).collect(Collectors.toList());
        return response;
    }

    @GetMapping("/findById/{id}")
    public ItemDetails findBy(@PathVariable("id") @NotNull  String id){
        Item item = itemService.findById(id);
        ItemDetails itemDetails = itemUtil.getItemDetails(item);
        return itemDetails;
    }



    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public ItemDetails addItem(@RequestBody @Valid AddItemRequest request){
        Item item = new Item();
        item.setDescription(request.getDescription());
        item.setItemId(request.getItemId());
        item = itemService.add(item);
        ItemDetails ItemDetails = itemUtil.getItemDetails(item);
        return ItemDetails;
    }

    @PutMapping("/update")
    public ItemDetails updateItem(@RequestBody @Valid UpdateItemRequest request){
        Item item = new Item();
        item.setDescription(request.getDescription());
        item.setItemId(request.getItemId());
        item = itemService.update(item);
        ItemDetails itemDetails = itemUtil.getItemDetails(item);
         return itemDetails;
    }


    @PutMapping("/buy")
    public ItemDetails buy(@RequestBody BuyRequest request){
        Item item= itemService.buyItem(request.getId(), request.getItemId());
        ItemDetails details=itemUtil.getItemDetails(item);
        return details;
    }





}
