package codeforces._1096;

import java.util.Arrays;
import java.util.Scanner;

public class F {
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

    static long work(long[] a, int s, int e) {
        if (e <= s + 1) {
            return 0;
        }
        int m = (s + e) / 2;
        long sum = work(a, s, m) + work(a, m ,e);
        sum %= mod;
        int i = s, j = m;
        for (;i < m && j < e;) {
            if (a[i] > a[j]) {
//                System.out.println("l");
                j++;
                sum += (m - i);
//                System.out.println(sum);
            } else {
//                System.out.println("r");
                i++;
            }
        }
//        sum += (m - i) * (e - m);
//        System.out.println("work " + s + " " + e + " " + sum);
        Arrays.sort(a, s, e);
        return sum % mod;
    }


    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nn = 0;

        int[] a = new int[200005];
        long[] aa = new long[200005];
        boolean[] use = new boolean[200005];

        long[] num_unknown = new long[200005];
        long[] num_unuse = new long[200005];


        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] == -1) {
                num_unknown[i] = num_unknown[i - 1] + 1;
            } else {
                num_unknown[i] = num_unknown[i - 1];
                use[a[i]] = true;

                aa[nn] = a[i];
                nn++;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (use[i]) {
                num_unuse[i] = num_unuse[i - 1];
            } else {
                num_unuse[i] = num_unuse[i - 1] + 1;
            }
        }
//        System.out.println(num_unknown[n]);
        long sum = num_unknown[n] * (num_unknown[n] - 1) / 2 % mod * pow(2, mod - 2) % mod;
//        System.out.println(sum);
        for (int i = 1; i <= n; i++) {
            if (a[i] > 0) {
//                System.out.println(a[i] + " " + num_unknown[i] + " " + num_unuse[a[i]]);
                sum += (num_unknown[i] * (num_unknown[n] - num_unuse[a[i]]) + (num_unknown[n] - num_unknown[i]) * (num_unuse[a[i]])) % mod * pow(num_unknown[n], mod - 2);
                sum %= mod;
//                System.out.println((num_unknown[i] * (num_unknown[n] - num_unuse[a[i]])));
//                System.out.println((num_unknown[n] - num_unknown[i]) * (num_unuse[a[i]]));
            }
        }
//        System.out.println(sum);

//        long p = 1;
//        for (int i = 1; i <= n; i++) {
//            p *= i;
//            p %= mod;
//        }
//        System.out.println(work(aa, 0, nn));
        System.out.println(((sum + work(aa, 0, nn)) % mod + mod) % mod);


    }
}
