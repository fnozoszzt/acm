package codeforces._1088;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();



        for (int a = 1; a <= x; a++) {
            for (int b = 1; b <= x; b++) {
                if (a * b > x && a % b == 0 && a / b < x) {
                    System.out.println(a + " " + b);
                    return;
                }

            }
        }
        System.out.println(-1);


    }
}
