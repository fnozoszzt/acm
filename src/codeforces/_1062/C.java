package codeforces._1062;

import java.util.Scanner;

public class C {

    static long m(int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            long t = m(n / 2);
            return 2 * t * t % 1000000007;
        } else {
            long t = m(n / 2);
            return t * t % 1000000007;
        }
    }

    static long work(int sum) {
        return m(sum) - 1;
    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        byte[] a = scanner.next().getBytes();

        //int[] data = new int[100005];
        int[] tree = new int[100005];


        for (int i = 0; i < a.length; i++) {
            if (a[i] == '1') {
                //data[i + 1] = i;
                int j = i + 1;

                while (j <= n) {
                    tree[j]++;
                    j += (j & (-j));
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            //for (int iii = 0; iii < 100000; iii++) {
                int j = r;
                int sum = 0;
                while (j > 0) {
                    sum += tree[j];
                    j -= (j & (-j));
                }

                j = l - 1;
                while (j > 0) {
                    sum -= tree[j];
                    j -= (j & (-j));
                }

                //System.out.println(sum);

                long ans = 0;
                int len = (r - l + 1);
                //ans += (sum * (sum + 1)) / 2;
                long tmp = work(sum);

                ans += tmp;
                ans += tmp * work(len - sum);
                //System.out.println(ans % 1000000007);
            stringBuilder.append(ans % 1000000007);
            stringBuilder.append("\n");
            //}


        }
        System.out.println(stringBuilder.toString());





    }
}
