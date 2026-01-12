package org.example.week1.day02.morning;

import java.util.HashMap;
import java.util.Map;

public class Hashmap {

    public static void main(String args[]) {
        //Hashmap with String Integer
        Map<String, Integer> stringMap = new HashMap<>();
        stringMap.put("brunda", 24);
        stringMap.put("Harry", 34);
        stringMap.put("Taytay", 35);
        stringMap.put("Sabs", 28);
        stringMap.put("Lana", 37);

        String maxKey = stringMap.keySet().stream().findFirst().get();

        for(Map.Entry<String, Integer> entry : stringMap.entrySet()) {
            System.out.println(entry.getKey() +" "+ entry.getValue());
            if(entry.getValue() > stringMap.get(maxKey)) {
                maxKey = entry.getKey();
            }
        }
        System.out.println("Max key - " + maxKey+" && "+"Its value - " + stringMap.get(maxKey));

    }
}
