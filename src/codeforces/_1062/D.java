package codeforces._1062;

import java.util.Scanner;

public class D {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);

        /*int[] prime = new int[1000005];

        for (int i = 2; i * i < prime.length; i++) {
            for (int j = i; j * i < prime.length; j++) {
                prime[j * i] = 1;
            }
        }
        */

        int _ = scanner.nextInt();
        long ans = 0;
        //base
        for (int i = 2; i < _; i++) {
            //start
            for (int j = 2; j * i <= _; j++) {
                //if (i % 2 == 0 || j % 2 == 0) {
                    //int tmp = i * ((int) (Math.log(_ / j) / Math.log(i) + 0.000001));
                    int tmp = i;

                    //System.out.println(i + " " + j);
                    //System.out.println(tmp);
                    ans += 4 * tmp;
                //}
            }
        }
        System.out.println(ans);
    }
}
