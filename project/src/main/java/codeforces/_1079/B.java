package codeforces._1079;

import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();

        int len = a.length();
        //System.out.println(len);
        if (len <= 20) {
            System.out.println(1 + " " + len);
            System.out.println(a);
            return;
        }
        /*else if (len <= 40) {

        }*/

        for (int c = 2; c <= 5; c++) {
            if (len / c <= 20) {
                if (len % c == 0) {
                    System.out.println(c+ " " + len / c);
                    for (int i = 0; i < len; i += len / c) {
                        System.out.println(a.substring(i, i + (len / c)));
                    }
                } else {
                    int remain = c - (len % c);
                    //System.out.println(remain);

                    System.out.println(c+ " " + (len / c + 1));
                    int newlen = len + remain;
                    for (int i = 0; i < newlen; i += newlen / c) {
                        int cc = (i / (newlen / c));
                        //System.out.println(cc);

                        if (cc < remain) {
                            System.out.println(a.substring(i - cc, i - cc + cc) + "*" + a.substring(i, i + newlen / c - cc - 1));
                        } else {
                            System.out.println(a.substring(i - remain, i + newlen / c - remain));
                        }
                    }


                }
                break;
            }
        }




    }
}
