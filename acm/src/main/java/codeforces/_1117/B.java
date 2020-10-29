package codeforces._1117;

import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[100005];
        int[] b = new int[100005];
        a[0] = -1;
        int max1 = 0;
        int max2 = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] == a[i - 1]) {
                b[i] = b[i - 1] + 1;
            } else {
                b[i] = 1;
            }
            if (a[i] > max1) {
                max1 = a[i];
                max2 = b[i];
            } else if (a[i] == max1 && b[i] > max2) {
                max1 = a[i];
                max2 = b[i];
            }
        }
        System.out.println(max2);


    }
}
