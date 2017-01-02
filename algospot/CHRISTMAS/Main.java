package CHRISTMAS;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * problem uri: https://algospot.com/judge/problem/read/CHRISTMAS
 * @author sophie
 */
public class Main {
    int boxNum;
    int childrenNum;
    int [] dollCountPartialSum;
    int [] dollCountRemainder; // 일단은 0번째 value 만 쓰고 있음.
    int [] partialSumRemainder; // partialSum을 childrenNum으로 나눠 1 ~ (childrenNum -1)
    ArrayList<ArrayList<Integer>> partialSumRemainderList; //

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        //parsing
        Scanner scan = new Scanner(System.in);
        int testNum = scan.nextInt();
        for(int i = 0; i<testNum; i++) {
            boxNum= scan.nextInt(); //N
            childrenNum = scan.nextInt(); //K

            // dollCountPartialSum 전체 0으로 초기화
            dollCountPartialSum = new int[boxNum];
            for(int j=0; j<childrenNum; j++) {
                dollCountPartialSum[j] = 0;
            }

            // partialSumRemainderList 전체 emptylist 로 초기화
            partialSumRemainderList = new ArrayList<>(childrenNum);
            partialSumRemainder = new int[childrenNum];
            dollCountRemainder = new int[childrenNum];
            for(int j=0; j<childrenNum; j++) {
                partialSumRemainder[j] = 0;
                dollCountRemainder[j] = 0;
                partialSumRemainderList.add(j, new ArrayList<Integer>());
            }

            // doll count parsing, partialSumRemaider setting
            int partialSum = 0;
            for(int curBoxNum = 0; curBoxNum < boxNum; curBoxNum++) {
                int dollCount = scan.nextInt();
                int dRemainder = dollCount % childrenNum;
                dollCountRemainder[dRemainder]++;
                partialSum = partialSum + dollCount;
                dollCountPartialSum[curBoxNum] = partialSum;
                int remainder = partialSum % childrenNum;
                partialSumRemainder[remainder] = partialSumRemainder[remainder] + 1;
                partialSumRemainderList.get(remainder).add(curBoxNum);
            }

            System.out.println(possibleSingularOrders() + " " + maxPluralOrderCount());
        }// test case End
    }// solve method End

    public int possibleSingularOrders() {
        int sum = 0;
        // 상자 하나만 사도 어린이들에게 똑같이 나눌 수 있는 경우
        sum = sum + dollCountRemainder[0];

        // 상자 여러개 사서 어린이들에게 똑같이 나눌 수 있는 경우
        for(int i=0; i<childrenNum-1; i++) {
            int groupCountForSameRemainder = partialSumRemainder[i];
            sum = sum + nChoose2(groupCountForSameRemainder);
        }
        return sum % 20091101;
    }

    public int nChoose2(int n) {
        if(n < 2) return 0;
        return n * (n-1) / 2;
    }

    public int maxPluralOrderCount() {
        //TODO
        return 1;
    }
}
