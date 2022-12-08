package com.rtaylor02.mockitosample.data;

import com.rtaylor02.mockitosample.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // This will create the repo and run data.sql, etc that get the database running as in normal Spring run.
// In reality, when using real database (instead of H2 in-memory db), you can put data.sql in resources under
// test folder.
class ItemRepositoryTest {
    // Arrange
    @Autowired // This can be used here as @DataJpaTest makes sure that the repository is ready.
    private ItemRepository repository;

    @Test
    void findAll() {
        // Act
        List<Item> items = repository.findAll();

        // Assert
        assertEquals(3, items.size());
    }

    @Test
    void findOne() {
        // Act
        Item item = repository.findById(2).get();

        // Assert
        assertEquals("Ball 2", item.getName());
    }
}