package codeforces._1104;

import java.util.Scanner;

public class D {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String control = scanner.next();
            if (control.equals("start")) {
                System.out.println("? 0 1");
                String a = scanner.next();
                if (a.equals("x")) {
                    System.out.println("! 1");
                    continue;
                }

                int i = 0;
                while (true) {
                    System.out.println("? " + (1 << i) + " " + (1 << (i + 1)));
                    a = scanner.next();
                    if (a.equals("x")) {
                        break;
                    } else {
                        i++;
                    }

                }
//                System.out.println(i + " " + (1 << i));
                int[] ans = new int[100];
                ans[i] = 1;
                int top = (1 << (i + 1));
                int button = 1 << i;
                for (int j = i - 1; j >= 0; j--) {
                    System.out.println("? " + button + " " + (top + button) / 2);
                    a = scanner.next();
                    if (a.equals("x")) {
                        ans[j] = 0;
                        top = (top + button) / 2;
                    } else {
                        ans[j] = 1;
                        button = (top + button) / 2;
                    }
                }
//                System.out.println(top);
//                System.out.println(button);
//                System.out.println("? " + button + " " + (button + 1));
//                a = scanner.next();
//                if (a.equals("x")) {
//                    ans[0] = 1;
//                } else {
//                    ans[0] = 0;
//                }
                int out = 0;
                for (int j = 0; j <= i; j++) {
                    if (ans[j] == 1)
                    out += (1 << j);
                }
                System.out.println("! " + (out + 1));






            } else if(control.equals("end")) {
                return;
            } else if(control.equals("mistake")) {
                return;
            }

        }






    }
}
