package codeforces._1076;

import java.util.Scanner;

public class C {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int _ = scanner.nextInt();
        while (_ > 0) {
            _ --;

            double d = scanner.nextDouble();

            if (d * d >= 4 * d) {
                double a = (d + Math.sqrt(d * d - 4 * d)) / 2;
                double b = (d - Math.sqrt(d * d - 4 * d)) / 2;
                System.out.println("Y " + a + " " + b);
            } else {
                System.out.println("N");
            }




        }

    }
}
