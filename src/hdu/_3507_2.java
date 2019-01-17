package hdu;

import java.util.Arrays;
import java.util.Scanner;

public class _3507_2 {
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
            while(scanner.hasNext()){

                n = scanner.nextInt();
                m = scanner.nextLong();
                sum[0]=0;
                for(int i=1;i<=n;i++){
                    a[i] = scanner.nextInt();
                    sum[i]=sum[i-1]+a[i];
                }
                //memset(dp,0,sizeof(dp));
                Arrays.fill(dp, 0);
                head=tail=0;
                l[tail++]=0;
                for(int i=1;i<=n;i++){
                    k=sum[i];
                    while((head+1<tail)&&((gety(l[head+1])-gety(l[head]))<=k*(getx(l[head+1])-getx(l[head]))))
                        head++;
                    dp[i]=gety(l[head])-k*getx(l[head]);
                    dp[i]+=sum[i]*sum[i]+m;
                    while((head+1<tail)&&cross(getx(l[tail-2]),gety(l[tail-2]),getx(l[tail-1]),gety(l[tail-1]),getx(i),gety(i))<=0)
                    tail--;
                    l[tail++]=i;
                }
                System.out.println(dp[n]);
        }


    }
}
