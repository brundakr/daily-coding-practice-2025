package org.example.week2.day14.evening;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Inventory {
    private static Inventory instance;
    private Map<Long, Product> products = new ConcurrentHashMap<>();
    private CopyOnWriteArrayList<InventoryObserver> observers = new CopyOnWriteArrayList<>();

    private Inventory() {
    }

    public static Inventory getInventoryInstance() {
        if(instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addProduct(Product p) {
        products.put(p.getId(), p);
    }

    public void removeProduct(Product p) {
        products.remove(p.getId());
    }

    public void addStock(Product p, int quantity) {
        if(p!=null && quantity>0) {
            products.get(p.getId()).addStock(p, quantity);
            notifyObservers("Stock added: " + p);
        }
    }

    public void removeStock(Product p, int quantity) {
        if(p!=null && quantity>0) {
            products.get(p.getId()).removeStock(p, quantity);
            notifyObservers("Stock removed: " + p);
        }
    }

    public void addObserver(InventoryObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for(InventoryObserver ob: observers) {
            ob.updateMessage(message);
        }
    }

    public void printInventory() {
        for(Product p: products.values()) {
            System.out.println(p);
        }
    }


}
