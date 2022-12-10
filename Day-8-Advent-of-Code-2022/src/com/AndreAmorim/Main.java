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
            int column_max = 0;
            int row_max = 0;
            List<Integer> trees = new ArrayList<>();
            for (int i = 0; (st = br.readLine()) != null; i++) {

                column_max = st.length();
                row_max++;

                for (int y = 0; y < st.length(); y++) {
                    trees.add(Integer.parseInt(String.valueOf(st.charAt(y))));
                }
            }


            int contador_linhas = 0;
            int cont_aux = 1;
            for (int i = 0; i < trees.size(); i++) {
                if (cont_aux == column_max) {
                    cont_aux = 0;
                    contador_linhas++;
                }
                cont_aux++;
                if (verifica_vertical_top(trees, column_max, i)
                        || verifica_vertical_under(trees, column_max, i) || verifica_horizontal_right(trees, column_max, i, contador_linhas)
                        || verifica_horizontal_left(trees, column_max, i, contador_linhas))
                    number++;



            }


            return number;

        } catch (Exception e) {
            System.out.println("Error in the counting!");
            return -1;

        }
    }

    public static boolean verifica_vertical_under(List<Integer> trees, int column_max, int index) {

        for (int i = index; i < trees.size(); i += column_max) {
            if (i != index)
                if (trees.get(index) <= trees.get(i)) {
                    return false;
                }
        }
        return true;
    }

    public static boolean verifica_vertical_top(List<Integer> trees, int column_max, int index) {
        for (int i = index; i >= 0; i -= column_max) {

            if (i != index)
                if (trees.get(index) <= trees.get(i)) {
                    return false;
                }
        }

        return true;
    }

    public static boolean verifica_horizontal_left(List<Integer> trees, int column_max, int index, int contador_linhas) {
        int muliple_columns = index % column_max;
        for (int i = index; i >= contador_linhas * column_max; i--) {

            if (i != index)
                if (trees.get(index) <= trees.get(i)) {
                    return false;
                }

        }

        return true;
    }

    public static boolean verifica_horizontal_right(List<Integer> trees, int column_max, int index, int contador_linhas) {

        for (int i = index; i < ((contador_linhas + 1) * column_max); i++) {


            if (i != index)
                if (trees.get(index) <= trees.get(i)) {
                    return false;
                }

        }

        return true;
    }

    public static Integer part_two(BufferedReader br) {
        try {
            String st;
            int number = 0;
            int column_max = 0;
            int row_max = 0;
            List<Integer> trees = new ArrayList<>();
            for (int i = 0; (st = br.readLine()) != null; i++) {

                column_max = st.length();
                row_max++;

                for (int y = 0; y < st.length(); y++) {
                    trees.add(Integer.parseInt(String.valueOf(st.charAt(y))));
                }
            }


            int contador_linhas = 0;
            int cont_aux = 1;
            int aux = 0;

            for (int i = 0; i < trees.size(); i++) {
                if (cont_aux == column_max) {
                    cont_aux = 0;
                    contador_linhas++;
                }
                cont_aux++;
                aux = verifica_vertical_top_part2(trees, column_max, i)*
                verifica_vertical_under_part2(trees, column_max, i)*
                verifica_horizontal_right_part2(trees, column_max, i, contador_linhas)*
                verifica_horizontal_left_part2(trees, column_max, i, contador_linhas);

                if (aux>number)
                    number=aux;


            }


            return number;


        } catch (Exception e) {
            System.out.println("Error in the counting!");
            return -1;

        }

    }

    public static int verifica_vertical_under_part2(List<Integer> trees, int column_max, int index) {

        int cont = 0;
        for (int i = index; i < trees.size(); i += column_max) {
            if (i != index) {

                if (trees.get(index) <= trees.get(i)) {
                    return cont;
                }
                cont++;
            }
        }
        return cont;
    }

    public static int verifica_vertical_top_part2(List<Integer> trees, int column_max, int index) {
        int cont = 0;

        for (int i = index; i >= 0; i -= column_max) {

            if (i != index) {
                if (trees.get(index) <= trees.get(i)) {
                    return cont;
                }
                cont++;
            }
        }

        return cont;
    }

    public static int verifica_horizontal_left_part2(List<Integer> trees, int column_max, int index, int contador_linhas) {


        int cont = 0;

        for (int i = index; i >= contador_linhas * column_max; i--) {

            if (i != index) {
                if (trees.get(index) <= trees.get(i)) {
                    return cont;
                }
                cont++;
            }
        }

        return cont;
    }

    public static int verifica_horizontal_right_part2(List<Integer> trees, int column_max, int index, int contador_linhas) {
        int cont = 0;

        for (int i = index; i <= ((contador_linhas + 1) * column_max); i++) {

        if (i < trees.size() ){
            if (i != index) {
                if (trees.get(index) <= trees.get(i)) {
                    return cont;
                }
            }
            cont++;

        }}

        return cont;
    }

}
