package atcoder.dp;

import java.util.Scanner;

public class Z {

    static int get(long[][] x, long f, int num) {

//        System.out.println("get");

        int l = 0;
        int r = num;

        while (r - l > 1) {
            int mid = (l + r) / 2;

            //System.out.println("mid ====  " + mid);

            if (x[mid][0] <= x[mid][1] * f)
                l = mid;
            else
                r = mid;

        }

        if (l < num - 1)
            if (x[l][0] <= x[l][1] * f)
                return l + 1;


        return l;
    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long c = scanner.nextLong();
        long[] dp = new long[200005];
        long[] a = new long[200005];

        int[] l = new int[200005];
        long[][] x = new long[200005][2];

        int num = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();


            if (i == 0) {
                dp[0] = 0;
                l[0] = 0;
                num++;
            } else {
//                if (num < 2) {
//                    int head = l[num - 1];
//
//                    dp[i] = dp[head] + (a[i] - a[head]) * (a[i] - a[head]) + c;
//
//
//                    l[num] = i;
//                    num++;
//
//                } else {


                x[num - 1][0] = 10000000000000L;
                x[num - 1][1] = 1;
                int p = get(x, a[i] * 2, num);
                int head = l[p];

                dp[i] = dp[head] + (a[i] - a[head]) * (a[i] - a[head]) + c;
//                System.out.println("dp " + i + " " + p + " " + dp[i]);




                while (num > 1) {
                    int q = l[num - 1];
                    long qq = dp[i] + a[i] * a[i] - dp[q] - a[q] * a[q];
                    long ww = a[i] - a[q];

                    long qqq = x[num - 2][0];
                    long www = x[num - 2][1];

                    if (qqq * ww > qq * www) {
                        num--;
//                        System.out.println("delete ");
//                        for (int j = 0; j < num; j++) {
//                            System.out.print(l[j] + " ");
//                        }
//                        System.out.println();
                    } else {
                        break;
                    }
                }

                l[num] = i;
                head = l[num - 1];
                long qq = dp[i] + a[i] * a[i] - dp[head] - a[head] * a[head];
                long ww = a[i] - a[head];
                x[num - 1][0] = qq;
                x[num - 1][1] = ww;

                num++;
//                System.out.println("add ");
//                for (int j = 0; j < num; j++) {
//                    System.out.print(l[j] + " ");
//                }
//                System.out.println();
//                for (int j = 0; j < num; j++) {
//                    System.out.print(x[j][0] + " ");
//                }
//                System.out.println();
//                for (int j = 0; j < num; j++) {
//                    System.out.print(x[j][1] + " ");
//                }
//                System.out.println();



            }

        }
        System.out.println(dp[n - 1]);


    }
}
