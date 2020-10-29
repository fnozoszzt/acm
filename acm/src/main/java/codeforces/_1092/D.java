package codeforces._1092;

import java.util.Arrays;
import java.util.Scanner;

public class D {


    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[100005];
        boolean flag = true;
        int num = 0;
        for (int i = 0; i < n; i++) {
            int aa = scanner.nextInt();
            if (num == 0) {
                a[num] = aa;
                num++;
            } else {
                if ((a[num - 1] - aa) % 2 == 0) {
                    num--;
                } else {
                    a[num] = aa;
                    num++;
                }
            }
        }
        if (num <= 1) {
            System.out.println("YES");
        } else  {
            System.out.println("NO");
        }




    }
}
