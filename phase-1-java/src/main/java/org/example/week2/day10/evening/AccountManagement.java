package org.example.week2.day10.evening;

public class AccountManagement {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("JointAcc123", 10000);

        bankAccount.withdraw(3000,"Husband");
        System.out.println("Current Balance: " + bankAccount.getBalance());

        bankAccount.withdraw(4000, "Wife");
        System.out.println("Current Balance: " + bankAccount.getBalance());

        bankAccount.withdraw(8000,"Kid");
        System.out.println("Current Balance: " + bankAccount.getBalance());

    }

}
