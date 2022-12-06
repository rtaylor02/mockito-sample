package com.rtaylor02.mockitosample.business;

import com.rtaylor02.mockitosample.model.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ItemBusinessService {
    public Item retrieveHardCodedItem() {
        return new Item(2, "Ball 2", 50, 20);
    }
}
