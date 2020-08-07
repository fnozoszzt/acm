package atcoder.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Y {

    static long mod = 1000000007;
    static long[] j = new long[200005];
    static long[] j_ = new long[200005];

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

    static class node implements Comparable<node> {
        int x;
        int y;

        @Override
        public int compareTo(node o) {
            if (x == o.x) {
                return Integer.compare(y, o.y);
            }
            return Integer.compare(x, o.x);
        }
    }

    static long c(int a, int b) {
        return j[a] * j_[b] % mod * j_[a - b] % mod;
    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w = scanner.nextInt();
        int n = scanner.nextInt();


        j[0] = 1;
        j_[0] = 1;
        for (int i = 1; i < j.length; i++) {
            j[i] = j[i - 1] * i % mod;
            j_[i] = pow(j[i], mod - 2);
        }
        node[] nodes = new node[3005];
        for (int i = 0; i < n; i++) {
            nodes[i] = new node();
            nodes[i].x = scanner.nextInt();
            nodes[i].y = scanner.nextInt();
        }
        Arrays.sort(nodes, 0, n);

        long[] dp = new long[3005];
        for (int i = 0; i < n; i++) {
            dp[i] = c(nodes[i].x + nodes[i].y - 2, nodes[i].x - 1);
            for (int k = 0; k < i; k++) {
                if (nodes[k].x <= nodes[i].x && nodes[k].y <= nodes[i].y) {
                    dp[i] -= dp[k] * c(nodes[i].x + nodes[i].y - nodes[k].x - nodes[k].y, nodes[i].x - nodes[k].x);
                }
                dp[i] %= mod;
            }
//            System.out.println("dp " + i + " " + dp[i]);
        }
        long sum = c(h + w - 2, h - 1);
        for (int i = 0; i < n; i++) {
            sum -= dp[i] * c(h + w - nodes[i].x - nodes[i].y, h - nodes[i].x);
            sum %= mod;
        }
        System.out.println((sum + mod) % mod);


    }
}
