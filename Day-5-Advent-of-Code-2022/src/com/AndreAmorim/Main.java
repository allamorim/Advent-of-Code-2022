package com.AndreAmorim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        File file = new File(
                "input.txt");
        BufferedReader br = null;
        BufferedReader br2 = null;
        try {
            br = new BufferedReader(new FileReader(file));
            br2 = new BufferedReader(new FileReader(file));

            String int_part_one = part_one(br);
            if (!int_part_one.equals("-1")) {
                System.out.println("part 1: " + int_part_one);
            }
            String int_part_two = part_two(br2);
            if (!int_part_two.equals("-1")) {
                System.out.println("part 2: " + int_part_two);
            }

        } catch (Exception e) {
            System.out.println("Error in reading the file!\n");

        }

    }

    public static String part_one(BufferedReader br) {
        try {

            String st;
            int number = 0;
            boolean read_tree = false;
            List<Map<Integer, String>> crates = new ArrayList<>();
            while ((st = br.readLine()) != null) {
                Map<Integer, String> map = new HashMap<>();


                if (read_tree == false) {
                    if (st.charAt(1) == '1') {
                        read_tree = true;
                    } else {

                        for (int i = 1; i < 34; i += 4) {
                            number++;
                            if (st.charAt(i) != ' ') {
                                map.put(number, Character.toString(st.charAt(i)));
                            }
                        }
                        crates.add(map);
                    }

                    number = 0;
                } else {
                    if (st.contains("move")) {
                        int inc = 0;
                        int number_transport = 0;
                        int column_departure = 0;
                        int column_destination = 0;
                        if (st.charAt(6) != ' ') {
                            number_transport = Integer.parseInt(String.valueOf(st.charAt(5)) + Integer.parseInt(String.valueOf(st.charAt(6))));
                            inc = 13;
                        } else {
                            number_transport = Integer.parseInt(String.valueOf(st.charAt(5)));
                            inc = 12;
                        }
                        int id_x = inc;
                        int id_y = inc;
                        id_y++;

                        id_x--;
                        if (st.charAt(id_y) != ' ') {
                            column_departure = Integer.parseInt(String.valueOf(st.charAt(id_x)) + Integer.parseInt(String.valueOf(st.charAt(inc))));
                            inc += 5;
                        } else {
                            column_departure = Integer.parseInt(String.valueOf(st.charAt(inc)));
                            inc += 5;

                        }
                        id_x = inc;
                        id_x--;
                        id_y = inc;
                        id_y++;


                        if (st.length() > id_y && st.charAt(id_y) != ' ') {

                            column_destination = Integer.parseInt(String.valueOf(st.charAt(id_x)) + Integer.parseInt(String.valueOf(st.charAt(inc))));
                        } else {
                            column_destination = Integer.parseInt(String.valueOf(st.charAt(inc)));
                        }
                        String crate_tranport = "";
                        boolean allfull = true;
                        for (int i = 0; i < number_transport; i++) {
                            for (int y = 0; y < crates.size(); y++) {
                                if (crates.get(y).get(column_departure) != null) {
                                    crate_tranport = crates.get(y).get(column_departure);
                                    crates.get(y).remove(column_departure);
                                    break;
                                }


                            }

                            for (int y = crates.size() - 1; y >= 0; y--) {
                                if (crates.get(y).get(column_destination) == null) {
                                    crates.get(y).put(column_destination, crate_tranport);
                                    allfull = false;
                                    break;
                                }

                            }
                            if (allfull == true) {
                                Map<Integer, String> new_map = new HashMap<>();
                                new_map.put(column_destination, crate_tranport);
                                crates.add(0, new_map);
                            }
                            allfull = true;

                        }


                    }


                }


            }
            List<Integer> ints_already_choose = new ArrayList<>();
            Map<Integer, String> top_crates = new HashMap<>();
            String inc_result = "";
            for (Map<Integer, String> map : crates) {
                for (int y : map.keySet()) {
                    if (!ints_already_choose.contains(y)) {
                        ints_already_choose.add(y);
                        top_crates.put(y, map.get(y));
                    }
                }
            }
            for (String y : top_crates.values()) {
                inc_result += y;
            }
            return inc_result;

        } catch (Exception e) {
            System.out.println("Error in the counting!");
            return "-1";

        }
    }

    public static String part_two(BufferedReader br) {
        try {

            String st;
            int number = 0;
            boolean read_tree = false;
            List<Map<Integer, String>> crates = new ArrayList<>();
            while ((st = br.readLine()) != null) {
                Map<Integer, String> map = new HashMap<>();


                if (read_tree == false) {
                    if (st.charAt(1) == '1') {
                        read_tree = true;
                    } else {

                        for (int i = 1; i < 34; i += 4) {
                            number++;
                            if (st.charAt(i) != ' ') {
                                map.put(number, Character.toString(st.charAt(i)));
                            }
                        }
                        crates.add(map);
                    }

                    number = 0;
                } else {
                    if (st.contains("move")) {
                        int inc = 0;
                        int number_transport = 0;
                        int column_departure = 0;
                        int column_destination = 0;
                        if (st.charAt(6) != ' ') {
                            number_transport = Integer.parseInt(String.valueOf(st.charAt(5)) + Integer.parseInt(String.valueOf(st.charAt(6))));
                            inc = 13;
                        } else {
                            number_transport = Integer.parseInt(String.valueOf(st.charAt(5)));
                            inc = 12;
                        }
                        int id_x = inc;
                        int id_y = inc;
                        id_y++;

                        id_x--;
                        if (st.charAt(id_y) != ' ') {
                            column_departure = Integer.parseInt(String.valueOf(st.charAt(id_x)) + Integer.parseInt(String.valueOf(st.charAt(inc))));
                            inc += 5;
                        } else {
                            column_departure = Integer.parseInt(String.valueOf(st.charAt(inc)));
                            inc += 5;

                        }
                        id_x = inc;
                        id_x--;
                        id_y = inc;
                        id_y++;


                        if (st.length() > id_y && st.charAt(id_y) != ' ') {

                            column_destination = Integer.parseInt(String.valueOf(st.charAt(id_x)) + Integer.parseInt(String.valueOf(st.charAt(inc))));
                        } else {
                            column_destination = Integer.parseInt(String.valueOf(st.charAt(inc)));
                        }
                        List<String> crate_tranport = new ArrayList<>();
                        boolean allfull = true;
                        for (int i = 0; i < number_transport; i++) {
                            for (int y = 0; y < crates.size(); y++) {
                                if (crates.get(y).get(column_departure) != null) {
                                    crate_tranport.add(crates.get(y).get(column_departure));
                                    crates.get(y).remove(column_departure);
                                    break;
                                }

                            }
                        }
                        for (int k = crate_tranport.size() - 1; k >= 0; k--) {


                            for (int y = crates.size() - 1; y >= 0; y--) {
                                if (crates.get(y).get(column_destination) == null) {
                                    crates.get(y).put(column_destination, crate_tranport.get(k));
                                    allfull = false;
                                    break;
                                }

                            }
                            if (allfull == true) {
                                Map<Integer, String> new_map = new HashMap<>();
                                new_map.put(column_destination, crate_tranport.get(k));
                                crates.add(0, new_map);
                            }
                            allfull = true;
                        }
                        crate_tranport.clear();

                    }


                }


            }
            List<Integer> ints_already_choose = new ArrayList<>();
            Map<Integer, String> top_crates = new HashMap<>();
            String inc_result = "";
            for (Map<Integer, String> map : crates) {
                for (int y : map.keySet()) {
                    if (!ints_already_choose.contains(y)) {
                        ints_already_choose.add(y);
                        top_crates.put(y, map.get(y));
                    }
                }
            }
            for (String y : top_crates.values()) {
                inc_result += y;
            }
            return inc_result;

        } catch (Exception e) {
            System.out.println("Error in the counting!");
            return "-1";

        }
    }
}
