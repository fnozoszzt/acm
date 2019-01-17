package codeforces._1080;

import java.util.Scanner;

public class A {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int ans = 0;
        if (n * 2 % k == 0) {
            ans += n * 2 / k;
        } else {
            ans += n * 2 / k + 1;
        }

        if (n * 5 % k == 0) {
            ans += n * 5 / k;
        } else {
            ans += n * 5 / k + 1;
        }

        if (n * 8 % k == 0) {
            ans += n * 8 / k;
        } else {
            ans += n * 8 / k + 1;
        }



        System.out.println(ans);



    }
}
