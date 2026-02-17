package org.example.week2.day14.evening;

public class ProductFactory {
    public static Product createProduct(long id, String name, int quantity) {
        return new Product(id, name, quantity);
    }
}
