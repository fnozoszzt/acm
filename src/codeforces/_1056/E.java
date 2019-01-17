package codeforces._1056;

import java.util.Scanner;

public class E {
    static long mod = 1000000007;
    static long base = 31;


    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);


        byte[] s = scanner.next().getBytes();
        byte[] t = scanner.next().getBytes();

        long sum0 = 0;
        long sum1 = 0;

        int first0 = 100000000;
        int first1 = 100000000;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                sum0++;
                first0 = Math.min(first0, i);
            } else {
                sum1++;
                first1 = Math.min(first1, i);
            }
        }
        long hash = 0;


        for (int i = 0; i < t.length; i++) {
            t[i] -= 'a';
            hash = hash * 31 + t[i];
            hash %= mod;
        }

        System.out.println(sum0);
        System.out.println(sum1);
        //long[] sum0 = new long[100005];
        //long[] sum1 = new long[100005];

        for (long i = 1; i * sum0 < t.length; i++) {
            if ((t.length - i * sum0) % sum1 == 0) {
                long j = (t.length - i * sum0) / sum1;

                System.out.println(i + " " + j);



            }
        }



    }
}
