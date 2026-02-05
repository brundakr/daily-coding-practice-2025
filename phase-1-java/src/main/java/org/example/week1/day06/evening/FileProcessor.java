package org.example.week1.day06.evening;

import java.io.*;

public class FileProcessor {
    public void processStudentCSV(String inputFile, String outputFile) {
        try(
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ){
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length !=3) continue; //skip invalid lines
                String name = parts[0].trim();
                int age = Integer.parseInt(parts[1].trim());
                String grade = parts[2].trim();
                //validate age and grade
                if(age <0 || "ABCDEF".contains(grade)) continue;
                writer.write(name+", "+age+", "+grade);
                writer.newLine();

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("I/O Error");
        }
    }

}
