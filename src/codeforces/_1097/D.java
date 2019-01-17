package codeforces._1097;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class D {
    static long mod = 1000000007;
    static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return pow(a * a % mod, b / 2);
        } else {
            return pow(a * a % mod, b / 2) % mod * a % mod;
        }
    }



    static long res = 0;
    static long work(long[] f, int[] f2, long[][] ans, int idx, int c, long num, long pro) {
        if (c == idx) {
//            System.out.println("final " + num + " " + pro);
            res += num * pro;
            res %= mod;

            return 0;
        }

        for (int i = 0; i <= f2[c]; i++) {
            work(f, f2, ans, idx, c + 1, num * pow(f[c], i) % mod, pro * ans[c][i] % mod);
        }
        return 0;
    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);


        long[] ni = new long[1005];
        for (int i = 1; i < 1005; i++) {
            ni[i] = pow(i, mod - 2);
        }

        long n = scanner.nextLong();
        int k = scanner.nextInt();

        long[] f = new long[100];
        int[] f2 = new int[100];
        long[][] dp = new long[10005][105];
        long[][] ans = new long[105][105];
        int idx = 0;

        long nn = n;
        for (long i = 2; i * i <= n; i++) {
            if (nn == 1) {
                break;
            }
            if (nn % i == 0) {
                //System.out.println(i);
                f[idx] = i;
                while (nn % i == 0) {
                    nn /= i;
                    f2[idx]++;
                }

                idx++;

            }
        }
        if (nn > 1) {
            f[idx] = nn;
            f2[idx]++;
            idx++;
        }
//        for (int i = 0; i < idx; i++) {
//            System.out.println(f[i] + " " + f2[i]);
//        }

        for (int i = 0; i < idx; i++) {
            Arrays.fill(dp[0], 0);
            dp[0][f2[i]] = 1;
            for (int j = 1; j <= k; j++) {
//                long sum = 0;
                for (int l = f2[i]; l >= 0; l--) {

//
//                    sum += dp[j - 1][l];
//                    sum %= mod;
                    long sum = 0;
                    for (int m = f2[i]; m >= l; m--) {
                        sum += (dp[j - 1][m] * ni[m + 1]);
                        sum %= mod;
                    }

                    dp[j][l] = sum;

//                    System.out.println(j + " " + l + " " + dp[j][l]);
                }
            }

            for (int j = 0; j <= f2[i]; j++) {
                ans[i][j] = dp[k][j];
            }

        }

        work(f, f2, ans, idx, 0, 1, 1);
        System.out.println(res);





    }
}
