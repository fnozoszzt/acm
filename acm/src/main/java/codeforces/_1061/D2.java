package codeforces._1061;

import java.util.*;

public class D2 {

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        long y = scanner.nextLong();

        TreeMap<Long, Collection<Long>> treeMap = new TreeMap<>();
        TreeMap<Long, ArrayDeque<Long>> treeMap2 = new TreeMap<>();

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
            //Collections.sort((ArrayList<Long>)arrayList);
            //Collections.reverse((ArrayList<Long>)arrayList);
            treeMap.put(a, new ArrayDeque<>(arrayList));
        }


        long sum = 0;
        for (Map.Entry<Long, Collection<Long>> entry: treeMap.entrySet()) {
            long a = entry.getKey();
            for (long b: entry.getValue()) {
                Long start;
                Long end = treeMap2.lowerKey(a);
                if (end == null) {
                    sum += x;
                    if (! treeMap2.containsKey(b)) {
                        treeMap2.put(b, new ArrayDeque<>());
                    }
                    treeMap2.get(b).add(a);
                } else {
                    ArrayDeque<Long> dq = treeMap2.get(end);
                    start = dq.poll();
                    if (dq.size() == 0) {
                        treeMap2.remove(end);
                    }
                    if (x <= (a - end) * y) {
                        sum += x;
                        sum += (end - start) * y;
                        sum %= 1000000007;
                        if (! treeMap2.containsKey(b)) {
                            treeMap2.put(b, new ArrayDeque<>());
                        }
                        treeMap2.get(b).add(a);
                    } else {
                        if (! treeMap2.containsKey(b)) {
                            treeMap2.put(b, new ArrayDeque<>());
                        }
                        treeMap2.get(b).add(start);
                    }
                }
            }
        }
        for (Map.Entry<Long, ArrayDeque<Long>> entry: treeMap2.entrySet()) {
            long a = entry.getKey();
            for (long b: entry.getValue()) {
                sum += (a - b) * y;
                sum %= 1000000007;
            }
        }

        System.out.println(sum);
        /*while (treeMap.size() > 0) {
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

                b = bb;
            }
        }
        System.out.println(sum % 1000000007);*/




    }
}
