package codeforces._1088;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();


        int[] a = new int[100005];
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            arrayList.add(a[i]);
        }
        Collections.sort(arrayList);
        arrayList2.add(0);
        int last = 0;
        for (int i: arrayList) {
            if (i != last) {
                arrayList2.add(i);
                last = i;
            }
        }

        for (int i = 0; i < k; i++) {
            if (i + 1>= arrayList2.size()) {
                System.out.println(0);
            } else {
                System.out.println(arrayList2.get(i + 1) - arrayList2.get(i));
            }
        }





    }
}
