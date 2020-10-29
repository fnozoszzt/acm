package codeforces._1082;

import java.util.Scanner;

public class E {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] a = new int[500005];

        int m = 0;


        int[] min = new int[500005];
        int[] sum = new int[500005];
        int[] max = new int[500005];
        int[] last = new int[500005];
        int[] ans = new int[500005];
        int[] flag1 = new int[500005];
        int[] flag2 = new int[500005];

        int _ = 0;


        //前i项有多少c
        int[] sumc = new int[500005];

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] != c) {
                sumc[i] = sumc[i - 1];
            } else {
                sumc[i] = sumc[i - 1] + 1;
                //System.out.println(sumc[i]);
            }
        }
        _ = sumc[n];
        for (int i = 1; i <= n; i++) {
            m = Math.max(m, a[i]);
//            System.out.println("-- " + a[i]);
            if (a[i] != c) {



                int ll = last[a[i]];
                sum[a[i]] = sum[a[i]] - (sumc[i] - sumc[ll]);
                //max[a[i]] = Math.max()
//                System.out.println(sum[a[i]]);
                max[a[i]] = Math.max(max[a[i]], (sum[a[i]] - min[a[i]]));

//                System.out.println(max[a[i]]);
//                System.out.println("==" + flag1[a[i]] + " " + sumc[flag1[a[i]]] + " " + (sumc[n] - sumc[i]));
//                ans[a[i]] = Math.max(ans[a[i]], max[a[i]] + sumc[flag1[a[i]]] + sumc[n] - sumc[i]);
                ans[a[i]] = Math.max(ans[a[i]], max[a[i]] + sumc[n]);
//                System.out.println(ans[a[i]]);
                _ = Math.max(ans[a[i]], _);
                //min[a[i]] = Math.min(min[a[i]], sum[a[i]]);

                if (sum[a[i]] < min[a[i]]) {
                    min[a[i]] = sum[a[i]];
                    flag1[a[i]] = i;
                }
//                System.out.println(min[a[i]]);
//                System.out.println(flag1[a[i]]);




                ll = last[a[i]];
                last[a[i]] = i;

                //System.out.println(last[a[i]]);
                //System.out.println(sumc[i] - sumc[ll]);
                //System.out.println(sumc[i]);
                sum[a[i]] = sum[a[i]] + 1;
                //max[a[i]] = Math.max()
//                System.out.println(sum[a[i]]);
                max[a[i]] = Math.max(max[a[i]], (sum[a[i]] - min[a[i]]));

//                System.out.println(max[a[i]]);

//                System.out.println("==" + flag1[a[i]] + " " + sumc[flag1[a[i]]] + " " + (sumc[n] - sumc[i]));
                //ans[a[i]] = Math.max(ans[a[i]], max[a[i]] + sumc[flag1[a[i]]] + sumc[n] - sumc[i]);
                ans[a[i]] = Math.max(ans[a[i]], max[a[i]] + sumc[n]);
//                System.out.println(ans[a[i]]);
                _ = Math.max(ans[a[i]], _);
                //min[a[i]] = Math.min(min[a[i]], sum[a[i]]);
                if (sum[a[i]] < min[a[i]]) {
                    min[a[i]] = sum[a[i]];
                    flag1[a[i]] = i;
                }
//                System.out.println(min[a[i]]);
//                System.out.println(flag1[a[i]]);
            }
        }

        for (int i = 0; i <= m; i++) {
            sum[i] = sum[i] - (sumc[n] - sumc[last[i]]);
            max[i] = Math.max(max[i], sum[i] - min[i]);
            min[i] = Math.min(min[i], sum[i]);
        }


//        for (int i = 0; i <= 6; i++) {
//            System.out.print(last[i] + " ");
//        }
//        System.out.println();
//
//        for (int i = 0; i <= 6; i++) {
//            System.out.print(sum[i] + " ");
//        }
//        System.out.println();
//
//        for (int i = 0; i <= 6; i++) {
//            System.out.print(max[i] + " ");
//        }
//        System.out.println();
//
//        for (int i = 0; i <= 6; i++) {
//            System.out.print(min[i] + " ");
//        }
//        System.out.println();

        System.out.println(_);




    }
}
