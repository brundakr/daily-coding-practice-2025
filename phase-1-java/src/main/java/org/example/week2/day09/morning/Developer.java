package org.example.week2.day09.morning;

public class Developer extends Employee implements Workable, DeveloperDuties {

    private double baseSalary;

    public Developer(String name, int age, double baseSalary) {
        super(name, age);
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary(){
        return baseSalary + 5000; //bonus
    }

    @Override
    public void work() {
        System.out.println(getName() + " is developing");
    }

    @Override
    public void attendMeeting() {
        System.out.println(getName() + " is attending a feature requirement meeting");
    }

    @Override
    public void featureDevelopment() {
        System.out.println(getName() + " is developing Feature: Search Filter with pagination");
    }

    @Override
    public void bugfixing() {
        System.out.println(getName() + " is fixing CSS issues");
    }

    @Override
    public String toString() {
        return super.toString() + " earns " + baseSalary;
    }
}
