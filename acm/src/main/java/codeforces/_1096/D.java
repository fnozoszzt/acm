package codeforces._1096;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    static int maxn = 100100;
    static int n;
    static char[] s;
    static long a[] = new long[maxn];
    static long dp[][] = new long[maxn][8];


    static long gao( int i, int  j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (j >= 4) {
            return 1000000000000000L;
        }
        if (i >= n) {
            return 0;
        }
        long  ans = 1000000000000001L;
        ans = Math.min(ans, gao(i + 1, j) + a[i]);
        int x = -1;
        if (s[i] == 'h') {
            x = 0;
        } else if (s[i] == 'a') {
            x = 1;
        } else if (s[i] == 'r') {
            x = 2;
        } else if (s[i] == 'd') {
            x = 3;
        }
        if (j == x) {
            ans = Math.min(ans, gao(i + 1, j + 1));
        } else {
            ans = Math.min(ans, gao(i + 1, j));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);






n = scanner.nextInt();
s = scanner.next().toCharArray();
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            for (int i = 0; i < maxn; i++) {
                Arrays.fill(dp[i], -1);
            }
            System.out.println(gao(0, 0));


    }
}
