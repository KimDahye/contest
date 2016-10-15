package A2016;

import java.util.Scanner;

/**
 * @author sophie
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i =0; i<n; i++) {
            int hp = scan.nextInt();
            int mp = scan.nextInt();
            int a = scan.nextInt();
            int d = scan.nextInt();

            hp = hp + scan.nextInt();
            mp = mp + scan.nextInt();
            a = a + scan.nextInt();
            d = d + scan.nextInt();

            //1 * (HP) + 5 * (MP) + 2 * (공격력) + 2 * (방어력)
            int total = (hp < 1 ? 1 : hp) + 5 * (mp < 1 ? 1 : mp) + 2 * (a < 0 ? 0 : a) + 2 * d;
            print(total + "");
        }
    }

    public static void print(String str) {
        System.out.println(str);
    }
}