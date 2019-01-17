package codeforces._1081;

import java.util.Scanner;

public class F {


    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        int t = scanner.nextInt();

        int res[] = new int[305];
        int c[] = new int[305];

        for (int i = 1; i <= n / 2; i++) {
//            System.out.println("i " + i);
            while (true) {
                System.out.println("? " + (i + 1) + " " + (n - i + 1));
                int a = scanner.nextInt();
                System.out.println("? " + (i + 1) + " " + (n - i + 1));
                int b = scanner.nextInt();
                if ((t - b) % 2 != 0) {
                    int cur_1 = 0;
                    for (int j = 1; j <= i - 1; j++) {
                        if (c[j] == 1) {
                            cur_1++;
                        }
                        c[j] = 1 - c[j];
//                        System.out.println("change " + j);

                    }
                    for (int j = n - i + 2; j <= n; j++) {
                        if (c[j] == 1) {
                            cur_1++;
                        }
                        c[j] = 1 - c[j];
//                        System.out.println("change " + j);

                    }
//                    System.out.println("cur_1 " + cur_1);
//                    System.out.println("b " + b + " " + (t - cur_1 * 2 - 2 + i * 2 - 1));
//                    for (int k = 1; k <= n; k++) {
//                        System.out.print(c[k]);
//                    }
//                    System.out.println();
                    if (b == t - cur_1 * 2 - 2 + i * 2 - 1) {
                        res[i] = 1;
//                        System.out.println("res " + i + " " + res[i]);
                        c[i] = 0;
                        t = b;
//                        System.out.println(i + " " + c[i]);
                        break;
                    }
                    if (b == t - cur_1 * 2 - 2 + i * 2 + 1) {
                        res[i] = 0;
//                        System.out.println("res " + i + " " + res[i]);
                        c[i] = 1;
                        t = b;
//                        System.out.println(i + " " + c[i]);
                        break;
                    }
                }
            }

            while (true) {
                System.out.println("? " + (i) + " " + (n - i));
                int a = scanner.nextInt();
                System.out.println("? " + (i) + " " + (n - i));
                int b = scanner.nextInt();
                if ((t - b) % 2 != 0) {
                    int cur_1 = 0;
                    for (int j = 1; j <= i - 1; j++) {
                        if (c[j] == 1) {
                            cur_1++;
                        }
                        c[j] = 1 - c[j];
//                        System.out.println("change " + j);
                    }
                    for (int j = n - i + 2; j <= n; j++) {
                        if (c[j] == 1) {
                            cur_1++;
                        }
                        c[j] = 1 - c[j];
//                        System.out.println("change " + j);
                    }
//                    System.out.println("cur_1 " + cur_1);
//                    System.out.println("b " + b + " " + (t - cur_1 * 2 - 2 + i * 2 - 1));
//                    for (int k = 1; k <= n; k++) {
//                        System.out.print(c[k]);
//                    }
//                    System.out.println();
                    if (b == t - cur_1 * 2 - 2 + i * 2 - 1) {
                        res[n - i + 1] = 1;
//                        System.out.println("res " + (n - i + 1) + " " + res[n - i + 1]);
                        c[n - i + 1] = 0;
                        t = b;
//                        System.out.println(i + " " + c[n - i + 1]);
                        break;
                    }
                    if (b == t - cur_1 * 2 - 2 + i * 2 + 1) {
                        res[n - i + 1] = 0;
//                        System.out.println("res " + (n - i + 1) + " " + res[n - i + 1]);
                        c[n - i + 1] = 1;
                        t = b;
//                        System.out.println(i + " " + c[n - i + 1]);
                        break;
                    }
                }
            }

        }
        int d = 0;
        for (int i = 1; i <=n ; i++) {
            d += c[i];
        }
        if (n % 2 == 1) {
            if (d == t) {
                res[n / 2 + 1] = 0;
            } else {
                res[n / 2 + 1] = 1;

            }
        }
        System.out.print("! ");
        for (int i = 1; i <=n ; i++) {
            System.out.print(res[i]);
        }
        System.out.println();



    }
}
