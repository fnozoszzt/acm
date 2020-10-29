package codeforces._1084;

import java.util.Scanner;

public class E {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long k = scanner.nextLong();
        String s = scanner.next();
        String t = scanner.next();


        int a = 0;
        long b = 0;
        int c = 0;
        long res = 0;
        boolean same = true;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(i) && same) {
            } else {
                if (same) {
                    same = false;
                    //a = 1;
                    //c = 1;
                } else {
                    b = b * 2;
                    if (s.charAt(i) == 'a') {
                        b += 1;
                    } else {
                        b += 0;
                    }
                    if (t.charAt(i) == 'a') {
                        b += 0;
                    } else {
                        b += 1;
                    }
                }

            }

            if (same) {
                res += 1;
            } else {
                if (b + 2 >= k) {
                    res += k;
                } else {
                    res += b + 2;
                }
            }

            if (b + 2 >= k) {
                b = k;
            }
//            System.out.println("-");
//            System.out.println(a);
//            System.out.println(b);
//            System.out.println(c);
//            System.out.println(res);

        }
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
        System.out.println(res);




    }
}
