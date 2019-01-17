package codeforces._1092;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(scanner.nextInt());
        }
        Collections.sort(arrayList);
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            int a = arrayList.get(i);
            int b = arrayList.get(i + 1);
            ans += (b - a);
        }
        System.out.println(ans);

    }
}
