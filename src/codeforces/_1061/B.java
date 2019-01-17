package codeforces._1061;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long m = scanner.nextInt();

        long sum = 0;
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            arrayList.add(a);
            sum += a;
        }


        Collections.sort(arrayList);
        Collections.reverse(arrayList);

        long last = 0;
        long ans = 0;
        for (long i: arrayList) {
            if (last == 0) {
                last = i;
                ans++;
            } else {
                if (last == 1) {
                    ans++;
                } else if (i >= last - 1) {
                    last--;
                    ans++;
                } else {
                    ans += (last - i);
                    last = i;
                }
            }
        }
        if (last > 1) {
            ans += (last - 1);
        }
        System.out.println(sum - ans);



    }
}
