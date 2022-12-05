package com.rtaylor02.mockitosample.business;

import com.rtaylor02.mockitosample.model.Item;

public class ItemBusinessService {
    public Item retrieveItem() {
        return new Item(1, "Ball", 5, 100);
    }
}
