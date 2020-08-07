package codeforces._1105;

import java.util.HashMap;
import java.util.Scanner;

public class E {
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static int getId(String s) {
        if (hashMap.containsKey(s)) {
            return hashMap.get(s);
        } else {
            int size = hashMap.size();
            hashMap.put(s, size);
            return size;
        }
    }
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] use = new int[100];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (a == 1) {
//                for (int j = 0; j < m; j++) {
//                    for (int k = 0; k < m; k++) {
//                        if (dp[i])
//                    }
//                }

                use = new int[100];
            } else {
                int id = getId(scanner.next());
                use[id] = 1;
            }

        }




    }
}
