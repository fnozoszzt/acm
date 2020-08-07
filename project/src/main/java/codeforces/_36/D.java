package codeforces._36;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class D {


    public static void main(String[] aaaa) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        PrintStream out = System.out;
        Scanner scanner = new Scanner(new File("input.txt"));
        PrintStream out = new PrintStream(new FileOutputStream(new File("output.txt")));



        int t = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            if (n < m) {
                n ^= m;
                m ^= n;
                n ^= m;
            }

            if (k == 1) {
                int a = m % (k + 1);
                if (a == 0) {
                    out.println("+");
                } else {
                    if ((n - m) % 2 == 0) {
                        out.println("-");
                    } else {
                        out.println("+");
                    }
                }

                continue;
            }

            int a = (m % (k * 2 + 2));
            if (a == 0 || a == k + 1) {
                out.println("+");
            } else {
                if (a <= k) {
                    if ((n - m) % 2 == 0) {
                        out.println("-");
                    } else {
                        out.println("+");
                    }
                } else {
                    if ((n - m) % 2 == 0) {
                        out.println("+");
                    } else {
                        out.println("-");
                    }
                }
            }



        }

    }
}
