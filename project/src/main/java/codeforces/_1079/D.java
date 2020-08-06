package codeforces._1079;

import java.util.Scanner;

public class D {
    static double d(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();

        double x1 = scanner.nextInt();
        double y1 = scanner.nextInt();
        double x2 = scanner.nextInt();
        double y2 = scanner.nextInt();

        if (a == 0 || b == 0) {
            System.out.println(Math.abs(x1 - x2) + Math.abs(y1 - y2));
        } else {
            double p1x1 = x1;
            double p1y1 = (0 - c - a * x1) * 1.0 / b;
            double p1y2 = y1;
            double p1x2 = (0 - c - b * y1) * 1.0 / a;

            double p2x1 = x2;
            double p2y1 = (0 - c - a * x2) * 1.0 / b;
            double p2y2 = y2;
            double p2x2 = (0 - c - b * y2) * 1.0 / a;
            //System.out.println(p1x1 + " " + p1y1);
            //System.out.println(p1x2 + " " + p1y2);
            //System.out.println(p2x1 + " " + p2y1);
            //System.out.println(p2x2 + " " + p2y2);

            double ans = Math.abs(x1 - x2) + Math.abs(y1 - y2);

            //ans = Math.min(ans, Math.abs(p1y1 - y1) +  Math.abs(p2y1 - y2) + Math.sqrt((p1x1 - p2x1) * (p1x1 - p2x1) + (p1y1 - p2y1) * (p1y1 - p2y1)));
            //ans = Math.min(ans, Math.abs(p2y1 - y1) +  Math.abs(p2y1 - y2) + Math.sqrt((p1x1 - p2x1) * (p1x1 - p2x1) + (p1y1 - p2y1) * (p1y1 - p2y1)));
            //ans = Math.min(ans, Math.abs(p1y1 - y1) +  Math.abs(p2y1 - y2) + Math.sqrt((p1x1 - p2x1) * (p1x1 - p2x1) + (p1y1 - p2y1) * (p1y1 - p2y1)));
            //ans = Math.min(ans, Math.abs(p1y1 - y1) +  Math.abs(p2y1 - y2) + Math.sqrt((p1x1 - p2x1) * (p1x1 - p2x1) + (p1y1 - p2y1) * (p1y1 - p2y1)));

            ans = Math.min(ans, d(x1, y1, p1x1, p1y1) + d(p1x1, p1y1, p2x1, p2y1) + d(p2x1, p2y1, x2, y2));
            //System.out.println(ans);
            ans = Math.min(ans, d(x1, y1, p1x2, p1y2) + d(p1x2, p1y2, p2x1, p2y1) + d(p2x1, p2y1, x2, y2));
            //System.out.println(ans);
            ans = Math.min(ans, d(x1, y1, p1x1, p1y1) + d(p1x1, p1y1, p2x2, p2y2) + d(p2x2, p2y2, x2, y2));
            //System.out.println(ans);
            ans = Math.min(ans, d(x1, y1, p1x2, p1y2) + d(p1x2, p1y2, p2x2, p2y2) + d(p2x2, p2y2, x2, y2));
            //System.out.println(ans);

            System.out.println(ans);
        }



    }
}
