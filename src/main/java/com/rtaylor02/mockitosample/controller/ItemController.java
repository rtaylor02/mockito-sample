package com.rtaylor02.mockitosample.controller;

import com.rtaylor02.mockitosample.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @GetMapping("/dummy-item")
    public Item getDummyItem() {
        return new Item(1, "Ball", 5, 100);
    }
}
