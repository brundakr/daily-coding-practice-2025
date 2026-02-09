package org.example.week2.day09.morning;

public class Devops extends Employee implements Workable, DevopsDuties {

    private double baseSalary;

    public Devops(String name, int age, double baseSalary) {
        super(name, age);
        this.baseSalary = baseSalary;
    }

    public double calculateSalary() {
        return baseSalary + 1000;
    }

    public void work() {
        System.out.println(getName() + " works on deployments");
    }

    public void attendMeeting() {
        System.out.println(getName() + " is attending Kubernetes meeting");
    }

    public void deployment() {
        System.out.println(getName() + " is deploying");
    }

    public void dbUpgrade() {
        System.out.println(getName() + " is db upgrading");
    }

}
