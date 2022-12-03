package com.AndreAmorim;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Main {
    public static void main(String[] args) {
        try {
            File file = new File(
                    "plays.txt");

            BufferedReader br
                    = new BufferedReader(new FileReader(file));

            String st;

            int totalpoints_part2 = 0;
            int totalpoints_part1 = 0;

            while ((st = br.readLine()) != null) {
                char opponent_play = st.charAt(0);
                char my_play = st.charAt(2);
                switch (my_play) {
                    case 'X':
                        totalpoints_part1 += 1;
                        if (opponent_play == 'A') {
                            totalpoints_part1 += 3;
                        }
                        if (opponent_play == 'C') {
                            totalpoints_part1 += 6;
                        }

                        break;
                    case 'Y':
                        totalpoints_part1 += 2;
                        if (opponent_play == 'B') {
                            totalpoints_part1 += 3;
                        }
                        if (opponent_play == 'A') {
                            totalpoints_part1 += 6;
                        }

                        break;
                    case 'Z':
                        totalpoints_part1 += 3;
                        if (opponent_play == 'C') {
                            totalpoints_part1 += 3;
                        }
                        if (opponent_play == 'B') {
                            totalpoints_part1 += 6;
                        }

                        break;
                }
                //-----------------------------Part 2-----------------------------------------//
                char win_or_lose = st.charAt(2);
                switch (opponent_play) {
                    case 'A':
                        if (win_or_lose == 'X') {
                            totalpoints_part2 += 3;
                        } else if (win_or_lose == 'Y') {
                            totalpoints_part2 += 3;
                            totalpoints_part2 += 1;
                        } else {
                            totalpoints_part2 += 6;
                            totalpoints_part2 += 2;
                        }

                        break;
                    case 'B':
                        if (win_or_lose == 'X') {
                            totalpoints_part2 += 1;
                        } else if (win_or_lose == 'Y') {
                            totalpoints_part2 += 3;
                            totalpoints_part2 += 2;
                        } else {
                            totalpoints_part2 += 6;
                            totalpoints_part2 += 3;
                        }

                        break;
                    case 'C':
                        if (win_or_lose == 'X') {
                            totalpoints_part2 += 2;
                        } else if (win_or_lose == 'Y') {
                            totalpoints_part2 += 3;
                            totalpoints_part2 += 3;
                        } else {
                            totalpoints_part2 += 6;
                            totalpoints_part2 += 1;
                        }

                        break;
                }
            }
            System.out.println("\nTotal points not kwowing the secret:" + totalpoints_part1);
            System.out.println("\nTotal points kwowing the secret:" + totalpoints_part2);

        } catch (Exception e) {
            System.out.println("Error!");
        }
    }
}
