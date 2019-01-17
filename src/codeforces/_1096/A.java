package codeforces._1096;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            if (r >= l * 2) {
                System.out.println(l + " " + (l * 2));
            }
        }

    }
}
