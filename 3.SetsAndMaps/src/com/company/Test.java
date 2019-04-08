package com.company;


import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int row = 1; row <= 100; row++) {
            for (int col = 1; col <= row ; col++) {
                System.out.print(row);
            }
            System.out.println();
        }


    }
}
