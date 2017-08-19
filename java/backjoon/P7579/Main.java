package P7579;

import java.util.Scanner;

/**
 * @author sophie
 */
public class Main {
    int memo[][];
    int memoryPerApp[];
    int costPerApp[];
    int costMax = 100;
    int appNum;

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

    public void solve() {
        //parsing
        Scanner scan = new Scanner(System.in);
        appNum = scan.nextInt();
        int neededMemory = scan.nextInt();
        memoryPerApp = new int [appNum+1];
        for(int i = 1; i<appNum+1; i++) {
            memoryPerApp[i] = scan.nextInt();
        }
        costPerApp = new int [appNum+1];
        for(int i = 1; i<appNum+1; i++) {
            costPerApp[i] = scan.nextInt();
        }

        //memoize prepare
        memo = new int[appNum+1][];
        for(int i=0; i< appNum+1; i++) {
            for(int j=0; j<neededMemory+1; j++){
                memo[i][j] = -1;
            }
        }

        print(getLeastCost(1, neededMemory));
    }

    private int getLeastCost(int startAppNum, int memoryBound) {
        if(memoryBound <= 0) {
            return 0;
        }

        if(memo[startAppNum][memoryBound] != -1) {
            return memo[startAppNum][memoryBound];
        }

        if(startAppNum == appNum) {
            int ret = 987654321;
            if (memoryBound <= memoryPerApp[startAppNum]){
                ret = costPerApp[startAppNum];
            }
            memo[startAppNum][memoryBound] = ret;
            return ret;
        }

        int ret = Math.min(
                costPerApp[startAppNum] + getLeastCost(startAppNum+1, memoryBound-memoryPerApp[startAppNum]),
                getLeastCost(startAppNum+1, memoryBound));
        memo[startAppNum][memoryBound] = ret;
        return ret;
    }
    // knapsack문제인데, 시간복잡도와 공간복잡도를 고려했을 때
}
