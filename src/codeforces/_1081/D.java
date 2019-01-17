package codeforces._1081;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class D {
    static class Node implements Comparable<Node> {
        int u, v, w;

        @Override
        public int compareTo(Node o) {
            return Integer.compare(w, o.w);
        }
    }
    static int maxn = 110100;
    static int need[] = new int[maxn];
    static int par[] = new int[maxn];
    static int sum[] = new int[maxn];
    static int n, m, k;
    static boolean flag = false;
    static int find(int u) {
        if (u == par[u]) {
            return u;
        }
        par[u] = find(par[u]);
        return par[u];
    }

    static void merge(int u, int v) {
        int fu = find(u);
        int fv = find(v);
        if (fu == fv) {
            return ;
        } else {
            par[fu] = fv;
            sum[fv] += sum[fu];
            if (sum[fv] == k) {
                flag = true;
            }
        }
    }


    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);











            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();
        Node node[] = new Node[maxn];
        for (int i = 0; i < maxn; i++) {
            node[i] = new Node();
        }

            for (int i = 1; i <= k; ++i) {
                int x = scanner.nextInt();
                need[x] = 1;
                sum[x] = 1;
            }

            for (int i = 1; i <= n; ++i) {
                par[i] = i;
            }

            for (int i = 1; i <= m; ++i) {
                node[i].u = scanner.nextInt();
                node[i].v = scanner.nextInt();
                node[i].w = scanner.nextInt();

            }
        Arrays.sort(node, 1, m + 1);
            //sort(node + 1, node + m + 1, cmp);

            for (int i = 1; i <= m; ++i) {
                merge(node[i].u, node[i].v);
                if (flag) {
                    for (int j = 1; j <= k; ++j) {
                        System.out.print(node[i].w + " ");
                    }
                    System.out.println();
                    return;
                }
            }


    }
}
