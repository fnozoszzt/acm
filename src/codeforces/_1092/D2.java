package codeforces._1092;

import java.util.Scanner;

public class D2 {


    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[200005];
        int[] b = new int[200005];
        boolean flag = true;
        int num = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int aa = scanner.nextInt();

            if (num == 0) {
                a[num] = aa;
                b[num] = aa;
                num++;
            } else {
                if ((a[num - 1] - aa) == 0 && aa >= b[num - 1]) {
                    max = Math.max(max, aa);
                    num--;
                    if (num > 0) {
                        b[num - 1] = Math.max(b[num - 1], b[num]);
                    }
                    //if (num == 0) {
                    //    max = 0;
                    //}
                } else {
                    a[num] = aa;
                    b[num] = aa;
                    num++;
                }
            }
        }
        if (num == 0) {
            System.out.println("YES");
        } else if (num == 1) {
            if (a[0] >= max) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            System.out.println("NO");
        }




    }
}
