package ASYMTILING;

import java.util.Scanner;

/**
 * @author sophie
 */
public class Main {
    int memo[];
    final static int MOD = 1000000007;

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int i = 0 ; i < t; i ++) {
            int n = scan.nextInt();
            int memoSize = n+1;
            memo = new int[memoSize];

            //memo init
            for(int j = 0; j < memoSize; j++) {
                memo[j] = -1;
            }
            print(async(n)+"");
        }

    }

    private int async(int n) {
        if(n <= 1) return 1;
        int ret = 0;
        ret = (tile(n) - tile(n/2) + MOD)% MOD;
        if(n%2 == 0) {
            ret = (ret - tile(n/2-1) + MOD) % MOD;
        }
        return ret;
    }

    // tyling과 async 나눠야함 since 대칭되는 거 빠질 때 그 때 반조각짜리는 대칭이어도 상관 없기 때문!!
    private int tile(int n) {
        if(n<=1) return 1;
        if(memo[n] != -1) return memo[n];
        int ret = (tile(n-1) + tile(n-2)) % MOD;
        memo[n] = ret;
        return ret;
    }

    public static void print(String str) {
        System.out.println(str);
    }
}
