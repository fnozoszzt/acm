package codeforces._1096;

import java.util.Scanner;


public class G {
    static long mod = 998244353;

    static int N = 1 << 20;
    static int r[] = new int[N];

    static long A[] = new long[N];
    static long B[] = new long[N];
    static long C[] = new long[N];
    static long D[];

    static long base[] = new long[N];

//    static long pow(long a, long b) {
//        if (b == 0) {
//            return 1;
//        }
//        if (b % 2 == 0) {
//            return pow(a * a % mod, b / 2);
//        } else {
//            return pow(a * a % mod, b / 2) % mod * a % mod;
//        }
//    }

    static long pow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % mod;
            }
            b >>= 1;
            if (b > 0) {
                a = a * a % mod;
            }
        }
        return ans;
    }

    static void ntt(long[] x, int lim, int opt) {
        int i, j, k, m;
        long g, gn, tmp;
        for (i = 0; i < lim; i++) {
            if (r[i] < i) {
                tmp = x[i];
                x[i] = x[r[i]];
                x[r[i]] = tmp;
            }
        }
        for (m = 2; m <= lim; m <<= 1) {
            k = m >> 1;
            gn = pow(3, (mod - 1) / m);
            for (i = 0; i < lim; i += m) {
                g = 1;
                for (j = 0; j < k; ++j, g = g * gn % mod)
                {
                    tmp = x[i + j + k] * g % mod;
                    x[i + j + k] = (x[i + j] - tmp + mod) % mod;
                    x[i + j] = (x[i + j] + tmp) % mod;
                }
            }
        }
        if (opt == -1) {
            int lim_2 = lim / 2;
            for (i = 1; i <= lim_2; i++) {
                tmp = x[i];
                x[i] = x[lim - i];
                x[lim - i] = tmp;
            }
            long inv = pow(lim, mod - 2);
            for (i = 0; i < lim; ++i)
                x[i] = x[i] * inv % mod;
        }
    }

    static void work(long[] a, long[] b, long[] c, int n) {
        ntt(a, n, 1);
        ntt(b, n, 1);
        for (int i = 0; i < n; ++i) {
            c[i] = a[i] * b[i] % mod;
        }
        ntt(c, n, -1);
    }

    static void work2(long[] a, long[] c, int n) {
        ntt(a, n, 1);
        for (int i = 0; i < n; ++i) {
            c[i] = a[i] * a[i] % mod;
        }
        ntt(c, n, -1);

//        System.out.print("work2 : ");
//        for (int i = 0; i < 100; i++) {
//            System.out.print(c[i] + " ");
//        }
//        System.out.println();
    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        long start = System.currentTimeMillis();

        int n = scanner.nextInt() / 2;
        int k = scanner.nextInt();
//        for (int i = 0; i < N; ++i)
//            r[i] = (i & 1) * (N >> 1) + (r[i >> 1] >> 1);

        int m[] = new int[1 << 21];
        m[0] = 1;
        for (int i = 1; i < m.length; i++) {
            if (i == m[i - 1]) {
                m[i] = i * 2;
            } else {
                m[i] = m[i - 1];
            }
        }
        A[0] = 1;
        for (int i = 0; i < k; i++) {
            base[scanner.nextInt()] = 1;
        }

//        System.out.print("base : ");
//        for (int i = 0; i < 100; i++) {
//            System.out.print(base[i] + " ");
//        }
//        System.out.println();

        int nn = 18;
        int nnn = 18;
        int last = 0;
        while (n > 0) {
            nn = m[nnn];
            if (nn > (1 << 20)) {
                nn = 1 << 20;
            }
            if (last == nn) {

            } else {
                for (int i = 0; i < nn; ++i)
                    r[i] = (i & 1) * (nn >> 1) + (r[i >> 1] >> 1);
                last = nn;
            }

//            System.out.println(n);
            if ((n & 1) == 0) {
                //work(A, base, C);
            } else {
                System.arraycopy(base, 0, B, 0, nn);
                work(B, A, C, nn);
                //System.arraycopy(C, 0, A, 0, nn);
                D = C;
                C = A;
                A = D;
            }
            n /= 2;


            if (n > 0) {
                work2(base, C, nn);
                D = C;
                C = base;
                base = D;
            }
            //System.arraycopy(C, 0, base, 0, nn);



            nnn <<= 1;
//            System.out.print("A : ");
//            for (int i = 0; i < 100; i++) {
//                System.out.print(A[i] + " ");
//            }
//            System.out.println();


        }
        long ans = 0;
        for (int i = 0; i < nn; i++) {
            ans += A[i] * A[i];
            ans %= mod;
        }
        System.out.println(ans);


        System.out.println(System.currentTimeMillis() - start);




//        int n = 0;
//        int lim = 1;
//        String a = scanner.next();
//        n = a.length();
//        for (int i = 0; i < n; i++)
//            A[i] = a.charAt(n - i - 1) - '0';
//        while (lim < (n << 1)) lim <<= 1;
//        String b = scanner.next();
//        n = b.length();
//        for (int i = 0; i < n; i++)
//            B[i] = b.charAt(n - i - 1) - '0';
//        while (lim < (n << 1)) lim <<= 1;
//        for (int i = 0; i < lim; ++i)
//            r[i] = (i & 1) * (lim >> 1) + (r[i >> 1] >> 1);
//        ntt(A, lim, 1);
//        ntt(B, lim, 1);
//        for (int i = 0; i < lim; ++i)
//            C[i] = A[i] * B[i] % mod;
//        ntt(C, lim, -1);

//        for (int i = 0; i < lim; i++) {
//            System.out.print(C[i] + " ");
//        }
//        System.out.println();
//        int len = 0;
//        for (int i = 0; i < lim; ++i) {
//            if (C[i] >= 10) {
//                len = i + 1;
//                C[i + 1] += C[i] / 10;
//                C[i] %= 10;
//            }
//            if (C[i] != 0) {
//                len = Math.max(len, i);
//            }
//        }
//        while (C[len] >= 10) {
//            C[len + 1] += C[len] / 10;
//            C[len] %= 10;
//            len++;
//        }
//        for (int i = len; i >= 0; --i)
//            System.out.print((char)(C[i] + '0'));
//        System.out.println();
    }
}