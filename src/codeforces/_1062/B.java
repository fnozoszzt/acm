package codeforces._1062;

import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);

        int[] prime = new int[1000005];

        for (int i = 2; i * i < prime.length; i++) {
            for (int j = i; j * i < prime.length; j++) {
                prime[j * i] = 1;
            }
        }


        int _ = scanner.nextInt();
        int input = _;
        int[] a = new int[1000005];


        int ans1 = 1;
        int ans2 = 0;
        int ans3 = 1;
        for (int i = 2; i <= input; i++) {
            while (_ % i == 0) {
                a[i]++;
                _ /= i;
            }

            if (a[i] > 0) {
                ans1 *= i;


                int aa = 1;
                int bb = 0;
                while (aa < a[i]) {
                    aa *= 2;
                    bb++;
                }
                if (ans2 < bb) {
                    ans2 = bb;
                    ans3 = aa;
                }
            }


        }
        //System.out.println(ans1);
        //System.out.println(ans2);
        //System.out.println(ans3);

        boolean aaa = true;
        for (int i = 2; i <= input; i++) {
            if (a[i] > 0) {
                if (ans3 != a[i]) {
                    aaa = false;
                }
            }
        }
        //System.out.println(aaa);

        if (! aaa)
System.out.println(ans1 + " " + (ans2 + 1));
    else
            System.out.println(ans1 + " " + ans2);

    }
}
