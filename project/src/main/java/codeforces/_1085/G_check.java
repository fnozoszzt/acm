package codeforces._1085;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class G_check {
    static long mod = 998244353;
    static ArrayList<matrix> arrayList = new ArrayList<>();
    static int[][] tmp = new int[5][5];
    static boolean[][] use = new boolean[10][10];
    static int[][] data = new int[5][5];
    static matrix d;

    static void make(int i, int j) {
        if (i == 0) {
            for (int k = 1; k <= 5; k++) {
                if (! use[i][k]) {
                    use[i][k] = true;
                    tmp[i][j] = k;
                    if (j == 4) {
                        make(i + 1, 0);
                    } else {
                        make(i, j + 1);
                    }
                    use[i][k] = false;
                }
            }
        } else {
            for (int k = 1; k <= 5; k++) {
                if (! use[i][k] && tmp[i - 1][j] != k) {
                    use[i][k] = true;
                    tmp[i][j] = k;
                    if (i == 4 && j == 4) {
                        arrayList.add(new matrix(tmp));
                        if (arrayList.get(arrayList.size() - 1).equals(d)) {
                            System.out.println(arrayList.size());
                        }
                    } else {
                        if (j == 4) {
                            make(i + 1, 0);
                        } else {
                            make(i, j + 1);
                        }
                    }
                    use[i][k] = false;
                }
            }
        }
    }

    public static class matrix implements Comparable<matrix> {
        int[][] data;
        boolean flag;

        public matrix(int[][] tmp) {
            data = tmp.clone();
//            System.out.println("--");
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    System.out.print(tmp[i][j] + " ");
//                }
//                System.out.println();
//            }

        }

        @Override
        public int compareTo(matrix o) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (data[i][j] != o.data[i][j]) {
                        return Integer.compare(data[i][j], o.data[i][j]);
                    }
                }
            }
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            matrix o = (matrix) obj;
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length; j++) {
                    if (data[i][j] != o.data[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();



        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        d = new matrix(data);
        make(0, 0);

        System.out.println(arrayList.size());
        Collections.sort(arrayList);
        System.out.println(ans);

    }
}
