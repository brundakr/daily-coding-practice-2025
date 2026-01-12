package org.example.week1.day02.evening;

import java.util.Map;

public class BookstoreManager {

    public static void main(String[] args) {

        Bookstore bookstore = new Bookstore();

        bookstore.addBook("Book1", 200L);
        bookstore.addBook("Book2", 300L);
        bookstore.addBook("Book3", 400L);

        Map.Entry<String, Long> expEntry = bookstore.findMostExpensive();
        System.out.println(expEntry.getKey() + " is expensive of price: "+ expEntry.getValue());

        System.out.println("Sum: "+bookstore.getTotalValue());

    }
}
