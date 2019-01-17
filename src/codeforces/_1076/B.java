package codeforces._1076;

import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        int[] prime = new int[200005];

        for (int i = 2; i * i < prime.length; i++) {
            for (int j = i; j * i < prime.length; j++) {
                prime[j * i] = 1;
            }
        }

        //for (int i = 0; i < 100000; i++) {
        //    System.out.println(i + " " + prime[i]);
        //}

        Scanner scanner = new Scanner(System.in);

        long _ = scanner.nextLong();
        if (_ % 2 == 0) {
            System.out.println(_ / 2);
            return;
        }


        int j = 2;
        boolean find = false;
        for (j = 2; j < prime.length; j++) {
            if (_ % j == 0) {
                find = true;
                break;

            }
        }
        if (find) {
            System.out.println((_ - j) / 2 + 1);
        } else {
            System.out.println(1);

        }

    }
}





