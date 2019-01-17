package codeforces._1080;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C {
    public static long getwhite(long x, long y) {
        if (x * y % 2 == 0) {
            return x * y / 2;
        } else {
            return x * y / 2 + 1;
        }
    }
    public static long getwhite(long x1, long y1, long x2, long y2) {
        return getwhite(x2, y2) + getwhite(x1, y1) - getwhite(x1, y2) - getwhite(x2, y1);

    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {

            long n = scanner.nextInt();
            long m = scanner.nextInt();

            long x1 = scanner.nextInt();
            long y1 = scanner.nextInt();
            long x2 = scanner.nextInt();
            long y2 = scanner.nextInt();
            long x3 = scanner.nextInt();
            long y3 = scanner.nextInt();
            long x4 = scanner.nextInt();
            long y4 = scanner.nextInt();


            long tmp;
            if (x1 > x2) {
                tmp = x1;
                x1 = x2;
                x2 = tmp;
            }

            if (y1 > y2) {
                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }

            if (x3 > x4) {
                tmp = x3;
                x3 = x4;
                x4 = tmp;
            }

            if (y3 > y4) {
                tmp = y3;
                y3 = y4;
                y4 = tmp;
            }

            //x2++;
            //y2++;
            //x4++;
            //y4++;
            x1--;
            x3--;
            y1--;
            y3--;

            ArrayList<Long> x = new ArrayList<>();
            x.add(x1);
            x.add(x2);
            x.add(x3);
            x.add(x4);
            Collections.sort(x);
            ArrayList<Long> y = new ArrayList<>();
            y.add(y1);
            y.add(y2);
            y.add(y3);
            y.add(y4);
            Collections.sort(y);

            long sum = n * m;
            long ans = getwhite(n, m);
            //System.out.println("ans " + ans);
            for (int j = 0; j < x.size() - 1; j++) {
                for (int k = 0; k < y.size() - 1; k++) {
                    long xb = x.get(j);
                    long xe = x.get(j + 1);
                    long yb = y.get(k);
                    long ye = y.get(k + 1);
                    //System.out.println("  == " + xb + " " + xe + " " + yb + " " + ye);

                    if (xb >= x1 && xe <= x2 && yb >= y1 && ye <= y2) {
                        if (! (xb >= x3 && xe <= x4 && yb >= y3 && ye <= y4)) {
                            //System.out.println("add " + ((xe - xb) * (ye - yb) - getwhite(xb, yb, xe, ye)));
                            ans += ((xe - xb) * (ye - yb) - getwhite(xb, yb, xe, ye));
                        }
                    }
                    if (xb >= x3 && xe <= x4 && yb >= y3 && ye <= y4) {
                        //System.out.println("de " + getwhite(xb, yb, xe, ye));
                        ans -= getwhite(xb, yb, xe, ye);
                    }


                }
            }
            System.out.println(ans + " " + (sum - ans));



        }




    }
}
