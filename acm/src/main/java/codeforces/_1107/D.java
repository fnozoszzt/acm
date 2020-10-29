package codeforces._1107;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class D {
    static byte[][] d = new byte[100][100];
    static byte[] get(char a) {
        if (a >= '0' && a <= '9') {
            return d[a - '0'];
        } else {
            return d[a - 'A' + 10];
        }
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] aaaa) throws Exception {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i & (1 << j)) > 0) {
                    d[i][3 - j] = 1;
                } else {
                    d[i][3 - j] = 0;
                }
            }
        }


//        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        in.nextToken();
        Scanner scanner = new Scanner(System.in);
//        int n = (int) in.nval;
        int n = scanner.nextInt();
        byte[][] data = new byte[5222][5222];
        for (int i = 0; i < n; i++) {
//            System.out.println(i);
//            in.nextToken();
//            System.out.println(in.sval);
//            char[] a = in.sval.toCharArray();
            char[] a = scanner.next().toCharArray();
            for (int j = 0; j < n / 4; j++) {
                byte[] dd = get(a[j]);
                for (int k = 0; k < 4; k++) {
                    data[i][j * 4 + k] = dd[k];
                }
            }
        }
        int ans = n;
        byte last = 2;
        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (data[i][j] == last) {
                    num++;
                } else {
                    ans = gcd(ans, num);
                    num = 1;
                    last = data[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int j = 0; j < n; j++) {
                if (data[j][i] == last) {
                    num++;
                } else {
                    ans = gcd(ans, num);
                    num = 1;
                    last = data[j][i];
                }
            }
        }
        System.out.println(ans);



    }
}
