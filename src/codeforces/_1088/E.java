package codeforces._1088;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class E {
    static class node {
        public long w;
        public ArrayList<Integer> children = new ArrayList<>();

        public int left = -1;
        public int right = -1;

        public long sum;
        public int num;
        public long max;

        public long tmp;
        public boolean use;
        public boolean visit = false;
    }
    static node[] nodes;

    static void work1(int c) {
        nodes[c].visit = true;
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i: nodes[c].children) {
            if (! nodes[i].visit) {
                work1(i);
                if (max < nodes[i].max) {
                    max = nodes[i].max;
                }
                if (nodes[i].tmp > 0) {
                    sum += nodes[i].tmp;
                }
            }
        }
        sum += nodes[c].w;
        //System.out.println(max);
        //System.out.println(sum);
        if (sum >= max) {
            nodes[c].tmp = sum;
            nodes[c].max = sum;
            //nodes[c].use = true;
        } else {
            nodes[c].tmp = sum;
            nodes[c].max = max;
            //nodes[c].use = false;
        }
        //System.out.println("c " + c + " " + nodes[c].tmp + " " + nodes[c].max);
    }

    static void work2(int c) {
        nodes[c].visit = false;
        long max = Long.MIN_VALUE;
        long sum = 0;
        int num = 0;
        for (int i: nodes[c].children) {
            if (nodes[i].visit) {
                work2(i);

                num += nodes[i].num;

                if (nodes[i].tmp > 0) {
                    sum += nodes[i].tmp;
                }
            }
        }
        sum += nodes[c].w;
        if (sum == nodes[1].max) {
            num++;
            sum = 0;
        }
        nodes[c].tmp = sum;
        //System.out.println(max);
        //System.out.println(sum);
        nodes[c].num = num;
        //System.out.println("c " + c + " " + nodes[c].num);
    }

    public static void main(String[] aaaa) throws Exception {
        //Scanner scanner = new Scanner(System.in);
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        nodes = new node[300005];
        //int n = scanner.nextInt();
        in.nextToken();
        int n = (int) in.nval;
        for (int i = 1; i <= n; i++) {
            nodes[i] = new node();
            in.nextToken();
            nodes[i].w = (int) in.nval;//scanner.nextLong();
        }

        //PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        /*StreamTokenizer.TT_EOF这是个参数，就是指文件尾，EOF*/
        /*while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int a = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            in.nextToken();
            int c = (int) in.nval;
            in.nextToken();
            double d = in.nval;
            in.nextToken();
            String str = in.sval;
            in.nextToken();

        }*/
        for (int i = 1; i < n; i++) {
            in.nextToken();
            //int a = scanner.nextInt();
            int a = (int) in.nval;
            in.nextToken();
            //int b = scanner.nextInt();
            int b = (int) in.nval;
            nodes[a].children.add(b);
            nodes[b].children.add(a);

            /*if (nodes[a].left == -1) {
                nodes[a].left = b;
            } else {
                nodes[nodes[a].left].left = nodes[a].left;
                nodes[a].left = b;
            }*/

        }
        work1(1);
        //System.out.println(nodes[1].max);
        //System.out.println(nodes[1].tmp);

        if (nodes[1].max <= 0) {
            int num = 0;
            for (int i = 1; i <= n; i++) {
                if (nodes[i].w == nodes[1].max) {
                    num ++;
                }
            }
            System.out.println(nodes[1].max * num + " " + num);
            return;
        }
        work2(1);
        System.out.println(nodes[1].max * nodes[1].num + " " + nodes[1].num);








    }
}
