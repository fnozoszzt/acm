package codeforces._1104;

import java.util.Scanner;

public class C {
    static void work(int[][] data) {
        int[] a = new int[4];
        int[] b = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                a[i] += data[i][j];
                b[j] += data[i][j];
            }
        }
        for (int i = 0; i < 4; i++) {
            if (a[i] == 4) {
                for (int j = 0; j < 4; j++) {
                    data[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < 4; j++) {
            if (b[j] == 4) {
                for (int i = 0; i < 4; i++) {
                    data[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int[][] data = new int[4][4];
        char[] s = scanner.next().toCharArray();
        int i = 0;
        int j = 0;
        for (char c: s) {

            if (c == '0') {
                System.out.println("1 " + (i + 1));
                i++;
                i %= 4;
            } else {
                System.out.println((j + 1) + " 4");
                j += 2;
                j %= 4;
            }
//            if (c == '0') {
//                a:
//                for (int i = 0; i < 3; i++) {
//                    for (int j = 0; j < 4; j++) {
//                        if (data[i][j] == 0 && data[i + 1][j] == 0) {
//                            data[i][j] = 1;
//                            data[i + 1][j] = 1;
//                            System.out.println((i + 1) + " " + (j + 1));
//                            break a;
//                        }
//                    }
//                }
//                work(data);
//
//
//            } else {
//                a:
//                for (int i = 0; i < 4; i++) {
//                    for (int j = 0; j < 3; j++) {
//                        if (data[i][j] == 0 && data[i][j + 1] == 0) {
//                            data[i][j] = 1;
//                            data[i][j + 1] = 1;
//                            System.out.println((i + 1) + " " + (j + 1));
//                            break a;
//                        }
//                    }
//                }
//                work(data);
//            }

        }



    }
}
