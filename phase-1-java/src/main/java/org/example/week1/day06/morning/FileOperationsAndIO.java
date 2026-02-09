package org.example.week1.day06.morning;

import java.io.*;

public class FileOperationsAndIO {

    public static void main(String[] args) {
        //Read file line by line
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("I/O Error");
        }

//        Write data to file
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Output.txt"))) {
            writer.write("Hi");
            writer.newLine();
            writer.write("End");
        } catch (IOException e) {
            System.out.println("I/O Error");
        }


    }
}
