package codeforces._1099;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class D {



static int maxn = 100010;

    static ArrayList<Integer> edge[] = new ArrayList[maxn];
    static {
        for (int i = 0; i < maxn; i++) {
            edge[i] = new ArrayList<>();
        }
    }
    static long sum[] = new long[maxn];
    static long a[] = new long[maxn];
    static int par[] = new int[maxn];
    static boolean vis[] = new boolean[maxn];

    static void dfs(int root, int p) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.push(root);
        while (q.size() > 0) {
            int u = q.peekFirst();
            q.pop();
            vis[u] = true;
            long sumu = 1000000008;
            for (int i = 0; i < edge[u].size(); ++i) {
                int v = edge[u].get(i);
                if (!vis[v]) {
                    q.push(v);
                    if (sum[u] == -1) {
                        sumu = Math.min(sumu, sum[v]);
                    }
                }
            }
            p = par[u];
            if (sum[u] == -1) {
                if (sumu == 1000000008) {
                    a[u] = 0;
                    sum[u] = sum[p];
                } else {
                    sum[u] = sumu;
                    a[u] = sum[u] - sum[p];
                }
            } else {
                if (p != -1) {
                    a[u] = sum[u] - sum[p];
                }
            }
        }
    }





    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 2; i <= n; i++) {
            int x = scanner.nextInt();
            par[i] = x;
            edge[i].add(x);
            edge[x].add(i);
        }
        for (int i = 1; i <= n; ++i) {
            sum[i] = scanner.nextLong();
        }
        a[1] = sum[1];
        par[1] = -1;
        dfs(1, -1);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            // printf("%d %lld\n", a[i], sum[i]);
            if (a[i] < 0) {
                System.out.println(-1);
                return;
            }
            ans += a[i];
        }
        System.out.println(ans);




    }
}
