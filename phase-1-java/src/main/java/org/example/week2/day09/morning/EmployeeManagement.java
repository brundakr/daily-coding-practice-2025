package org.example.week2.day09.morning;

public class EmployeeManagement {
    public static void main(String[] args) {
        Developer d1 = new Developer("Janan", 30, 80000);
        Developer d2 = new Developer("Krishna", 35, 98000);

        System.out.println(d1);
        System.out.println(d2);


        d1.work();
        d1.attendMeeting();

        d1.featureDevelopment();

    }
}
