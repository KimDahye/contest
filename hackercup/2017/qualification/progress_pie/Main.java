package progress_pie;

import java.util.Scanner;


/**
 * https://www.facebook.com/hackercup/problem/1254819954559001/
 * @author Sophie
 *
 */
public class Main {
    public static final String WHITE = "white";
    public static final String BLACK = "black";

    public static final Point mid = new Point(50, 50);
    public static final int radius = 50;

	public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        //parsing
        Scanner scan = new Scanner(System.in);


        int testNum = scan.nextInt();
        for(int i = 0; i<testNum; i++) {
           int p = scan.nextInt();
           int x = scan.nextInt();
           int y = scan.nextInt();
           Point cur = new Point(x, y);
           System.out.println("Case #" + (i+1) + ": " + findColor(cur, p));
        }// test case End
    }// solve method End

    public static String findColor(Point cur, int percentage) {
        double dist = cur.dist(mid);
        boolean isInCircle = dist < radius;
	    if(!isInCircle) return WHITE;

        double criteriaAngle = percentage * 0.01 * 2 * Math.PI;
	    double curAngle = getAngle(cur, dist);
        boolean isInFromProgress = curAngle <= criteriaAngle;

        if(!isInFromProgress) return WHITE;
        return BLACK;
    }

    public static double getAngle(Point cur, double dist) {
        double cos = (cur.y - 50) / dist;
        double angle = Math.acos(cos);
        if(cur.x < 50) angle = 2 * Math.PI - angle;
        return angle;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double dist(Point p) {
            int x1 = this.x;
            int y1 = this.y;
            int x2 = p.x;
            int y2 = p.y;
            return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        }
    }
}
