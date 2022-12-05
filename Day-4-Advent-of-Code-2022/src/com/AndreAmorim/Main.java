package com.AndreAmorim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        File file = new File(
                "input.txt");
        BufferedReader br = null;
        BufferedReader br2 = null;
        try {
            br = new BufferedReader(new FileReader(file));
            br2 = new BufferedReader(new FileReader(file));

            int int_part_one = part_one(br);
            if (int_part_one != -1) {
                System.out.println("part 1: " + int_part_one);
            }
            int int_part_two = part_two(br2);
            if (int_part_two != -1) {
                System.out.println("part 2: " + int_part_two);
            }

        } catch (Exception e) {
            System.out.println("Error in reading the file!\n");

        }

    }

    public static Integer part_one(BufferedReader br) {
        try {

            String st;
            int number = 0;
            while ((st = br.readLine()) != null) {

                st = st.replace('-',',');
                List<String> numbers = Arrays.asList(st.split(","));

                if (Integer.parseInt(numbers.get(0)) >= Integer.parseInt(numbers.get(2))
                        && Integer.parseInt(numbers.get(1)) <= Integer.parseInt(numbers.get(3)))
                {
                    number++;
                }
                else if (Integer.parseInt(numbers.get(0)) <= Integer.parseInt(numbers.get(2))
                        && Integer.parseInt(numbers.get(1)) >= Integer.parseInt(numbers.get(3)))
                {
                    number++;
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
            while ((st = br.readLine()) != null) {

                st = st.replace('-',',');
                List<String> numbers = Arrays.asList(st.split(","));

                if (Integer.parseInt(numbers.get(0)) >= Integer.parseInt(numbers.get(2))
                       && Integer.parseInt(numbers.get(1)) <= Integer.parseInt(numbers.get(3)))
                {
                    number++;
                }
                else if (Integer.parseInt(numbers.get(0)) <= Integer.parseInt(numbers.get(2))
                        && Integer.parseInt(numbers.get(1)) >= Integer.parseInt(numbers.get(3)))
                {
                    number++;
                }
                else if (Integer.parseInt(numbers.get(1)) >= Integer.parseInt(numbers.get(2))
                        && Integer.parseInt(numbers.get(0)) <= Integer.parseInt(numbers.get(3)))

                {
                    number++;
                }

            }

            return number;

        } catch (Exception e) {
            System.out.println("Error in the counting!");
            return -1;

        }
    }
}
