package template;

public class Pow {
    static long mod;
    static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return pow(a * a % mod, b / 2);
        } else {
            return pow(a * a % mod, b / 2) % mod * a % mod;
        }
    }
}
