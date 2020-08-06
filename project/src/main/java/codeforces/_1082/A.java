package codeforces._1082;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int d = scanner.nextInt();

            if ((x - y) % d == 0) {
                System.out.println(Math.abs(x - y) / d);
            } else {
                int a = 2000000000;
                int b = 2000000000;
                if ((y - 1) % d == 0) {
                    a = x / d + (y - 1) / d;
                }
                if ((n - y) % d == 0) {
                    b = (n - y) / d + (n - x + 1) / d;
                }
                if (a == 2000000000 && b == 2000000000) {
                    System.out.println(-1);
                } else {
                    System.out.println(Math.min(a, b));
                }


            }

        }




    }
}
