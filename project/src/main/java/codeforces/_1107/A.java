package codeforces._1107;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String a = scanner.next();

            if (n == 2) {
                if (a.charAt(0) < a.charAt(1)) {
                    System.out.println("YES");
                    System.out.println(2);
                    System.out.println(a.substring(0, 1) + " " + a.substring(1));
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("YES");
                System.out.println(2);
                System.out.println(a.substring(0, 1) + " " + a.substring(1));
            }



        }

    }
}
