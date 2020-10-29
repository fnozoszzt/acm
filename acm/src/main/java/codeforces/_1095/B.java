package codeforces._1095;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[200005];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a, 0, n);
        if (a[1] - a[0] > a[n - 1] - a[n - 2]) {
            System.out.println(a[n - 1] - a[1]);
        } else {
            System.out.println(a[n - 2] - a[0]);

        }

    }
}
