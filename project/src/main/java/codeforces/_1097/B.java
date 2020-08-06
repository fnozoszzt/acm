package codeforces._1097;

import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[100];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    sum += a[j];
                } else {
                    sum -= a[j];
                }
            }
            if (sum % 360 == 0) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");




    }
}
