package org.example.week1.day03.evening;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeManager {
    public static void main(String[] args) {

        List<Employee> empList = Arrays.asList(
            new Employee("abc", 100000L, "CS"),
            new Employee("def", 20000L, "CS"),
            new Employee("ghi", 300000L, "EC"),
            new Employee("jkl", 40000L, "EC"),
            new Employee("mnop", 50000L, "Mech")
        );

//        employees with salary > 50000
        List<Employee> highEarnEmps = empList.stream()
                .filter(s->s.getSalary() > 50000L)
                .collect(Collectors.toList());

        highEarnEmps.forEach(h -> System.out.println(h.getName()));


//        Group by department using streams
        Map<String, List<Employee>> bydept = empList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        bydept.forEach((dept,employeeList) -> {
            System.out.println(dept +" -> " + empList);
        });

        //A::B => “Take an object of type A and call method b on it”

        for(Map.Entry<String, List<Employee>> entry: bydept.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue()
                    .stream()
                    .map(Employee::getName)
                    .forEach(System.out::println);
            System.out.println("-------------------");
        }


//        Find average salary per department

        bydept.forEach((k,v) -> {
            System.out.println("Department "+k);

            double avgSal = v.stream()
                    .mapToLong(Employee::getSalary)
                    .average()
                    .orElse(0.0);

            System.out.println("Average salary per employee: "+avgSal);
        });

//find the second highest salary
        Optional<Long> secondHighestSal = empList.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted((a,b) -> Long.compare(b, a))
                .skip(1)
                .findFirst();

        secondHighestSal.ifPresent(System.out::println);

        //or

        secondHighestSal.ifPresent(s -> System.out.println("Second highest salary: "+s));

        //find the employee name with 2nd highest salary

        empList.stream()
                .sorted((a,b) -> Long.compare(b.getSalary(), a.getSalary()))
                .map(Employee::getName)
                .skip(1)
                .findFirst()
                .ifPresent(e->System.out.println(e));



    }
}
