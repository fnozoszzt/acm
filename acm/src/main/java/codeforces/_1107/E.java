package codeforces._1107;

import java.util.Arrays;
import java.util.Scanner;

public class E {


    public static void main(String[] aaaa) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[][][] black = new long[105][105][105];
        long[][][] white = new long[105][105][105];
        for (int i = 0; i < 105; i++) {
            for (int j = 0; j < 105; j++) {
                Arrays.fill(black[i][j], Long.MIN_VALUE);
                Arrays.fill(white[i][j], Long.MIN_VALUE);
            }
        }

        char[] a = scanner.next().toCharArray();
        boolean[][] same = new boolean[105][105];
        int[] sum = new int[105];
        int[] w = new int[105];
        int[] next = new int[105];
        int[] pre = new int[105];
        Arrays.fill(pre, 1000);

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean s = true;
                for (int k = i; k <= j; k++) {
                    if (a[k] != a[i]) {
                        s = false;
                    }
                }
                same[i][j] = s;
                if (s) {
                    next[i] = Math.max(next[i], j);
                    pre[j] = Math.min(pre[j], i);
                }
            }

            if (a[i] == '0') {
                sum[i + 1] = sum[i];
            } else {
                sum[i + 1] = sum[i] + 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            w[i] = scanner.nextInt();
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(same[i][j] + " ");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(pre[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < n; i++) {
//            System.out.print(next[i] + " ");
//        }
//        System.out.println();


//        for (int i = n - 1; i >= 0; i--) {
//            for (int len = 1; i + len <= n; len++) {
//
//                if (len == 1) {
//                    dp[i][i + len] = w[1];
//                } else {
//                    for (int j = i + 1; j < i + len; j++) {
//                        dp[i][i + len] = Math.max(dp[i][i + len], dp[i][j] + dp[j][i + len]);
//                    }
//                    for (int j = i + 1; j < i + len; j++) {
//                        for (int k = j + 1; k < i + len; k++) {
//                            if (same[i][j - 1] && same[k][i + len - 1]) {
//                                if (a[i] == a[k]) {
//                                    dp[i][i + len] = Math.max(dp[i][i + len], dp[i][j] + dp[j][k] + dp[k][i + len] + w[len + i - k + j - i]);
//                                }
//                            }
//                        }
//                    }
//                    int sum_ = sum[i + len] - sum[i];
//                    int black = 0;
//                    int white = 0;
//                    for (int j = i; j < i + len; j++) {
//                        if (a[j] == '0' && j == pre[j]) {
//                            black += dp[j][next[j] + 1];
//                        }
//
//                        if (a[j] == '1' && j == pre[j]) {
//                            white += dp[j][next[j] + 1];
//                        }
//                    }
//                    black += w[sum_];
//                    white += w[len - sum_];
//                    dp[i][i + len] = Math.max(dp[i][i + len], white);
//                    dp[i][i + len] = Math.max(dp[i][i + len], black);
//
//                }
//
//
//                System.out.println(i + " " + (i + len) + " " + dp[i][i + len]);
//            }
//        }
//        System.out.println(dp[0][n]);


        for (int i = n - 1; i >= 0; i--) {
            for (int len = 1; i + len <= n; len++) {
                if (len == 1) {
                    if (a[i] == '0') {
                        black[i][i + len][0] = 0;
                        //black[i][i + len][1] = 0;
                        white[i][i + len][0] = w[1];
                        white[i][i + len][1] = 0;
                    } else {
                        black[i][i + len][0] = w[1];
                        black[i][i + len][1] = 0;
                        white[i][i + len][0] = 0;
                        //white[i][i + len][1] = 0;
                    }
                } else {
                    for (int j = i + 1; j < i + len; j++) {
                        for (int k = 0; k <= n; k++) {
                            black[i][i + len][k] = Math.max(black[i][i + len][k], black[i][j][k] + white[j][i + len][0]);
                            black[i][i + len][k] = Math.max(black[i][i + len][k], black[i][j][k] + black[j][i + len][0]);

                            black[i][i + len][k] = Math.max(black[i][i + len][k], black[i][j][0] + black[j][i + len][k]);
                            black[i][i + len][k] = Math.max(black[i][i + len][k], white[i][j][0] + black[j][i + len][k]);

                            white[i][i + len][k] = Math.max(white[i][i + len][k], white[i][j][k] + white[j][i + len][0]);
                            white[i][i + len][k] = Math.max(white[i][i + len][k], white[i][j][k] + black[j][i + len][0]);

                            white[i][i + len][k] = Math.max(white[i][i + len][k], white[i][j][0] + white[j][i + len][k]);
                            white[i][i + len][k] = Math.max(white[i][i + len][k], black[i][j][0] + white[j][i + len][k]);
                        }
                    }

                    for (int j = 0; j <= n; j++) {
                        if (a[i] == '0') {
                            black[i][i + len][j] = Math.max(black[i][i + len][j], black[i + 1][i + len][j] + w[1]);
                            black[i][i + len][0] = Math.max(black[i][i + len][0], black[i + 1][i + len][j] + w[j]);

                            white[i][i + len][j + 1] = Math.max(white[i][i + len][j + 1], white[i + 1][i + len][j]);
                            white[i][i + len][0] = Math.max(white[i][i + len][0], white[i + 1][i + len][j] + w[j + 1]);
                        } else {
                            white[i][i + len][j] = Math.max(white[i][i + len][j], white[i + 1][i + len][j] + w[1]);
                            white[i][i + len][0] = Math.max(white[i][i + len][0], white[i + 1][i + len][j] + w[j]);

                            black[i][i + len][j + 1] = Math.max(black[i][i + len][j + 1], black[i + 1][i + len][j]);
                            black[i][i + len][0] = Math.max(black[i][i + len][0], black[i + 1][i + len][j] + w[j + 1]);
                        }

                        if (a[i + len - 1] == '0') {
                            black[i][i + len][j] = Math.max(black[i][i + len][j], black[i][i + len - 1][j] + w[1]);
                            black[i][i + len][0] = Math.max(black[i][i + len][0], black[i][i + len - 1][j] + w[j]);

                            white[i][i + len][j + 1] = Math.max(white[i][i + len][j + 1], white[i][i + len - 1][j]);
                            white[i][i + len][0] = Math.max(white[i][i + len][0], white[i][i + len - 1][j] + w[j + 1]);
                        } else {
                            white[i][i + len][j] = Math.max(white[i][i + len][j], white[i][i + len - 1][j] + w[1]);
                            white[i][i + len][0] = Math.max(white[i][i + len][0], white[i][i + len - 1][j] + w[j]);

                            black[i][i + len][j + 1] = Math.max(black[i][i + len][j + 1], black[i][i + len - 1][j]);
                            black[i][i + len][0] = Math.max(black[i][i + len][0], black[i][i + len - 1][j] + w[j + 1]);
                        }
                    }
                }


//                System.out.println("== " + i + " " + (i + len));
//                for (int j = 0; j <= len; j++) {
//                    System.out.print(black[i][i + len][j] + " ");
//                }
//                System.out.println();
//                for (int j = 0; j <= len; j++) {
//                    System.out.print(white[i][i + len][j] + " ");
//                }
//                System.out.println();


            }

        }
        System.out.println(Math.max(black[0][n][0], white[0][n][0]));


    }
}
