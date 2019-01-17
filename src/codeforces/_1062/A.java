package codeforces._1062;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int _ = scanner.nextInt();

        int[] a = new int[_ + 2];
        a[0] = 0;
        for (int i = 0; i < _; i++) {
            a[i + 1] = scanner.nextInt();
        }
        a[_ + 1] = 1001;

        int now = 0;
        int ans = 0;
        for (int i = 0; i <= _; i++) {
            if (a[i] + 1 == a[i + 1]) {
                now++;
                if (ans < now) {
                    ans = now;
                }
            } else {
                now = 0;
            }
        }
        if (ans == 0)
            System.out.println(0);
        else
            System.out.println(ans - 1);
    }
}
