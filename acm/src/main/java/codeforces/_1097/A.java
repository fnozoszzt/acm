package codeforces._1097;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        for (int i = 0; i < 5; i++) {
            String b = scanner.next();
            if (b.charAt(0) == a.charAt(0) || b.charAt(1) == a.charAt(1)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");


    }
}
