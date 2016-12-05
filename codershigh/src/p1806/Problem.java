package p1806;

import java.util.Scanner;

/**
 * @author sophie
 */
public class Problem {
    int INT_MAX = 987654321;

    public static void main(String[] args) {
        Problem prob = new Problem();
        prob.solve();
    }

    public void solve() {
        //parsing
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int s = scan.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int min = INT_MAX;
        int left = 0, right = 0; // left, right both inclusive index.
        int sum = arr[left];
        while(right < n) {
            if(sum < s) {
                right++;
                if(right != n) sum = sum + arr[right];
            } else {
                int length = right - left + 1;
                min = Math.min(min, length);
                sum = sum - arr[left];
                left++;
            }
        }

        if(min == INT_MAX) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
