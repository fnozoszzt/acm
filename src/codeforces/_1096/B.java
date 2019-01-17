package codeforces._1096;

import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] a = scanner.next().toCharArray();
        long mod = 998244353;

        long q = 0;
        long w = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == a[0]) {
                q++;
            } else {
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == a[n - 1]) {
                w++;
            } else {
                break;
            }
        }


        if (a[0] == a[n - 1]) {
            System.out.println((q + 1) * (w + 1) % mod);
        }

        //System.out.println();

        else {
            System.out.println((q + w + 1) % mod);
        }




    }
}
