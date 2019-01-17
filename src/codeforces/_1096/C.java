package codeforces._1096;

import java.util.Scanner;

public class C {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int T = scanner.nextInt();

            if (T == 90) {
                System.out.println(4);
                continue;
            }

            if (T == 180) {
                System.out.println(-1);
                continue;
            }

            if (T < 90) {
                int ans = -1;
                for (int i = T; i > 0; i--) {
                    if (180 % i == 0 && T % i == 0) {
                        ans = (180 / i);
                        break;
                    }
                }
                System.out.println(ans);
            } else {
                T = 180 - T;
                int ans = -1;
                for (int i = T; i > 0; i--) {
                    if (180 % i == 0 && T % i == 0) {
                        if (T == i) {
                            ans = (180 / i) * 2;
                        } else {
                            ans = (180 / i);
                        }
                        break;
                    }
                }
                System.out.println(ans);
            }

        }


    }
}
