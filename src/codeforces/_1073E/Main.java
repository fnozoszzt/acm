package codeforces._1073E;

import java.util.Scanner;

public class Main {
    //和
    public static long dp1[][][] = new long[103][11][1200];
    //个数
    public static long dp2[][][] = new long[103][11][1200];

    public static long multi[] = new long[103];


    public static void main(String[] aaaa) {
        multi[0] = 1;
        for (int i = 0; i < 100; i++) {
            multi[i + 1] = (multi[i] * 10) % 998244353;
        }

        int bi[] = new int[10000];
        for (int i = 0; i < bi.length; i++) {
            int j = i;
            while (j != 0) {
                if ((j & 1) == 1) {
                    bi[i] += 1;
                }
                j >>= 1;
            }
        }


        //长度
        //开头第一位，开头可能是0
        //bitmap
        //dp[0][0][0] = 1;

        //初始化
        for (int i = 0; i < 10; i++) {
            dp1[1][i][1 << i] = i;
            dp2[1][i][1 << i] = 1;
        }

        for(int i = 1; i < 100; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 1024; k++) {
                    //下一位是什么
                    for (int l = 0; l < 10; l++) {
                        dp1[i + 1][l][k | (1 << l)] += (dp1[i][j][k]) + l * multi[i] * dp2[i][j][k];
                        dp1[i + 1][l][k | (1 << l)] %= 998244353;

                        dp2[i + 1][l][k | (1 << l)] += dp2[i][j][k];
                        dp2[i + 1][l][k | (1 << l)] %= 998244353;
                    }
                }
            }
        }
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.print(dp1[2][i][j] + " ");
//                System.out.print(dp2[2][i][j] + " ");
//            }
//            System.out.println();
//        }

        Scanner scanner = new Scanner(System.in);
        long begin = scanner.nextLong() - 1;
        long end = scanner.nextLong() + 1;
        int bit = scanner.nextInt();
        long res = 0;

//        if (begin != end) {
//            res += begin + end;
//        } else {
//            res += begin;
//        }

        long[] a = new long[100];
        long[] b = new long[100];
        int i = 1;
        while (begin > 0) {
            a[i] = begin % 10;
            begin /= 10;
            i++;
        }
        int j = 1;
        while (end > 0) {
            b[j] = end % 10;
            end /= 10;
            j++;
        }

        boolean flag = true;
        long aa = 0;
        long bb = 0;
        int aaa = 0;
        int bbb = 0;
        for (int k = j - 1; k > 0; k--) {
            if (! flag) {
                //System.out.println("flag " + k + " " + a[k] + " " + b[k]);
                //System.out.println(aa);
                //System.out.println(bb);
                //System.out.println(aaa);
                //System.out.println(bbb);
                for (int l = (int)a[k] + 1; l < 10; l++) {
                    //System.out.println("l " + l);
                    for (int m = 0; m < 1024; m++) {
                        if (bi[aaa | m] <= bit) {
                            //System.out.println("add " + l + " " + m);
                            //System.out.println("add1 " + dp1[k][l][m]);
                            //System.out.println("add2 " + dp2[k][l][m]);
                            res += dp1[k][l][m];
                            res %= 998244353;
                            res += dp2[k][l][m] * aa;
                            res %= 998244353;
                        }
                    }
                }

                for (int l = 0; l < b[k]; l++) {
                    for (int m = 0; m < 1024; m++) {
                        if (bi[bbb | m] <= bit) {
                            res += dp1[k][l][m];
                            res %= 998244353;
                            res += dp2[k][l][m] * bb;
                            res %= 998244353;
                        }
                    }
                }
                //System.out.println(res);
            }


            if (flag && a[k] != b[k]) {
                flag = false;
                //System.out.println("diff " + a[k] + " " + b[k] + " " + k);
                for (int l = (int)a[k] + 1; l < b[k]; l++) {
                    for (int m = 0; m < 1024; m++) {
                        if (bi[aaa | m] <= bit) {
                            //System.out.println(k + " " + l + " " + m);
                            //System.out.println(dp1[k][l][m]);
                            //System.out.println(dp2[k][l][m]);
                            res += dp1[k][l][m];
                            res %= 998244353;
                            res += dp2[k][l][m] * aa;
                            res %= 998244353;
                        }
                    }
                }
                //System.out.println("res " + res);
            }

            aa += a[k] * multi[k - 1];
            aa %= 998244353;
            if (k < i) {
                aaa |= (1 << a[k]);
            }
            bb += b[k] * multi[k - 1];
            bb %= 998244353;

                bbb |= (1 << b[k]);

        }

        System.out.println(res);


    }

}
