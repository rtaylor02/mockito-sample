package com.rtaylor02.mockitosample.controller;

import com.rtaylor02.mockitosample.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rtaylor02.mockitosample.business.ItemBusinessService;

@RestController
public class ItemController {
    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item getDummyItem() {
        return new Item(1, "Ball", 5, 100);
    }

    @GetMapping("/item-from-business-service") // Note the dependency on ItemBusinessService
    public Item getItemFromBusinessService() {
        return businessService.retrieveItem();
    }


}
