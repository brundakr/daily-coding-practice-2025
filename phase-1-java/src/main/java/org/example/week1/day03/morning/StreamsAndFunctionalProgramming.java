package org.example.week1.day03.morning;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsAndFunctionalProgramming {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();
        numList.add(1);numList.add(2);numList.add(3);numList.add(4);numList.add(5);numList.add(6);

        //filter even numbers
        filEvenNos(numList);
        sqrNumMap(numList);
        sum(numList);
    }

    private static void filEvenNos(List<Integer> numList) {
        List<Integer> evenList = numList.stream().filter(x -> x%2 == 0).collect(Collectors.toList());
        evenList.forEach(System.out::println);
    }

    private static void sqrNumMap(List<Integer> numList) {
        Map<Integer, Integer> sqrMap = new HashMap<>();
        numList.stream()
                .forEach(n -> {
                    if(numList.contains(n*n)) {
                        sqrMap.put(n, n*n);
                    }
                });
        sqrMap.forEach((k,v) -> {
            System.out.println("Key: "+k+" Value: "+v);
        });
    }

    private static void sum(List<Integer> numList) {
        Optional<Integer> sum = numList.stream()
                .reduce((n1, n2) -> n1 + n2);
        sum.ifPresent(System.out::println);
    }

}
