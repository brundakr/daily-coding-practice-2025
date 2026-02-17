package org.example.week2.day14.evening;

public class StockWorker implements Runnable {

    private Product product;
    private boolean isAdd;
    private int quantity;

    public StockWorker(Product p, Boolean isAdd, int quantity) {
        this.product = p;
        this.isAdd = isAdd;
        this.quantity = quantity;
    }

    public void run() {

        Inventory inventory = Inventory.getInventoryInstance();

        if(isAdd) {
            inventory.addStock(product, quantity);
        } else {
            inventory.removeStock(product, quantity);
        }

    }
}
