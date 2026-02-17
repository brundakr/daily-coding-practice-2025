package org.example.week2.day14.evening;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = Inventory.getInventoryInstance();

        //add observer
        inventory.addObserver(new Receiver());

        //create products
        Product p1 = ProductFactory.createProduct(1, "Iphone 16", 5);
        Product p2 = ProductFactory.createProduct(2, "Macboook", 10);
        Product p3 = ProductFactory.createProduct(3, "Speakers", 20);

        //add products into the inventory
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        //Add/remove stocks with threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(new StockWorker(p1, true, 1));
        executorService.submit(new StockWorker(p2, false, 11));
        executorService.submit(new StockWorker(p3, true, 2));

        executorService.shutdown();

        System.out.println("Print inventory");
        inventory.printInventory();

    }
}
