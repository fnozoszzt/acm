package codeforces._1079;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] a = new int[101];

        int max = 0;
        int type = 0;
        for (int i = 0; i < n; i++) {
            int j = scanner.nextInt();
            if (a[j] == 0) {
                type++;
            }
            a[j]++;
            if (a[j] > max) {
                max = a[j];
            }
        }
        while (max % k != 0) {
            max++;
        }

        System.out.println(max * type - n);



    }
}
