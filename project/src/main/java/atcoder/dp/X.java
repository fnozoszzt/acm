package atcoder.dp;

import java.util.Arrays;
import java.util.Scanner;

public class X {
    static class node implements Comparable<node> {
        int w;
        int s;
        int sum;
        long v;

        public node(int w, int s, long v) {
            this.w = w;
            this.s = s;
            this.v = v;
            sum = w + s;
        }

        @Override
        public int compareTo(node o) {
            if (sum != o.sum) {
                return Integer.compare(sum, o.sum);
            }
            return Integer.compare(s, o.s);
        }
    }


    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        node[] nodes = new node[10000];
        long[] dp = new long[100005];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            nodes[i] = new node(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(nodes, 0, n);
        for (int i = 0; i < n; i++) {
            for (int j = nodes[i].s; j >= 0; j--) {
                if (dp[j] >= 0) {

                    if (j + nodes[i].w <= dp.length) {
                        dp[j + nodes[i].w] = Math.max(dp[j + nodes[i].w], dp[j] + nodes[i].v);
                    }
                }
            }



        }
        long max = 0;
        for (int i = 0; i < 1000; i++) {
            //System.out.println(i + " " + dp[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);



    }
}
