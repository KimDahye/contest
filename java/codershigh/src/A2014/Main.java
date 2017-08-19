package A2014;

import java.util.Scanner;

/**
 * @author sophie
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int y = 0, k = 0;

        for(int i = 0 ; i < n; i ++) {
            for(int j = 0; j < 9; j ++) {
                y += scan.nextInt();
                k += scan.nextInt();
            }
            if(y>k) print("Yonsei");
            else if(y==k) print("Draw");
            else print("Korea");
        }
    }

    public static void print(String str) {
        System.out.println(str);
    }
}