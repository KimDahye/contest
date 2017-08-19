package P1328;

import java.util.Scanner;

/**
 * @author sophie
 */
public class Main {
    long memo[][][];
    int buildingNum;
    int leftBuilding;
    int rightBuilding;
    int MOD = 1000000007;

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
        buildingNum = scan.nextInt();
        leftBuilding = scan.nextInt();
        rightBuilding = scan.nextInt();

        //memoize prepare
        memo = new long[buildingNum+1][leftBuilding+1][rightBuilding+1];
        for(int i=0; i< buildingNum+1; i++) {
            for(int j=0; j<leftBuilding+1; j++){
                for(int k=0; k<rightBuilding+1; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        print(countBuilding(buildingNum-1, leftBuilding-1, rightBuilding-1));
    }

    private long countBuilding(int currentHeight, int left, int right){
        if(currentHeight == 0) {
            if(left==0 && right == 0) return 1;
            return 0;
        }

        if(memo[currentHeight][left][right] != -1) return memo[currentHeight][left][right];

        long count = 0;
        if(left != 0) {
            count = (count + countBuilding(currentHeight-1, left-1, right)) % MOD;
        }
        if(right != 0) {
            count = (count + countBuilding(currentHeight-1, left, right-1)) % MOD;
        }
        count = (count + ((buildingNum - currentHeight - 1) * countBuilding(currentHeight-1, left, right)) % MOD) % MOD;

        memo[currentHeight][left][right] = count%MOD;
        return memo[currentHeight][left][right];
    }
}
