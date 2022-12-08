package com.rtaylor02.mockitosample.business;

import com.rtaylor02.mockitosample.data.ItemRepository;
import com.rtaylor02.mockitosample.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
    // Arrange
    @Mock
    private ItemRepository repository;

    @InjectMocks
    private ItemBusinessService businessService;

    @Test
    void retrieveAllItems() {
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Item(1, "Ball 2", 2, 6),
                new Item(2, "Ball 2", 3, 10)
        ));

        // Act
        List<Item> items = businessService.retrieveAllItems();

        // Assert - we are testing the business logic inside business service where field value gets calculated
        assertEquals(12, items.get(0).getValue());
        assertEquals(30, items.get(1).getValue());
    }
}