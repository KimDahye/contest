package JAEHASAFE;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://algospot.com/judge/problem/read/JAEHASAFE
 * @author Sophie
 *
 */
public class Main {
	private Scanner scan;

	public static void main(String[] args) {
		Main main = new Main();
		main.solve();
	}

	public void solve() {
		scan = new Scanner(System.in);
		int testNum = scan.nextInt();
		for (int i = 0; i < testNum; i++) {
			int roundNum = scan.nextInt();
			scan.nextLine();
			String current = scan.nextLine();
			int pwLength = current.length();
			int count = 0;
			for (int j = 0; j < roundNum; j++) {
				StringBuilder sb = new StringBuilder(2 * pwLength);
				String next = scan.nextLine();
				if (j % 2 != 0) { // counterclockwise
					String source = sb.append(current).append(current).toString();
					count += kmpSearch(source, next).get(0);
				} else { // clockwise
					String source = sb.append(next).append(next).toString();
					count += kmpSearch(source, current).get(0);
				}
				current = next;
			}
			System.out.println(count);
		} // test case End
	}// solve method End

	ArrayList<Integer> kmpSearch(final String haystack, final String needle) {
		int n = haystack.length(), m = needle.length();
		ArrayList<Integer> ret = new ArrayList<Integer>();

		ArrayList<Integer> pi = getPartialMatch(needle);
		int begin = 0, matched = 0;
		while (begin <= n - m) {
			if (matched < m && haystack.charAt(begin + matched) == needle.charAt(matched)) {
				matched++;
				if (matched == m)
					ret.add(begin);
			} else {
				if (matched == 0) {
					begin++;
				} else {
					begin += matched - pi.get(matched - 1);
					matched = pi.get(matched - 1);
				}
			}
		}
		return ret;
	}

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
