package P1562;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1562
 * =+ 연산 잘못 알고 있었고. += 과 % 같이 쓰면 안됨.
 *
 * @author sophie
 */
public class Main {
    final static int MOD = 1000000000;
    int memo[][][];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Main main = new Main();
        main.solve(n);
    }

    public static void print(int str) {
        System.out.println(str);
    }

    public void solve(int n) {
        memo = new int[10][n][4];
        for(int i = 0; i < 10; i++) {
            for(int j= 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        int totalNum = 0;
        int pref = 0;
        for(int i=1; i<10; i++) {
            if(i == 9) {
                pref = pref | 2;
            }
            totalNum = (totalNum + stairNums(i, n-1, pref)) % MOD;
        }
        print(totalNum);
    }

    private int stairNums(int justBefore, int remain, int pref) {
        if(memo[justBefore][remain][pref] != -1) return memo[justBefore][remain][pref];

        if(remain == 0) {
            if(pref == (1 | 2)) return 1;
            return 0;
        }

        int res = 0;
        if(justBefore != 0) {
            res = stairNums(justBefore-1, remain-1, (justBefore-1 == 0)? (pref | 1) : pref);
        }
        if(justBefore != 9) {
            res = (res + stairNums(justBefore+1, remain-1, (justBefore+1 == 9)? (pref | 2) : pref)) % MOD;
        }

        memo[justBefore][remain][pref] = res;
        return res;
    }
}
