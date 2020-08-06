package codeforces._1085;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class D {


    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double s = scanner.nextDouble();
        ArrayList<Integer>[] arrayLists = new ArrayList[100005];
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (arrayLists[i].size() == 1) {
                sum++;
            }
        }
        System.out.println(s / sum * 2);




        }
}
