package P1305;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1305
 * @author Sophie
 *
 */
public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.solve();
	}

	public void solve() {
		//parsing
		Scanner scan = new Scanner(System.in);
		int strLength = scan.nextInt();
		scan.nextLine();
		String str = scan.nextLine();
		ArrayList<Integer> pi = getPartialMatch(str);
		System.out.println(strLength - pi.get(strLength-1));
	}// solve method End

	private ArrayList<Integer> getPartialMatch(String needle) {
		int m = needle.length();
		ArrayList<Integer> pi = new ArrayList<Integer>(m);

		for (int i = 0; i < m; i++) {
			pi.add(0);
		}

		int begin = 1, matched = 0;
		while (begin + matched < m) {
			if (needle.charAt(begin + matched) == needle.charAt(matched)) {
				matched++;
				pi.set(begin + matched - 1, matched);
			} else {
				if (matched == 0) {
					begin++;
				} else {
					begin += matched - pi.get(matched - 1);
					matched = pi.get(matched - 1);
				}
			}
		}
		return pi;
	}
}
