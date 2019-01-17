package codeforces._1093;

import java.util.Scanner;

public class F {
    public static void main(String[] aaaa) {
        long mod = 998244353;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int l = scanner.nextInt();


        int[] a = new int[100005];
        //long[][][] dp = new long[100005][103][2];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        //dp[0][0][0] = 1;

        long[][] dp = new long[100005][104];
        int[] start = new int[100005];
        long[] sum = new long[100005];
        long[] com = new long[100005];

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (a[i] == -1) {

                } else {
                    //dp[i + 1][]
                    if (j == a[i]) {
                        if (dp[i][j][0] >= l - 1) {
                            dp[i + 1][a[i]][1] += dp[i][j][0];
                            dp[i + 1][a[i]][1] %= mod;
                        } else {
                            dp[i + 1][a[i]][0] += dp[i][j][0];
                            dp[i + 1][a[i]][0] %= mod;
                        }
                        dp[i + 1][a[i]][1] += dp[i][j][1];
                        dp[i + 1][a[i]][1] %= mod;
                    } else {

                    }

                }


            }
        }*/
        for (int i = 0; i < n; i++) {

        }




    }
}
