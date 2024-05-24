import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        int n = s.length();
        int m = t.length();
        int count = 0;

        long p = 9973;
        long mod = (long) 1e9 + 7;

        long h_t = 0;
        for (int i = 0; i < m; i++) {
            long c = t.charAt(i) - 'a';
            h_t = (h_t * p + c) % mod;
        }

        long[] h_s = new long[n];
        h_s[0] = s.charAt(0);
        for (int i = 1; i < n; i++) {
            long c = s.charAt(i) - 'a';
            h_s[i] = (h_s[i - 1] * p + c) % mod;
        }

        long p_m = 1;
        for (int i = 0; i < m; i++) {
            p_m = p_m * p % mod;
        }

        for (int i = m - 1; i < n; i++) {
            long h = h_s[i];
            if (i > m - 1) {
                h = (h - h_s[i - m] * p_m % mod + mod) % mod;
            }
            if (h == h_t) count++;
        }
        System.out.println(count);
    }
}
