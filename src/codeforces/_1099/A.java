package codeforces._1099;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        int u1 = scanner.nextInt();
        int d1 = scanner.nextInt();
        int u2 = scanner.nextInt();
        int d2 = scanner.nextInt();

        if (d1 < d2) {
            int tmp = d1;
            d1 = d2;
            d2 = tmp;

            tmp = u1;
            u1 = u2;
            u2 = tmp;
        }

        for (int i = h; i >= d1; i--) {
            w += i;
        }
        if (w < u1) {
            w = 0;
        } else {
            w -= u1;
        }

        for (int i = d1 - 1; i >= d2; i--) {
            w += i;
        }
        if (w < u2) {
            w = 0;
        } else {
            w -= u2;
        }

        for (int i = d2 - 1; i >= 0; i--) {
            w += i;
        }
        System.out.println(w);


    }
}
