package codeforces._1060D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");

        Scanner scanner = new Scanner(System.in);

        ArrayList<Long> a1 = new ArrayList<>(100009);
        ArrayList<Long> a2 = new ArrayList<>(100009);
        int _ = scanner.nextInt();
        for (int i = 0; i < _; i++) {
            a1.add(scanner.nextLong());
            a2.add(scanner.nextLong());
        }
        Collections.sort(a1);
        Collections.sort(a2);
        //System.out.println(a1);
        long res = _;
        for (int i = 0; i < _; i++) {
            res += Math.max(a1.get(i), a2.get(i));
        }
        System.out.println(res);

    }
}
