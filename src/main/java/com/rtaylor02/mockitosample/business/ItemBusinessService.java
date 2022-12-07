package com.rtaylor02.mockitosample.business;

import com.rtaylor02.mockitosample.data.ItemRepository;
import com.rtaylor02.mockitosample.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {
    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveHardCodedItem() {
        return new Item(2, "Ball 2", 50, 20);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = itemRepository.findAll();

        for(Item i : items) {
            i.setValue(i.getPrice() * i.getQuantity());
        }

        return items;
    }
}
