package hdu;

import java.util.Arrays;
import java.util.Scanner;

public class _3507 {
    static long sum[] = new long[500005];
    static int a[] = new int[500005],l[] = new int[500005];
    static long dp[] = new long[500005];
    static long getx(int x){
        return 2*sum[x];
    }
    static long gety(int x){
        return dp[x]+sum[x]*sum[x];
    }
    static long cross(long x1,long y1,long x2,long y2,long x3,long y3){
        return (y3-y1)*(x2-x1)-(y2-y1)*(x3-x1);
    }


    public static void main(String[] aaaa) {
        Scanner scanner = new Scanner(System.in);
        long k,m;
        int head, tail, n;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextLong();
            sum[0]=0;
            for(int i=1;i<=n;i++){
                a[i] = scanner.nextInt();
                sum[i]=sum[i-1]+a[i];
            }
            Arrays.fill(dp, 0);
            head=tail=0;
            l[tail++]=0;
            for (int i = 1; i <= n; i++) {
                k=sum[i];
//                while((head+1<tail)
//                        &&((gety(l[head+1])-gety(l[head]))<=k*(getx(l[head+1])-getx(l[head]))))
//                    head++;


                while (tail > head + 1) {
                    long q1 = gety(l[head + 1]) - gety(l[head]);
                    long w1 = getx(l[head + 1]) -  getx(l[head]);
                    if (q1 < w1 * sum[i]) {
                        head++;
                    } else {
                        break;
                    }
                }

                dp[i]=gety(l[head])-sum[i]*getx(l[head]);
                dp[i]+=sum[i]*sum[i]+m;

//                while((head+1<tail)&&
//                        cross(getx(l[tail-2]),gety(l[tail-2]),getx(l[tail-1]),gety(l[tail-1]),getx(i),gety(i))<=0)
//                    tail--;

                while (tail > head + 1) {
                    long qq = gety(i) - gety(l[tail - 1]);
                    long ww = getx(i) - getx(l[tail - 1]);

                    long qqq = gety(l[tail - 1]) - gety(l[tail - 2]);
                    long www = getx(l[tail - 1]) - getx(l[tail - 2]);

                    if (qqq * ww >= qq * www) {
                        tail--;
                    } else {
                        break;
                    }
                }


                l[tail] = i;
                tail++;


                /*while((head+1<tail)&&((gety(q[head+1])-gety(q[head]))<=k*(getx(q[head+1])-getx(q[head]))))
                    head++;
                dp[i]=gety(q[head])-k*getx(q[head]);
                dp[i]+=sum[i]*sum[i]+m;
                while((head+1<tail)&&cross(getx(q[tail-2]),gety(q[tail-2]),getx(q[tail-1]),gety(q[tail-1]),getx(i),gety(i))<=0)
                    tail--;
                q[tail++]=i;*/

            }
            System.out.println(dp[n]);
        }


    }
}
