package ALGOSPOT_I;

import java.util.Scanner;

/**
 * @author sophie
 */
public class ProblemI {
    int s, e, d, c; // minutes

    public static void main(String[] args) {
        ProblemI prob = new ProblemI();
        prob.solve();
    }

    public void solve() {
        //parsing
        Scanner scan = new Scanner(System.in);
        int testNum = scan.nextInt();
        for(int i = 0; i<testNum; i++) {
            s = scanNextTimeInMinute(scan);
            e = scanNextTimeInMinute(scan);
            d = scanNextTimeInMinute(scan);
            c = scanNextTimeInMinute(scan);

            int count = c/d;
            if(c%d != 0) count++;

            int maxBuses = (e-s)/d + 1;
            if(maxBuses < count) {
                count = maxBuses;
            }

            System.out.println(count);
        }// test case End
    }// solve method End

    private int scanNextTimeInMinute(Scanner scan) {
        String time = scan.next();
        String sH = time.substring(0,2);
        String sM = time.substring(3,5);
        int h = Integer.parseInt(sH);
        int m = Integer.parseInt(sM);
        return h*60 + m;
    }
}
