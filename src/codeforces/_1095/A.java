package codeforces._1095;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] a = scanner.next().toCharArray();


        for (int i = 0; i < Math.sqrt(n); i++) {
            //System.out.println(i);
            System.out.print(a[(i + 1) * (i + 2) / 2 - 1]);
        }
        System.out.println();

    }
}
