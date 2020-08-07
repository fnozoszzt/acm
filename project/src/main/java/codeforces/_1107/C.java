package codeforces._1107;

import java.io.*;
import java.util.Arrays;

public class C {
    public static void main(String[] aaaa) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;

        int[] a = new int[200005];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        in.nextToken();
        char[] b = in.sval.toCharArray();
        char last = 0;
        int num = 0;
        int[] z = new int[200005];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            char c = b[i];
            if (c != last) {
                Arrays.sort(z, 0, num);
                for (int j = num - 1; j >= 0 && num - j <= k; j--) {
                    ans += z[j];
                }
                num = 0;
                last = c;
                z[num++] = a[i];
            } else {
                z[num++] = a[i];
            }
        }

        Arrays.sort(z, 0, num);
        for (int j = num - 1; j >= 0 && num - j <= k; j--) {
            ans += z[j];
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.println(ans);
        out.flush();

    }
}
