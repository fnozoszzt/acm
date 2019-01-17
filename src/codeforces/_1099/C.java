package codeforces._1099;

import java.util.Scanner;

public class C {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();
        int n = scanner.nextInt();


        int l = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] >= 'a' && s[i] <= 'z') {
                l++;
            }
            if (s[i] == '?') {
                a++;
            }
            if (s[i] == '*') {
                b++;
            }
        }
//        System.out.println(l);

        if (l == n) {
            for (int i = 0; i < s.length; i++) {
                if (s[i] >= 'a' && s[i] <= 'z') {
                    System.out.print(s[i]);
                }
            }
            System.out.println();
        }

        if (l < n) {
            boolean aa = true;
            if (b > 0) {
                for (int i = 0; i < s.length; i++) {
                    if (s[i] >= 'a' && s[i] <= 'z') {
                        System.out.print(s[i]);
                    }
                    if (s[i] == '*') {
                        if (aa) {
                            for (int j = 0; j < n - l; j++) {
                                System.out.print(s[i - 1]);
                            }
                        }
                        aa = false;
                    }
                }
                System.out.println();
            } else {
                System.out.println("Impossible");
            }
        }

        if (l > n) {
            int j = 0;
            if (b + a >= l - n) {
                for (int i = 0; i < s.length; i++) {
                    if (s[i] >= 'a' && s[i] <= 'z') {
                        if (i + 1 < s.length) {
                            if (s[i + 1] == '?' || s[i + 1] == '*') {
                                if (j < l - n) {

                                    j++;
                                } else {
                                    System.out.print(s[i]);
                                }
                            } else {
                                System.out.print(s[i]);
                            }
                        } else {
                            System.out.print(s[i]);
                        }

                    }
                }
                System.out.println();
            } else {
                System.out.println("Impossible");
            }
        }






    }
}
