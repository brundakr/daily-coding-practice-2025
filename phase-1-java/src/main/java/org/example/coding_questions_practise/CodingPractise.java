package org.example.coding_questions_practise;

import java.util.*;
import java.util.stream.Collectors;

public class CodingPractise {

    public static void main(String[] args) {
        System.out.println("Enter the function no");
        Scanner input = new Scanner(System.in);

        switch (input.next()){
            case "1":
                //Longest Substring Without Repeating Characters
                findLongestSubstring(); //moving window
                break;
            case "2":
                //Maximum Sum Subarray of Size K
                maxSum(); //moving window
                break;

            case "3":
                //Return the number of subarrays whose sum equals k
                subArrayCount(); //prefix sum
                break;

            case "4":
                //Write a Java program to check if a string is a palindrome.
                palindrome();
                break;

            case "5":
                //Write a Java program to find the first non-repeating character in a string.
                findFirstNonRepeatingWord();
                break;

            case "6":
                //Valid Parenthesis
                validParenthesis();
                break;

            case "7":
                //Find the majority element in an array. - Element appearing more than n/2 times
                majorityElement();
                break;

            case "8":
                //Kadane's alg - Given an integer array nums, find the contiguous subarray with the largest sum and return that sum.
                kadanes();
                break;

            case "9":
                //Merge Intervals
                mergeIntervals();
                break;

            case "10":
                //Remove Duplicates from Array using 2 pointers - array is already sorted
                removeDuplicatesFromSortedArray();
                break;

            case "11":
                //Remove Duplicates from Array using 2 pointers - array is already unsorted
                removeDuplicatesFromUnSortedArray();
                break;

            default:
                func();
                break;
        }
    }


//    -----------------------------IMPLEMENTATIONS---------------------------------


    public static void findFirstNonRepeatingWord() {

        System.out.println("enter the string");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        for(Character c: str.toCharArray()) {

            map.put(c, map.getOrDefault(c,0)+1);

            queue.add(c);

            while(!queue.isEmpty() && map.get(queue.peek()) > 1) {
                queue.poll();
            }

        }

        if(!queue.isEmpty())
            System.out.println("First non repeating word: " + queue.peek());

        queue.stream()
                .forEach(System.out::println);

    }

    public static void palindrome() {
        System.out.println();
        System.out.println("Enter a word");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int i = 0;
        int j = input.length()-1;
        boolean isPalindrome = true;

        while(i<j) {
            if(input.charAt(i) != input.charAt(j)) {
                System.out.println("not palindrome");
                return;
            }
            i++;
            j--;
        }
        System.out.println("palindrome");
    }


    public static void subArrayCount(){
        int[] nums = new int[]{1, 2, 1, 2, 1};
        int k = 3;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int prefixSum = 0;

        for(int num: nums) {

            prefixSum = prefixSum + num;

            if(map.containsKey(prefixSum - k)) {
                count = count + map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0) + 1);

        }

        System.out.println("Count: " + count);

    }


    public static void maxSum() {

        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int windowSum = 0;
        int maxSum =  0;
        int left = 0;

        for(int right = 0; right < nums.length; right++) {

            windowSum = windowSum + nums[right];

            if(right >= k - 1) {

                maxSum = Math.max(maxSum, windowSum);
                windowSum = windowSum - nums[left];

                left++;

            }
        }

        System.out.println("Max sum = " + maxSum);

    }

    public static void findLongestSubstring() {
        //use moving window technique
        String str = "abcabbcaa";
        int left = 0;
        Set<Character> set = new HashSet<>();
        int maxlength = 0;

        for(int right = 0; right < str.length(); right++){

            while(set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
            }

            set.add(str.charAt(right));
            maxlength = Math.max(maxlength, right-left+1);
        }
        System.out.println(maxlength);

    }

    public static void validParenthesis() {
        String str = "(()())";
        Stack<Character> stack = new Stack<>();

        for(int i=0; i< str.length(); i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')' || str.charAt(i) == '}'
            ) {
                if(!stack.isEmpty() && ((stack.peek() == '(' && str.charAt(i) == ')') ||  (stack.peek() == '{' && str.charAt(i) == '}'))
                ){
                    stack.pop();
                } else {
                    System.out.println("not valid parenthesis");
                    return;
                }
            }
            else {
                System.out.println("Invalid parenthesis");
                return;
            }
        }
        System.out.println("valid parenthesis");

    }


    public static void majorityElement() {
        int[] nums = {2,2,1,1,1,2,2};
        double k = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > k) {
                System.out.println(entry.getKey() + " appears more than " + k);
                return;
            }
        }

    }

    public static void kadanes() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int num: nums) {
            currentSum = Math.max(num, currentSum + num);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Max sum: " + maxSum);

    }

    public static void mergeIntervals() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        for(int i=0; i < intervals.length; i++) {
            int[] prev = merged.get(merged.size() - 1);
            int[] curr = intervals[i];

            if(curr[0] < prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                merged.add(curr);
            }

            for(int[] interval: merged) {
                System.out.println(interval[0] + ", "+ interval[1]);
            }

        }


    }

    public static void removeDuplicatesFromSortedArray() {
        //using 2 pointer
        int[] arr = {1,1,2,2,3};
        int i = 0;

        for(int j=1; j<arr.length; j++) {

            if(arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        System.out.println("Unique arr length: "+ i+1);

        for(int k=0; k<=i; k++) {
            System.out.println("Array eles: "+ arr[k] + "   ");
        }
    }

    public static void removeDuplicatesFromUnSortedArray() {
        //sorting then performing actions like before pgm works but time complexity more
        //hence use set
        int[] arr = {1,3,2,1,3,2};
        Set<Integer> set = new LinkedHashSet<>();
        for(int a: arr) {
            set.add(a);
        }

        set.forEach(a-> System.out.println(a));

    }

    public static void func() {
        //kadanes
        int[] arr = {1,1,2,2,3};
        int maxSum = arr[0];
        int subArrSum = 0;

        for(int a: arr) {
            subArrSum = Math.max(subArrSum + a , a);
            maxSum = Math.max(maxSum, subArrSum);
        }
        System.out.println(maxSum);


    }




}
