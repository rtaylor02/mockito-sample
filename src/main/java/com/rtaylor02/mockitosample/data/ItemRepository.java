package com.rtaylor02.mockitosample.data;

import com.rtaylor02.mockitosample.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
