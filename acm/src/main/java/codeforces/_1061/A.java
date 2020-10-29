package codeforces._1061;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int S = scanner.nextInt();


        if (S % n == 0) {
            System.out.println(S / n);
        } else {
            System.out.println(S / n + 1);
        }



    }
}
