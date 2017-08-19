package E2016;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.solve();
    }

    public void solve() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        TreeSet<Equation> equations = new TreeSet<>();
        for(int i = 0 ; i < n; i ++) {
            int h = s.nextInt();
            switch(h) {
                case 1:
                    Equation newEq = new Equation(s.nextLong(), s.nextLong());
                    equations.add(newEq);
                    break;
                case 2:
                    long x = s.nextLong();
                    if(x < 0) {
                        print(equations.last().value(x) + "");
                    } else {
                        print(equations.first().value(x) + "");
                    }
                    break;
                default:
            }
        }
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public class Equation implements Comparable<Equation>{
        long a;
        long b;

        Equation(long a, long b) {
            this.a = a;
            this.b = b;
        }

        public long value(long x) {
            return a*x + b;
        }

        @Override
        public int compareTo(Equation o) {
            if(o.a > a) {
                return 1;
            } else if(o.a < a) {
                return -1;
            } else if (o.b > b){
                return 1;
            } else if (o.b < b) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
