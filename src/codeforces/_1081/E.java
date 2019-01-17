package codeforces._1081;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    static int maxn = 200020;
    static long a[] = new long[maxn];
    static long sum[] = new long[maxn];
    static long ans[] = new long[maxn];
    static long valid = 10000000000000L;

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);




            int n = scanner.nextInt();
            for (int i = 1; i <= n / 2; ++i) {
                a[i] = scanner.nextLong();
                sum[i] = sum[i - 1] + a[i];
            }
            long c = 1, s = 0;
            for (int i = 1; i <= n / 2; ++i) {
                while (c * c < s + sum[i - 1]) {
                    c += 1;
                }
                // printf("fuck %lld %lld\n", sum[i - 1], c);
                while (true) {
                    ans[i] = c * c - (s + sum[i - 1]);
                    if (ans[i] > valid) {
                        System.out.println("No");
                        return;
                    }
                    long tmp = s + ans[i] + sum[i];
                    double ttmp = (long)(Math.sqrt(tmp));
                    if (ttmp * ttmp == tmp
                            || (ttmp - 1) * (ttmp - 1) == tmp
                            || (ttmp + 1) * (ttmp + 1) == tmp) {
                        break;
                    }
                    c += 1;
                }
                s += ans[i];
            }
            for (int i = 1; i <= n / 2; ++i) {
                if (ans[i] > valid) {
                    System.out.println("No");
                    return;
                }
            }
        System.out.println("Yes");
            for (int i = 1; i <= n / 2; ++i) {
                System.out.print(ans[i] + " " + a[i] + " ");
            }
System.out.println();



    }
}
