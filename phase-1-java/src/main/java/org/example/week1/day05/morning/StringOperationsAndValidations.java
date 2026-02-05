package org.example.week1.day05.morning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringOperationsAndValidations {

    public static void main(String[] args) {
        //    Split string by delimiter
        String str = "String:Operations:Validations";
        List<String> strs = Arrays.asList(str.split(":"));

//    Join array of strings
        List<String> a = Arrays.asList("abc", "bcd", "eif");
        List<String> b = Arrays.asList("res", "ftr", "euk");

        List<String> c = Stream.concat(a.stream(),b.stream())
                .collect(Collectors.toList());

        c.stream()
                .forEach(System.out::println);



//        Remove whitespace and special characters
        String str1 = "Hello#@ Wor$ld";
        String clean = str1.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(clean);

//        Check if string contains only digits
        String str2 = "12345";
        boolean onlyDigits = true;
        for(int i=0; i<str2.length(); i++) {
            if(Character.isDigit(str2.charAt(i))) {
                onlyDigits = false;
            }
        }
        if(!onlyDigits) {
            System.out.println("No Only Digits");
        }



    }


}
