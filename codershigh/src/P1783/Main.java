package P1783;

import java.util.Scanner;

/**
 * @author sophie
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void print(int i) {
        System.out.println(i);
    }

    public static void print(long i) {
        System.out.println(i);
    }

    public void solve() {
        //parsing
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        int width = scan.nextInt();

        if(height > 2) {
            if(width > 5) {
                print(width-2);
            } else if (width == 5) {
                print(width -1);
            } else {
                print(width);
            }
        } else if (height == 2) {
            if(width > 6) {
                print(4);
            } else {
                print((width+1)/2);
            }
        } else { // height == 1
            print(1);
        }
    }
}
