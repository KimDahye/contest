package ALGOSPOT_A;

import java.util.Scanner;

public class Main {
    long n, m, r0, c0, r, c, a, b;

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        //parsing
        Scanner scan = new Scanner(System.in);
        int testNum = scan.nextInt();
        for(int i = 0; i<testNum; i++) {
            n = scan.nextLong();
            m = scan.nextLong();
            r0 = scan.nextLong();
            c0 = scan.nextLong();
            r = scan.nextLong();
            c = scan.nextLong();
            a = scan.nextLong();
            b = scan.nextLong();
            long absH = Math.abs(r-r0);
            long absV = Math.abs(c-c0);
            long h = absH/a;
            long v = absV/b;

            if(absH%a != 0) h++;
            if(absV%b != 0) v++;
            System.out.println(h+v);
        }// test case End
    }// solve method End
}
