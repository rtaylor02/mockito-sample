package com.rtaylor02.mockitosample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

/*
Data is pre-populated in data.sql
 */

@Entity
public class Item {
    @Id
    private int id;
    private String name;
    private int price;
    private int quantity;

    @Transient // Exclude field as column in the table
    private int value;

    public Item() {
        // Required as an Entity (@Entity) to have no-args constructor
    }

    public Item(int id, String name, int price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Item[%d %s %d %d]", id, name, price, quantity);
    }
}
