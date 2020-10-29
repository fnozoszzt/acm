package codeforces._1062;

import java.util.Scanner;

public class D_plus {
    public static void main(String[] aaaa) {
        int[] set = new int[1005];

        for (int i = 0; i < set.length; i++) {
            set[i] = i;
        }

        Scanner scanner = new Scanner(System.in);
        int _ = scanner.nextInt();

        long ans = 0;
        for (int i = 2; i <= _; i ++) {
            for (int j = 2; j * i <= _; j++) {
                for (int k = i; k <= _; k *= j) {
                    System.out.print(k + " ");
                    ans += j;
                }
                ans -= j;
                System.out.println();
            }
        }

        System.out.println(ans * 4);


    }
}
