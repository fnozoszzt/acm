package codeforces._1088;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        int[] a = new int[10005];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int sum = 0;
        System.out.println(n + 1);
        for (int i = n - 1; i >= 0; i--) {
            int to = i;

            int aa = ((to - a[i] - sum) % n + n) % n;
            System.out.println(1 + " " + (i + 1) + " " + aa);
            sum += aa;



        }
        System.out.println("2 " + n + " " + n);








    }
}
