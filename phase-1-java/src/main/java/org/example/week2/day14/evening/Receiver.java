package org.example.week2.day14.evening;

public class Receiver implements InventoryObserver {
    @Override
    public void updateMessage(String message) {
        System.out.println("[Inventory update] " + message);
    }



}
