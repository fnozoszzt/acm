package codeforces._1104;

import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();

        char[] a = new char[100005];
        int num = 0;
        int ans = 0;
        for (char c: s) {
            if (num == 0) {
                a[num++] = c;
            } else {
                if (c == a[num - 1]) {
                    num--;
                    ans++;
                } else {
                    a[num++] = c;
                }
            }
        }
        if (ans % 2 == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
