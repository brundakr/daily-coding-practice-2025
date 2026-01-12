package org.example.week1.day02.evening;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Bookstore {

    private Map<String, Long> bookMap = new HashMap<>();

    public void addBook(String title, Long price) {
        bookMap.put(title, price);
    }

    public Map.Entry<String, Long> findMostExpensive() {
        Map.Entry<String, Long> ExpEntry = null;
        for(Map.Entry<String, Long> entry: bookMap.entrySet()) {
            if(ExpEntry == null || entry.getValue() > ExpEntry.getValue()) {
                ExpEntry = entry;
            }
        }
        return ExpEntry;
    }

    public Long getTotalValue() {
        Long sum = 0L;
        for(Map.Entry<String, Long> entry: bookMap.entrySet()) {
            sum = sum + entry.getValue();
        }
        return sum;
    }


}
