package codeforces._1080;

import java.util.Scanner;

public class B {

    public static int sum(int a) {
        if (a % 2 == 0) {
            return a / 2;
        } else {
            return a / 2 - a;
        }

    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {

            int l = scanner.nextInt();
            int r = scanner.nextInt();

            System.out.println(sum(r) - sum(l - 1));


        }




    }
}
