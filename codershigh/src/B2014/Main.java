package B2014;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author sophie
 * short type range: -32,768 and a maximum value of 32,767
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0 ; i < n; i ++) {
            int a = scan.nextInt();
            String actions = scan.nextLine();
            String array[] = actions.split(" ");

            for(String s : array ){
                print(s);
            }
        }
    }

    public static void print(String str) {
        System.out.println(str);
    }
}
