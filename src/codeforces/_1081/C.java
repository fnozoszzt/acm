package codeforces._1081;

import java.util.Scanner;

public class C {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();


        long[][] dp = new long[2004][2004];
        dp[1][0] = m;
        long mod = 998244353;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j] += dp[i][j];
                dp[i + 1][j + 1] += dp[i][j] * (m - 1);
                dp[i + 1][j] %= mod;
                dp[i + 1][j + 1] %= mod;
            }
        }
        System.out.println(dp[n][k]);




    }
}
