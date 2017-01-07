package HABIT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Sophie
 *
 */
public class Main {
	public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        String str = "banana";
        ArrayList<Integer> suffix = getSuffixArray(str);
        for(int i=0; i < suffix.size();  i++) {
            System.out.println(suffix.get(i));
        }

        //parsing
        // Scanner scan = new Scanner(System.in);
        // int testNum = scan.nextInt();
        // for(int i = 0; i<testNum; i++) {
        //    int k = scan.nextInt();
        //    String script = scan.nextLine();
        // } // test case End
    }// solve method End

    public void initializeArrayList(ArrayList<Integer> arr, int n) {
        for(int i = 0; i < n; i++) {
            arr.add(0);
        }
    }

    public ArrayList<Integer> getSuffixArray(final String str) {
        int n = str.length();
        int t = 1;
        ArrayList<Integer> group = new ArrayList<>(n+1); 
        for(int i = 0; i < n; i++) {
            group.add((int)str.charAt(i));
        }
        group.add(-1);

        ArrayList<Integer> perm = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            perm.add(i);
        }

        while(t < n) {
            Comparator compareWith2t = new IndexComparator(group, t);
            Collections.sort(perm,compareWith2t);
            t = t*2;
            if(t >= n) break;

            ArrayList<Integer> newGroup = new ArrayList<>(n+1); 
            initializeArrayList(newGroup, n+1);
            newGroup.set(n, -1);
            newGroup.set(perm.get(0), 0);
            for(int i = 1; i< n; i++) {
                if(compareWith2t.compare(perm.get(i-1), perm.get(i)) != 0)
                    newGroup.set(perm.get(i), newGroup.get(perm.get(i-1)) + 1);
                else 
                    newGroup.set(perm.get(i), newGroup.get(perm.get(i-1)));
            }
            group = newGroup;
        }
        return perm;
    }

    public static class IndexComparator implements Comparator<Integer> {
        private ArrayList<Integer> group;
        private int t;

        public IndexComparator(ArrayList group, int t) {
            this.group = new ArrayList<>(group);
            this.t = t;
        }

        public int compare(Integer a, Integer b) {
             if(group.get(a) != group.get(b)) return group.get(a) - group.get(b);
             return group.get(a+t) - group.get(b+t);
        }

        // Method to compare with another comparator
        public boolean equals(Object collator) {
            if (this == collator) { // If argument is the same object
                return true; // then it must be equal
            }
            if (collator == null) { // If argument is null
                return false; // then it can't be equal
            }
            return getClass() != collator.getClass();
        }
    }
}
