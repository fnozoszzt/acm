package codeforces._1085;

import java.util.ArrayList;
import java.util.Scanner;

public class C {
    public static int g(int x, int y, int xa, int ya) {
        if (x == xa && y == ya) {
            return -1;
        }
        if (x == xa) {
            return Math.abs(y - ya) - 1;
        }
        if (y == ya) {
            return Math.abs(x - xa) - 1;
        }
        return Math.abs(y - ya) - 1 + Math.abs(x - xa);
    }

    public static void put(int x, int y, int xa, int ya) {
        if (x == xa && y == ya) {
            return;
        }
        if (x == xa) {
            int _ = y + (ya - y) / Math.abs(y - ya);
            for (;_ != ya;_ += (ya - y) / Math.abs(y - ya)) {
                System.out.println(x + " " + _);
            }
            System.out.println(xa + " " + ya);
            return;
        }
        if (y == ya) {
            int _ = x + (xa - x) / Math.abs(x - xa);
            for (;_ != xa;_ += (xa - x) / Math.abs(x - xa)) {
                System.out.println(_ + " " + y);
            }
            System.out.println(xa + " " + ya);
            return;
        }
        int _ = y + (ya - y) / Math.abs(y - ya);
        for (;_ != ya;_ += (ya - y) / Math.abs(y - ya)) {
            System.out.println(x + " " + _);
        }
        System.out.println(x + " " + ya);
        _ = x + (xa - x) / Math.abs(x - xa);
        for (;_ != xa;_ += (xa - x) / Math.abs(x - xa)) {
            System.out.println(_ + " " + ya);
        }
        System.out.println(xa + " " + ya);
    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int xa = scanner.nextInt();
        int ya = scanner.nextInt();
        int xb = scanner.nextInt();
        int yb = scanner.nextInt();
        int xc = scanner.nextInt();
        int yc = scanner.nextInt();

        int min_x = 0;
        int min_y = 0;
        int min = 1000000;
        for (int x = 0; x <= 1000; x++) {
            for (int y = 0; y <= 1000; y++) {
                int sum = 4;
                sum += g(x, y, xa, ya);
                sum += g(x, y, xb, yb);
                sum += g(x, y, xc, yc);

                if (sum < min) {
                    min = sum;
                    min_x = x;
                    min_y = y;
                }



            }
        }
        System.out.println(min);
        put(min_x, min_y, xa, ya);
        put(min_x, min_y, xb, yb);
        put(min_x, min_y, xc, yc);
        System.out.println(min_x + " " + min_y);


    }
}
