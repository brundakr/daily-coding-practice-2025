package org.example.week2.morning;

import java.util.*;

public class AdvancedCollections {

    public static void main(String[] args) {
        //Use LinkedHashMap vs HashMap
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(3, "a");
        hm.put(2, "b");
        hm.put(1, "c");

        System.out.println(hm.keySet());

        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(3,"a");
        lhm.put(2, "b");
        lhm.put(1, "c");

        System.out.println(lhm.keySet());


        // Implement Set operations (union, intersection)
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer>set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        Set<Integer> unionSet = new HashSet<>(set1); //creates a copy
        unionSet.addAll(set2);
        System.out.println(unionSet);

        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println(intersectionSet);


        //Use PriorityQueue for sorting
        PriorityQueue<String> pq = new PriorityQueue<>(Arrays.asList("element", "fruits", "bananas"));
        System.out.println(pq);

//        TreeMap for sorted key-value pairs
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("Zebra", 58);
        tm.put("apple", 99);
        System.out.println(tm);



    }


}
