package codeforces._1096;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    static long mod = 998244353;

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


    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);


//        System.out.println(pow(100, mod - 2));

        int p = scanner.nextInt();
        int s = scanner.nextInt();
        int r = scanner.nextInt();

        if (p == 1) {
            System.out.println(1);
            return;
        }
        if (s == 0) {
            System.out.println(pow(p, mod - 2));
            return;
        }

        long[][] c = new long[605][605];

        for (int i = 0; i < 605; i++) {
            c[i][i] = 1;
            c[i][0] = 1;
        }
        for (int i = 1; i < 605; i++) {
            for (int j = 1; j < i; j++) {
                c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
                c[i][j] %= mod;
            }
        }
//        long base = c[s - r + p - 1][p - 1];
        long base = 1;
        long base2 = 1;
        for (int i = 1; i <= s - r + p - 1; i++) {
            base *= i;
            base %= mod;
        }
        for (int i = 1; i <= p - 1; i++) {
            base2 *= i;
            base2 %= mod;
        }
        for (int i = 1; i <= s - r; i++) {
            base2 *= i;
            base2 %= mod;
        }
//        System.out.println("base " + base);
//        System.out.println("base2 " + base2);
        base = base * pow(base2, mod - 2) % mod;
//        System.out.println("base " + base);

        long ans = 0;
        long[][] dp = new long[200][6000];
        long[][] sum = new long[200][6000];
        for (int h = Math.max(r, 1); h <= s; h++) {
            dp[0][0] = 1;
            Arrays.fill(sum[0], 1);
            for (int i = 1; i <= p; i++) {
                for (int j = 0; j <= s; j++) {
                    if (j >= h) {
                        dp[i][j] = sum[i - 1][j] - sum[i - 1][j - h];
                    } else {
                        dp[i][j] = sum[i - 1][j];
                    }
                    dp[i][j] %= mod;
                }
                sum[i][0] = dp[i][0];
                for (int j = 1; j <= s; j++) {
                    sum[i][j] = sum[i][j - 1] + dp[i][j];
                    sum[i][j] %= mod;
                }
            }

            System.out.println("h " + h);
            if (1 == 1) {
                continue;
            }

            for (int n = 0; n < p && (n + 1) * h <= s; n++) {



                long su = 0;
                int delete = (h) * (n + 1);// + (p - n - 1) * (s - h + 1);
//                System.out.println((s - h) + " " + (n + 1) + " " + (p - n) + " " + (s - h + 1));
//                System.out.println(h + " " + n + " " + delete);
                int remain = s - delete;
//                System.out.println("-- n " + n + " delete " + delete + " remain " + remain);
                if (remain == 0) {
//                    if (n + 1 == p) {
                        su = pow(n + 1, mod - 2) * c[p - 1][n] % mod;
//                    }
//                    System.out.println("remain0 " + su);
                } else if (remain > 0) {


//                    for (int i = 0; i <= p - n - 1; i++) {
//                        for (int j = 0; j <= remain; j++) {
//                            System.out.print(dp[i][j] + " ");
//                        }
//                        System.out.println();
//                    }
                    su = dp[p - n - 1][remain] * pow(n + 1, mod - 2) % mod * c[p - 1][n] % mod;
//                    System.out.println("remain " + su);

                }
//                if (remain >= 0) {
//
//                    if (p - n - 1 > 0) {
//                        System.out.println("remain " + remain);
//                        System.out.println(c[p - 1][n] * c[remain + p - n - 2][n] % mod);
//                        sum = c[p - 1][n] * c[remain + p - n - 2][p - n - 2] % mod * pow(n + 1, mod - 2) % mod;
//                    } else {
//                        if (remain == 0) {
//                            sum = pow(n + 1, mod - 2);
//                        }
//                    }
//                }
//                System.out.println("sum " + sum);
                ans += su;
                ans %= mod;



            }



        }
//        System.out.println(ans + " " + base);
        System.out.println(((ans * pow(base, mod - 2)) % mod + mod) % mod);



    }
}
