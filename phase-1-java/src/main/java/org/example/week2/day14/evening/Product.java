package org.example.week2.day14.evening;

public class Product {
    private long id;
    private String name;
    private int quantity;

    public Product(long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public synchronized int getQuantity() {
        return quantity;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public synchronized void addStock(Product p, int quantity) {
        this.quantity += quantity;
    }

    public synchronized boolean removeStock(Product p, int removedQuantity) {
        if(quantity < p.getQuantity()) {
            return false;
        }
        quantity -= removedQuantity;
        return true;
    }

    public String toString() {
        return "Product name: "+ name + ", quantity: " + quantity;
    }



}
