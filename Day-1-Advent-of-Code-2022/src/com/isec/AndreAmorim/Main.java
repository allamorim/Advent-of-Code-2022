package com.isec.AndreAmorim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File(
                    "calories_elfs.txt");

            // Note:  Double backquote is to avoid compiler
            // interpret words
            // like \test as \t (ie. as a escape sequence)

            // Creating an object of BufferedReader class
            BufferedReader br
                    = new BufferedReader(new FileReader(file));

            // Declaring a string variable
            String st;
            // Condition holds true till
            // there is character in a string

            int actualcallories = 0;
            int totalcallories = 0;
            List<Integer> calories_by_elf = new ArrayList<>();

            int i = 0;

            while ((st = br.readLine()) != null) {
                if (st.equals("")) {
                    if (totalcallories < actualcallories)
                        totalcallories = actualcallories;
                    calories_by_elf.add(actualcallories);
                    actualcallories = 0;
                } else {
                    actualcallories += Integer.parseInt(st);
                }

            }
            calories_by_elf.sort(null);
            System.out.println(calories_by_elf.get(calories_by_elf.size() - 1) + calories_by_elf.get(calories_by_elf.size() - 2) +
                    calories_by_elf.get(calories_by_elf.size() - 3));

            System.out.println(totalcallories);


        } catch (Exception e) {
            System.out.println("Error in reading the file!");
        }
    }
}
