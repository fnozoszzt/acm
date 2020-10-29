package codeforces._1091;

import java.util.Scanner;

public class D {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);


       long mod = 998244353;

       long[] p = new long[1000006];
       long[] a = new long[1000006];

       int n = scanner.nextInt();
       p[0] = 1;
       for (int i = 1; i <= n; i++) {
           p[i] = p[i - 1] * i % mod;
       }
       a[0] = 1;
       for (int i = 1; i <= n; i++) {
           a[i] = a[i - 1] * (n + 1 - i) % mod;
       }

       long ans = p[n];
//       System.out.println(ans);
       for (int i = 1; i < n; i++) {
           ans += (a[i]) * (n - i - 1) % mod * i % mod;
//           System.out.println((a[i]) * (n - i - 1) % mod * i % mod);
       }
       System.out.println(ans % mod);






    }
}
