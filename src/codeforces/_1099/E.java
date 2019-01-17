package codeforces._1099;

import java.io.*;
import java.util.Scanner;

public class E {
    static int[][][] count;
    static int[][][] count2;
    static int[][][] ans;
    static int n, m;
    static int work(int idx, int i, int j, int k, int l) {
        int num = 0;
        for (int q = 0; q < n; q++) {
            if (q % 2 == 0) {
                int a = ((m + 1) / 2 - count[q][0][i]) + (m / 2 - count[q][1][j]);
                int b = ((m + 1) / 2 - count[q][0][j]) + (m / 2 - count[q][1][i]);
//                System.out.println(i + " " + j + " " + q + " " + a + " " + b);
                if (a < b) {
                    ans[idx][q][0] = i;
                    ans[idx][q][1] = j;
                    num += a;
                } else {
                    ans[idx][q][1] = i;
                    ans[idx][q][0] = j;
                    num += b;
                }
                //num += Math.min(a, b);
            } else {
                int a = ((m + 1) / 2 - count[q][0][k]) + (m / 2 - count[q][1][l]);
                int b = ((m + 1) / 2 - count[q][0][l]) + (m / 2 - count[q][1][k]);
//                System.out.println(i + " " + j + " " + q + " " + a + " " + b);
//                num += Math.min(a, b);
                if (a < b) {
                    ans[idx][q][0] = k;
                    ans[idx][q][1] = l;
                    num += a;
                } else {
                    ans[idx][q][1] = k;
                    ans[idx][q][0] = l;
                    num += b;
                }
            }
        }
        return num;
    }

    static int work2(int idx, int i, int j, int k, int l) {
        int num = 0;
        for (int q = 0; q < m; q++) {
            if (q % 2 == 0) {
                int a = ((n + 1) / 2 - count2[q][0][i]) + (n / 2 - count2[q][1][j]);
                int b = ((n + 1) / 2 - count2[q][0][j]) + (n / 2 - count2[q][1][i]);
//                System.out.println(i + " " + j + " " + q + " " + a + " " + b);
                if (a < b) {
                    ans[idx][q][0] = i;
                    ans[idx][q][1] = j;
                    num += a;
                } else {
                    ans[idx][q][1] = i;
                    ans[idx][q][0] = j;
                    num += b;
                }
                //num += Math.min(a, b);
            } else {
                int a = ((n + 1) / 2 - count2[q][0][k]) + (n / 2 - count2[q][1][l]);
                int b = ((n + 1) / 2 - count2[q][0][l]) + (n / 2 - count2[q][1][k]);
//                System.out.println(i + " " + j + " " + q + " " + a + " " + b);
//                num += Math.min(a, b);
                if (a < b) {
                    ans[idx][q][0] = k;
                    ans[idx][q][1] = l;
                    num += a;
                } else {
                    ans[idx][q][1] = k;
                    ans[idx][q][0] = l;
                    num += b;
                }
            }
        }
        return num;
    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
//        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));


        n = scanner.nextInt();
        m = scanner.nextInt();
        char[][] a = new char[n + 5][m + 5];
        char[][] output = new char[n + 5][m + 5];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }

        count = new int[n + 10][2][5];
        count2 = new int[m + 10][2][5];
        ans = new int[20][n + m + 2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'A') {
                    count[i][j % 2][0]++;
                    count2[j][i % 2][0]++;
                }
                if (a[i][j] == 'G') {
                    count[i][j % 2][1]++;
                    count2[j][i % 2][1]++;
                }
                if (a[i][j] == 'C') {
                    count[i][j % 2][2]++;
                    count2[j][i % 2][2]++;
                }
                if (a[i][j] == 'T') {
                    count[i][j % 2][3]++;
                    count2[j][i % 2][3]++;
                }

            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                for (int k = 0; k < 4; k++)
//                System.out.print(count[i][j][k] + " ");
//                System.out.println();
//            }
//        }
//        System.out.println("--");

        int max = 100000000;

        int idx = 0;

        int aa = work(0, 0, 1, 2, 3);
        if (aa < max) {
            max = aa;
            idx = 0;
        }
        aa = work(1, 0, 2, 1, 3);
        if (aa < max) {
            max = aa;
            idx = 1;
        }
        aa = work(2, 0, 3, 1, 2);
        if (aa < max) {
            max = aa;
            idx = 2;
        }
        aa = work(3, 1, 2, 0, 3);
        if (aa < max) {
            max = aa;
            idx = 3;
        }
        aa = work(4, 1, 3, 0, 2);
        if (aa < max) {
            max = aa;
            idx = 4;
        }
        aa = work(5, 2, 3, 1, 0);
        if (aa < max) {
            max = aa;
            idx = 5;
        }
//        System.out.println("==");


        aa = work2(7, 0, 1, 2, 3);
        if (aa < max) {
            max = aa;
            idx = 7;
        }
        aa = work2(8, 0, 2, 1, 3);
        if (aa < max) {
            max = aa;
            idx = 8;
        }
        aa = work2(9, 0, 3, 1, 2);
        if (aa < max) {
            max = aa;
            idx = 9;
        }
        aa = work2(10, 1, 2, 0, 3);
        if (aa < max) {
            max = aa;
            idx = 10;
        }
        aa = work2(11, 1, 3, 0, 2);
        if (aa < max) {
            max = aa;
            idx = 11;
        }
        aa = work2(12, 2, 3, 1, 0);
        if (aa < max) {
            max = aa;
            idx = 12;
        }

//        System.out.println(idx);
        if (idx < 6) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ans[idx][i][j % 2] == 0) {
                        output[i][j] = 'A';
                    }
                    if (ans[idx][i][j % 2] == 1) {
                        output[i][j] = 'G';
                    }
                    if (ans[idx][i][j % 2] == 2) {
                        output[i][j] = 'C';
                    }
                    if (ans[idx][i][j % 2] == 3) {
                        output[i][j] = 'T';
                    }


                }
                out.println(new String(output[i], 0, m));
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ans[idx][j][i % 2] == 0) {
                        output[i][j] = 'A';
                    }
                    if (ans[idx][j][i % 2] == 1) {
                        output[i][j] = 'G';
                    }
                    if (ans[idx][j][i % 2] == 2) {
                        output[i][j] = 'C';
                    }
                    if (ans[idx][j][i % 2] == 3) {
                        output[i][j] = 'T';
                    }


                }
            }
            for (int i = 0; i < n; i++) {
                out.println(new String(output[i], 0, m));
            }
        }
        out.flush();




    }
}
