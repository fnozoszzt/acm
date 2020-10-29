package codeforces._1092;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    static class node implements Comparable<node>{
        String string;
        int len;
        int idx;
        boolean flag;
        @Override
        public int compareTo(node o) {
            return Integer.compare(o.len, len);
        }

        @Override
        public String toString() {
            return string + " " + len + " " + idx + " " + flag;
        }
    }
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        node[] nodes = new node[1000];
        for (int i = 0; i < (n + n - 2); i++) {
            nodes[i] = new node();
            nodes[i].string = scanner.next();
            nodes[i].len = nodes[i].string.length();
            nodes[i].idx = i;
        }
        Arrays.sort(nodes, 0, n + n - 2);
        if (nodes[0].string.substring(0, n - 2).equals(nodes[1].string.substring(1, n - 1))) {
            String ans = nodes[1].string.substring(0, 1) + nodes[0].string;
//            System.out.println(ans);
            nodes[0].flag = false;
            nodes[1].flag = true;
//            System.out.println(nodes[0] + " " + nodes[1]);
            boolean u = true;
            for (int i = 2; i < n + n - 2; i += 2) {
                if (ans.startsWith(nodes[i].string) && ans.endsWith(nodes[i + 1].string)) {
                    nodes[i].flag = true;
                    nodes[i + 1].flag = false;
//                    System.out.println(nodes[i] + " " + nodes[i + 1]);
                }
                else if (ans.startsWith(nodes[i + 1].string) && ans.endsWith(nodes[i].string)) {
                    nodes[i].flag = false;
                    nodes[i + 1].flag = true;
//                    System.out.println(nodes[i] + " " + nodes[i + 1]);
                } else {
//                    System.out.println(false);
                    u = false;
                }
            }
            if (u) {
                boolean[] aa = new boolean[1000];
                for (int i = 0; i < n + n - 2; i++) {
                    aa[nodes[i].idx] = nodes[i].flag;
                }
                for (int i = 0; i < n + n - 2; i++) {
                    if (aa[i]) {
                        System.out.print('P');
                    } else {
                        System.out.print('S');
                    }
                }
                System.out.println();
                return;
            }
        }
        {
            String ans = nodes[0].string.substring(0, 1) + nodes[1].string;
            nodes[1].flag = false;
            nodes[0].flag = true;
            boolean u = true;
            for (int i = 2; i < n + n - 2; i += 2) {
                if (ans.startsWith(nodes[i].string) && ans.endsWith(nodes[i + 1].string)) {
                    nodes[i].flag = true;
                    nodes[i + 1].flag = false;
                }
                else if (ans.startsWith(nodes[i + 1].string) && ans.endsWith(nodes[i].string)) {
                    nodes[i].flag = false;
                    nodes[i + 1].flag = true;
                } else {
                    u = false;
                }
            }
            if (u) {
                boolean[] aa = new boolean[1000];
                for (int i = 0; i < n + n - 2; i++) {
                    aa[nodes[i].idx] = nodes[i].flag;
                }
                for (int i = 0; i < n + n - 2; i++) {
                    if (aa[i]) {
                        System.out.print('P');
                    } else {
                        System.out.print('S');
                    }
                }
                System.out.println();
            }
        }




    }
}
