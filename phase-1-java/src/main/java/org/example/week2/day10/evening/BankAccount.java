package org.example.week2.day10.evening;

//consider its a joint account
public class BankAccount {
    private double bankBalance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBankBalance) {
        this.accountNumber = accountNumber;
        this.bankBalance = initialBankBalance;
    }

    public synchronized boolean withdraw(double amount, String user) {
        if(amount < 0 ) {
            System.out.println("Invalid amount");
            return false;
        }

        if(amount <= bankBalance) {
            System.out.println(user + ": Current Balance: "+ bankBalance);
            //simulate processing time - just to demonstrate real world behavior, the code will work the same even without sleep()
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();//once caught, the interrupt flag will get cleared, by calling this line we are restoring the interrupt flag, so that calling thread knows that the thread was interrupted
                System.out.println("Thread got interrupted");
            }
            bankBalance -= amount;
            System.out.println(user + " Withdrew$: " + amount + " New Balance: "+bankBalance);
            return true;
        } else {
            System.out.println("Insufficient balance");
            return false;
        }
    }

    public synchronized double getBalance() {
        return bankBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}
