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
            int number = 1;
            List<coords> coords = new ArrayList<>();
            coords tail = new coords(0,0);
            coords head = new coords(0,0);

            coords.add(new coords(tail.getX(),tail.getY()));
            while ((st = br.readLine()) != null) {
                int number_repeats = Integer.parseInt(Character.toString(st.charAt(2)));
                switch (st.charAt(0))
                {
                    case 'R':
                        for (int i = 0; i < number_repeats; i++)
                        {
                            head.setX(head.getX()+1);
                            if (!verify_far(tail, head))
                            {
                                correct_pos_tail_R(tail, head);
                                boolean is_false = true;
                                for (coords c: coords) {
                                    if (c.getX() == tail.getX() && c.getY() == tail.getY())
                                        is_false=false;
                                }
                            if (is_false)
                                coords.add(new coords(tail.getX(),tail.getY()));
                            }
                        }
                        break;
                    case 'L':
                        for (int i = 0; i < number_repeats; i++)
                        {
                            head.setX(head.getX()-1);
                            if (!verify_far(tail, head))
                            {
                                correct_pos_tail_L(tail, head);
                                boolean is_false = true;
                                for (coords c: coords) {
                                    if (c.getX() == tail.getX() && c.getY() == tail.getY())
                                        is_false=false;
                                }
                                if (is_false)
                                    coords.add(new coords(tail.getX(),tail.getY()));
                            }
                        }
                        break;
                    case 'U':
                        for (int i = 0; i < number_repeats; i++)
                        {
                            head.setY(head.getY()+1);
                            if (!verify_far(tail, head))
                            {
                                correct_pos_tail_U(tail, head);
                                boolean is_false = true;
                                for (coords c: coords) {
                                    if (c.getX() == tail.getX() && c.getY() == tail.getY())
                                        is_false=false;
                                }
                                if (is_false)
                                    coords.add(new coords(tail.getX(),tail.getY()));
                            }
                        }
                        break;
                    case 'D':

                        for (int i = 0; i < number_repeats; i++)
                        {
                            head.setY(head.getY()-1);
                            if (!verify_far(tail, head))
                            {
                                correct_pos_tail_D(tail, head);
                                boolean is_false = true;
                                for (coords c: coords) {
                                    if (c.getX() == tail.getX() && c.getY() == tail.getY())
                                        is_false=false;
                                }
                                if (is_false)
                                    coords.add(new coords(tail.getX(),tail.getY()));
                            }
                        }
                        break;
                }

            }




            number = coords.size();
            return number;

        } catch (Exception e) {
            System.out.println("Error in the counting!");
            return -1;

        }
    }

    public static void correct_pos_tail_D(coords tail, coords head)
    {
        tail.setY(tail.getY()-1);

        if (!verify_far_diagonal(tail, head))
            tail.setX(tail.getX()+1);
        if (!verify_far_diagonal(tail, head))
            tail.setX(tail.getX()-2);

    }

    public static void correct_pos_tail_U(coords tail, coords head)
    {
        tail.setY(tail.getY()+1);
        if (!verify_far_diagonal(tail, head))
            tail.setX(tail.getX()+1);
        if (!verify_far_diagonal(tail, head))
            tail.setX(tail.getX()-2);

    }

    public static void correct_pos_tail_L(coords tail, coords head)
    {
        tail.setX(tail.getX()-1);

        if (!verify_far_diagonal(tail, head))
            tail.setY(tail.getY()+1);
        if (!verify_far_diagonal(tail, head))
            tail.setY(tail.getY()-2);

    }

    public static void correct_pos_tail_R(coords tail, coords head)
    {
        tail.setX(tail.getX()+1);

        if (!verify_far_diagonal(tail, head))
            tail.setY(tail.getY()+1);
        if (!verify_far_diagonal(tail, head))
            tail.setY(tail.getY()-2);

    }


    public static boolean verify_far_diagonal (coords tail, coords head)
    {
        if ((tail.getY() == head.getY() && (tail.getX()+1) == head.getX())
        ||    ((tail.getY()+1) == head.getY() && tail.getX() == head.getX())
                ||    ((tail.getY()-1) == head.getY() && tail.getX() == head.getX()) ||
                (tail.getY() == head.getY() && (tail.getX()-1) == head.getX())
        )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean verify_far (coords tail, coords head)
    {
        if (tail.getX() - head.getX() > 1 ||  tail.getX() - head.getX() < -1 ||
                tail.getY() - head.getY() > 1 ||  tail.getY() - head.getY() < -1
        )
        {
            return false;
        }
        else
        {
            return true;
        }
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


                if (aux>number)
                    number=aux;


            }


            return number;


        } catch (Exception e) {
            System.out.println("Error in the counting!");
            return -1;

        }

    }

}
