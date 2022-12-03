package com.AndreAmorim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        File file = new File(
                "input.txt");
        BufferedReader br = null;
        BufferedReader br2 = null;
        try {
            br = new BufferedReader(new FileReader(file));
            br2 = new BufferedReader(new FileReader(file));

        } catch (Exception e) {
            System.out.println("Error in reading the file!\n");

        }
        int int_part_one = part_one(br);
        if (int_part_one != -1) {
            System.out.println("part 1: " + int_part_one);
        }
        int int_part_two = part_two(br2);
        if (int_part_two != -1) {
            System.out.println("part 2: " + int_part_two);
        }
    }

    public static Integer part_one(BufferedReader br) {
        try {

            String st;
            int number = 0;
            while ((st = br.readLine()) != null) {

                String first_half = st.substring(0, st.length() / 2);
                String second_half = st.substring(st.length() / 2);

                List<String> letters_alreadyused = new ArrayList<>();
                for (int i = 0; i < st.length() / 2; i++) {

                    if (second_half.contains(Character.toString(first_half.charAt(i)))) {

                        String letter_string = Character.toString(first_half.charAt(i));
                        if (!letters_alreadyused.contains(letter_string)) {
                            char letter = letter_string.charAt(0);

                            if (Character.isUpperCase(letter)) {
                                number += 26;
                            }
                            letters_alreadyused.add(letter_string);
                            letter_string = letter_string.toUpperCase();

                            letter = letter_string.charAt(0);


                            number += letter - 'A' + 1;
                        }
                    }
                }


            }

            return number;

        } catch (Exception e) {
            System.out.println("Error in the counting!");
            return -1;

        }
    }

    public static Integer part_two(BufferedReader br) {
        try {

            String st;
            int number = 0;
            int inc = 1;
            String first_rucksack = "";
            List<Character> repeated_letters = new ArrayList<>();
            List<Integer> removeindexs = new ArrayList<>();
            while ((st = br.readLine()) != null) {
                if (inc == 1) {
                    first_rucksack = st;
                }
                if (inc == 2) {
                    for (int i = 0; i < first_rucksack.length(); i++) {
                        if (st.contains(Character.toString(first_rucksack.charAt(i)))) {
                            if (!repeated_letters.contains(first_rucksack.charAt(i))) {
                                repeated_letters.add(first_rucksack.charAt(i));
                            }

                        }
                    }
                }
                if (inc == 3) {
                    for (int i = 0; i < repeated_letters.size(); i++) {
                        if (!st.contains(Character.toString(repeated_letters.get(i)))) {
                            removeindexs.add(i);
                        }
                    }

                    for (int i =0 ; i < removeindexs.size() ;i++) {

                        repeated_letters.remove(i);
                        removeindexs.remove(i);
                        i--;
                    }

                    for (char character : repeated_letters) {
                        if (Character.isUpperCase(character)) {
                            number += 26;
                        }
                        String letter_string = Character.toString(character);
                        letter_string = letter_string.toUpperCase();
                        char letter = letter_string.charAt(0);
                        number += letter - 'A' + 1;
                        inc = 0;

                    }
                    repeated_letters.clear();
                    removeindexs.clear();
                }
                inc++;
            }

            return number;

        } catch (Exception e) {
            System.out.println("Error in the counting!");
            return -1;

        }
    }
}
