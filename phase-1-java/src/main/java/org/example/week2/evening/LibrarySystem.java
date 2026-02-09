package org.example.week2.evening;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class LibrarySystem {

    TreeSet<Book> catalog = new TreeSet<>();
    LinkedList<String> borrowHistory = new LinkedList<>();
    HashMap<Book, Boolean> bookAvailability = new HashMap<>();

    public void addBook(Book book) {
        catalog.add(book); //compareTo called
        bookAvailability.put(book, true);
    }

    public boolean borrowBook(Book book, String user) {
        if(bookAvailability.get(book)) { //equals and hashcode called to lookup by author and title
            bookAvailability.put(book, false);
            borrowHistory.add(user+" borrowed "+ book); //toString() called
            return true;
        } else {
            System.out.println("Book not available");
            return false;
        }
    }

    public void returnBook(Book book, String user) {
        if(bookAvailability.containsKey(book)) {
            bookAvailability.put(book, true);
            borrowHistory.add(user+" returned "+ book);
            System.out.println(user+ " returned "+ book);
        }
    }

    public void printCatalog() {
        System.out.println("Sorted Book Catalog: ");
        catalog.forEach(b -> System.out.println("Book: "+ b + (bookAvailability.get(b) ? " Available" : " Borrowed")));
    }

    public void printBorrowHistory() {
        System.out.println("Borrowed Book History: ");
        borrowHistory.forEach(System.out::println);
    }

    public static void main(String[] args) {

        Book b1 = new Book("Book1", "Auth 1");
        Book b2 = new Book("Book2", "Auth 2");
        Book b3 = new Book("Book3", "Auth 3");

        LibrarySystem ls1 = new LibrarySystem();
        ls1.addBook(b1);
        ls1.addBook(b2);
        ls1.addBook(b3);

        ls1.printCatalog();
        ls1.borrowBook(b2, "User 1");

        ls1.printCatalog();
        ls1.printBorrowHistory();

        ls1.returnBook(b2, "User 1");
        ls1.printCatalog();
        ls1.printBorrowHistory();


    }



}
