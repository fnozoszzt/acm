package codeforces._1076;

import java.util.Scanner;

public class A {
    public static void main(String[] aa) {
        Scanner scanner = new Scanner(System.in);

        int _ = scanner.nextInt();
        String s = scanner.next();

        int i;
        for (i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                break;
            }
        }
        if (i == s.length()) {
            i--;
        }
        System.out.println(s.substring(0, i - 1) + s.substring(i));

    }
}
