package codeforces._1079;

import java.util.Scanner;

public class C {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[100005];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        int dp[][] = new int[100005][6];
        //int dp2[][] = new int[100005][6];
        dp[1][1] = dp[1][2] = dp[1][3] = dp[1][4] = dp[1][5] = 1;

        for (int i = 1; i <= n - 1; i++) {
            if (a[i] > a[i + 1]) {
                for (int j = 1; j <= 5; j++) {
                    if (dp[i][j] > 0) {
                        for (int k = 1; k < j; k++) {
                            dp[i + 1][k] = j;
                        }
                    }
                }
            }
            if (a[i] < a[i + 1]) {
                //System.out.println("small " + i);
                for (int j = 1; j <= 5; j++) {
                    if (dp[i][j] > 0) {
                        for (int k = j + 1; k <= 5; k++) {
                            dp[i + 1][k] = j;
                            //System.out.println(i + " " + j + " " + k);
                        }
                    }
                }
            }
            if (a[i] == a[i + 1]) {
                for (int j = 1; j <= 5; j++) {
                    if (dp[i][j] > 0) {
                        for (int k = 1; k <= 5; k++) {
                            if (j != k) {
                                dp[i + 1][k] = j;
                            }
                        }
                    }
                }
            }
        }
        if (dp[n][1] == 0 && dp[n][2] == 0 && dp[n][3] == 0 && dp[n][4] == 0 && dp[n][5] == 0) {
            System.out.println(-1);
        } else {
            int i;
            for (i = 1; i <= 5; i++) {
                if (dp[n][i] > 0) {
                    break;
                }
            }
            int ans[] = new int[100005];
            StringBuilder stringBuilder = new StringBuilder();
            ans[n] = i;
            for (int j = n - 1; j > 0; j--) {
                i = dp[j + 1][i];
                ans[j] = i;
            }
            for (int j = 1; j <= n - 1; j++) {
                stringBuilder.append(ans[j]);
                stringBuilder.append(" ");
            }
            stringBuilder.append(ans[n]);
            System.out.println(stringBuilder);
        }




    }
}
