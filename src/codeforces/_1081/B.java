package codeforces._1081;

import java.util.ArrayList;
import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[100005];
        ArrayList<Integer>[] aa = new ArrayList[100005];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            aa[i + 1] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            aa[n - a[i]].add(i);
        }
        boolean ans = true;
        for (int i = 1; i <= n; i++) {
            //System.out.println(aa[i]);
            if (aa[i].size() > 0) {
                if (aa[i].size() % i != 0) {
                    ans = false;
                }
            }
        }
        if (ans) {
            System.out.println("Possible");
            int[] res = new int[100005];
            int next = 0;
            for (int i = 1; i <= n; i++) {
                if (aa[i].size() > 0) {
                    /*for (int ii: aa[i]) {
                        res[ii] = i;
                    }*/
                    for (int j = 0; j < aa[i].size(); j++) {
                        if (j % i == 0) {
                            next++;
                        }
                        res[aa[i].get(j)] = next;

                    }

                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                //System.out.print(res[i] + " ");
                stringBuilder.append(res[i]);
                stringBuilder.append(' ');
            }
            System.out.println(stringBuilder);
        } else {
            System.out.println("Impossible");
        }




    }
}
