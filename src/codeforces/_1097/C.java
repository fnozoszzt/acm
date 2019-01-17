package codeforces._1097;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class C {

    static int maxn = 500050;

    static ArrayList<Integer>[] ll;
    static ArrayList<Integer>[] rr;
    static {
        ll = new ArrayList[maxn];
        rr = new ArrayList[maxn];
        for (int i = 0; i < maxn; i++) {
            ll[i] = new ArrayList<>();
            rr[i] = new ArrayList<>();
        }
    }




    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int sum_0 = 0;

        for (int t = 0; t < n; ++t) {
            int right = 0;
            int left = 0;
            ArrayDeque<Character> stk = new ArrayDeque<Character>();
            char[] str = scanner.next().toCharArray();
            for (int i = 0; i < str.length; ++i) {
                if (str[i] == '(') {
                    stk.push(str[i]);
                }
                if (str[i] == ')') {
                    if (stk.size() != 0 && stk.peek() == '(') {
                        stk.pop();
                    } else {
                        right += 1;
                    }
                }
            }
            left = stk.size();
            if (left != 0 && right != 0) {
                continue;
            }
            if (left != 0) {
                ll[left].add(t);
            }
            if (right != 0) {
                rr[right].add(t);
            }
            if (left == 0 && right == 0) {
                sum_0 += 1;
            }
            // printf("%d %d\n", left, right);
        }
        int sum = sum_0 / 2;
        for (int i = 1; i < maxn; ++i) {
            int ll_size = ll[i].size();
            int rr_size = rr[i].size();
            if (ll_size > 0 && rr_size > 0) {
                sum += Math.min(ll_size, rr_size);
            }
        }
System.out.println(sum);



    }
}
