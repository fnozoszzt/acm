package codeforces._1105;

import java.util.Scanner;

public class C {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        long[][] dp = new long[200005][3];
        long mod = 1000000007;
        dp[0][0] = 1;
        int a = (r / 3) - ((l - 1) / 3);
        int b = ((r + 2) / 3) - ((l + 1) / 3);
        int c = ((r + 1) / 3) - ((l) / 3);

//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i + 1][j] += dp[i][j] * a;
                dp[i + 1][j] %= mod;
                dp[i + 1][(j + 1) % 3] += dp[i][j] * b;
                dp[i + 1][(j + 1) % 3] %= mod;
                dp[i + 1][(j + 2) % 3] += dp[i][j] * c;
                dp[i + 1][(j + 2) % 3] %= mod;
            }
        }
        System.out.println((dp[n][0]) % mod);




    }
}
