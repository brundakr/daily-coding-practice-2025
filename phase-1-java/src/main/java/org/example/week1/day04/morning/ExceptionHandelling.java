package org.example.week1.day04.morning;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandelling {
    public static void main(String[] args) throws FileReadException {

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("file.txt"));
            //other things here
        } catch (FileNotFoundException e) {
            throw new FileReadException("File not found");
        } catch (IOException e) {
            throw new FileReadException("IO");
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                throw new FileReadException("IO");
            }
        }
    }
}
