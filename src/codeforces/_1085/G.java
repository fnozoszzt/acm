package codeforces._1085;

import java.util.Arrays;
import java.util.Scanner;

public class G {
    static long mod = 998244353;
    static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % mod;
        }
        if (b % 2 == 1) {
            return pow(a * a % mod, b / 2) * a % mod;
        }
        return pow(a * a % mod, b / 2);
    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[][] c = new long[3000][3000];

        long[] jc = new long[3000];
        long[] diff = new long[3000];
        long[] add1 = new long[3000];
        jc[0] = 1;
        for (int i = 1; i < 3000; i++) {
            jc[i] = jc[i - 1] * i % mod;
        }
        for (int i = 0; i < 3000; i++) {
            c[i][0] = 1;
            c[i][i] = 1;
            //c[0][i] = 1;
        }
        //c[0][0] = 0;
        for (int i = 1; i < 3000; i++) {
            for (int j = 1; j <= i; j++) {
                c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
                c[i][j] %= mod;
                //System.out.println(i + " " + j + " " + c[i][j]);
            }
        }
        //System.out.println(c[3][2]);
        for (int i = 0; i < 3000; i++) {
            long sum = 0;
            for (int j = 0; j <= i; j++) {
                if (j % 2 == 0) {
                    sum += (c[i][j] * jc[i - j]);
                } else {
                    sum -= (c[i][j] * jc[i - j]);
                }
                sum %= mod;
            }
            sum %= mod;
            sum = sum + mod;
            sum %= mod;
            diff[i] = sum;

            if (i > 0) {
                add1[i] = add1[i - 1] * (i - 1) + diff[i - 1];
                add1[i] %= mod;
            }
            //System.out.println(i + " " + diff[i]);
        }
        //System.out.println(add1[1]);
        //   add1[1] = 0;

        long ans = 0;
        int[][] data = new int[3000][3000];
        for (int i = 0; i < n; i++) {
            int tree[] = new int[3000];
            boolean[] use = new boolean[3000];
            Arrays.fill(use, false);
            for (int j = 0; j < n; j++) {
                int a = scanner.nextInt();
                data[i][j] = a;
                int b = a;
                for (;b <= n; b += (b & -b)) {
                    tree[b]++;
                }
                use[a] = true;
                int m = 0;
                b = a;
                for (;b != 0;b -= b & -b) {
                    m += tree[b];
                }
                System.out.println(a + " " + m);
                m = a - m;
                if (i == 0) {
                    System.out.println("- " + m + " " + jc[n - j - 1] + " " + diff[n]);
                    ans += m * (jc[n - j - 1]) % mod * pow(diff[n], n - i - 1);
                } else {
                    if (data[i - 1][j] < a && ! use[data[i - 1][j]]) {
                        m--;
                    }
                    if (m < 0) {
                        m = 0;
                    }
                    System.out.println("- " + m + " " + add1[n - j - 1] + " " + diff[n]);
                    ans += m * (add1[n - j - 1]) % mod * pow(diff[n], n - i - 1);
                }
                ans %= mod;
                System.out.println(ans);



//                for ()


            }
        }
        System.out.println(ans);

    }
}
