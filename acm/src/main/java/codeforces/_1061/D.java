package codeforces._1061;

import java.util.*;

public class D {
    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        long y = scanner.nextLong();

        long sum = 0;
        TreeMap<Long, Collection<Long>> treeMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            //treeMap.put(scanner.nextLong(), scanner.nextLong());
            if (treeMap.containsKey(a)) {
                treeMap.get(a).add(b);
            } else {
                treeMap.put(a, new ArrayList<>());
                treeMap.get(a).add(b);
            }
        }
        for (Long a: treeMap.keySet()) {
            Collection<Long> arrayList = treeMap.get(a);
            Collections.sort((ArrayList<Long>)arrayList);
            Collections.reverse((ArrayList<Long>)arrayList);
            treeMap.put(a, new ArrayDeque<>(arrayList));
        }


        while (treeMap.size() > 0) {
            sum += x;
            sum %= 1000000007;
            Long a = treeMap.firstKey();
            Long b;
            //Long b = treeMap.remove(a);
            Collection<Long> aaa = treeMap.get(a);
            if (aaa.size() > 1) {
                b = ((ArrayDeque<Long>)aaa).poll();
            } else {
                b = ((ArrayDeque<Long>)aaa).poll();
                treeMap.remove(a);
            }
            //System.out.println(a);
            for (;;) {
                Long aa = treeMap.higherKey(b);
                //System.out.println("\t" + aa);
                if (aa == null) {
                    sum += y * (b - a);
                    sum %= 1000000007;
                    break;
                }
                if (x <= (aa - b) * y) {
                    sum += y * (b - a);
                    sum %= 1000000007;
                    break;
                }

                Long bb;
                Collection<Long> bbb = treeMap.get(aa);
                if (bbb.size() > 1) {
                    bb = ((ArrayDeque<Long>)bbb).poll();
                } else {
                    bb = ((ArrayDeque<Long>)bbb).poll();
                    treeMap.remove(aa);
                }

                /*if (x <= (aa - b) * y) {
                    sum += y * (b - a);
                    sum %= 1000000007;
                    break;
                    //sum += x;
                    //sum %= 1000000007;
                    //a = aa;
                    //b = bb;
                } else {
                    b = bb;
                }*/
                b = bb;
            }
        }
        System.out.println(sum % 1000000007);




    }
}
