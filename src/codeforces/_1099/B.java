package codeforces._1099;

import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);


        long n = scanner.nextInt();


        long sum = 2000000000;
        for (long i = 1; i * i <= n; i++) {
//            if (n % i == 0) {
            long b = 0;
            if (n % i == 0) {
                b = n / i;
            } else {
                b = n / i + 1;
            }
                if (i + b < sum) {
                    sum = i + b;
                }

//            }
        }
        System.out.println(sum);





    }
}
