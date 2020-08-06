package codeforces._1092;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            /*for (int i = 0; i < k; i++) {
                System.out.print((char)('a' + i));
            }*/
            for (int i = 0; i < n; i++) {
                System.out.print((char)('a' + (i % k)));
            }
            System.out.println();
        }
    }
}
