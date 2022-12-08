package com.AndreAmorim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
                if (int_part_one == -2) {
                    System.out.println("There are no valid match!\n");
                }
                System.out.println("part 1: " + int_part_one);
            }

            int int_part_two = part_two(br2);
            if (int_part_two != -1) {
                if (int_part_two == -2) {
                    System.out.println("There are no valid match!\n");
                }
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
            List<Directory> directories = new ArrayList<>();
            String actual_path = "";
            while ((st = br.readLine()) != null) {


                    if (st.contains("$ cd")) {
                        if (st.contains("..")) {
                            actual_path = actual_path.replaceAll("/[A-z 1-9.]+$","");
                        } else {
                            st = st.replaceAll("\\$ cd ", "");
                            actual_path += "/" + st;
                            boolean exists = false;
                            for (Directory d : directories) {
                                if (d.getDir().equals(st)) {
                                    exists = true;
                                    break;
                                }
                            }
                            if (exists == false) {
                                directories.add(new Directory(actual_path));
                            }
                        }
                    }
                Pattern pattern = Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(st);
                boolean matchFound = matcher.find();
                if(matchFound) {
                    for (Directory d: directories)
                    {
                        if(d.getDir().equals(actual_path))
                        {

                            d.addsize(Integer.parseInt(matcher.group()));

                        }
                    }
                }

            }
            for (Directory d : directories)
            {

                    String parentspath = d.getDir();
                    while (!parentspath.equals("//"))
                    {
                        parentspath = parentspath.replaceAll("/[A-z 1-9.]+$","");
                        for (Directory parents: directories)
                        {
                            if(parents.getDir().equals(parentspath))
                            {
                                parents.addsize(d.getSize());
                            }
                        }
                    }

            }
            for (Directory d : directories)
            {
                if (d.getSize()<100000)
                {
                    number+=d.getSize();
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
            List<Character> chars_passed = new ArrayList<>();
            while ((st = br.readLine()) != null) {

                for (int i = 0; i< st.length();i++)
                {
                    number++;
                    if (chars_passed.contains(st.charAt(i)))
                    {
                        for (int y = chars_passed.indexOf(st.charAt(i)); y>= 0; y--)
                            chars_passed.remove(y);

                        chars_passed.add(st.charAt(i));

                    }
                    else
                    {

                        chars_passed.add(st.charAt(i));
                        if (chars_passed.size()==14)
                        {
                            return number;
                        }
                    }

                }
            }

            return -2;

        } catch (Exception e) {
            System.out.println("Error in the counting!");
            return -1;

        }
    }
}
