package codeforces._1080;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class D {
    public static long getwhite(long x, long y) {
        if (x * y % 2 == 0) {
            return x * y / 2;
        } else {
            return x * y / 2 + 1;
        }
    }
    public static long getwhite(long x1, long y1, long x2, long y2) {
        return getwhite(x2, y2) + getwhite(x1, y1) - getwhite(x1, y2) - getwhite(x2, y1);

    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int _ = 0; _ < t; _++) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();

            double min_n = Math.log(k * 3 + 1) / Math.log(2) / 2;
            //System.out.println(min_n);

            if (n < min_n) {
                System.out.println("NO");
            } else {
                long sum = 0;
                long tmp = 1;
                int time = 0;
                for (time = 0; sum <= k;time++) {
                    sum += tmp;
                    tmp = tmp * 2 + 1;
                }
                time--;
                if (time <= n) {
                    System.out.println("YES " + (time - 1));
                } else {
                    System.out.println("YES " + n);
                }
            }

            //System.out.println("-");


        }
        //System.out.println('-');



    }
}
