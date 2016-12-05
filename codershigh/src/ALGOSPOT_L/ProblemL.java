package ALGOSPOT_L;

import java.util.Scanner;

public class ProblemL {
    String ppap = "pen–pineapple–apple–pen/";
    int ppapLen = ppap.length();
    int MOD = 100000007;

    public static void main(String[] args) {
        ProblemL prob = new ProblemL();
        prob.solve();
    }

    // Rabin-Karp
    public void solve() {
        //parsing
        Scanner scan = new Scanner(System.in);
        int startIdx = scan.nextInt() - 1;
        int endIdx = scan.nextInt() - 1;
        String ptn = scan.next();
        int ptnLength = ptn.length();
        int totalLength = endIdx-startIdx +1;

        // exception handle
        if(ptnLength > totalLength) {
            System.out.println(0);
            return;
        }

        // string copy
        StringBuilder a = new StringBuilder(ppapLen*(endIdx/ppapLen) + 1);
        for(int i = 0; i <= endIdx/ppapLen; i++){
            a.append(ppap);
        }
        char[] totalArr = a.toString().toCharArray();
        char[] ptnArr = ptn.toCharArray();

        // pre-processing
        int d = 1;
        int ptnHash = 0;
        for(int i = 0; i<ptnLength; i++) {
            ptnHash = (ptnHash + (ptnArr[i] * d)%MOD) % MOD;
            d = d*10;
        }

        int processedText[] = new int[endIdx];
        int firstNum = 0;
        d = 1;
        for(int i = startIdx; i < startIdx+ptnLength; i++) {
            firstNum = (firstNum + (totalArr[i] * d)%MOD) % MOD;
            d = d * 10;
        }

        d = (int) Math.pow(10, ptnLength-1);
        processedText[startIdx] = firstNum;
        for(int i = startIdx+1; i < endIdx - ptnLength + 1; i++) {
            processedText[i] = ((processedText[i-1] - totalArr[i-1])/10 + (totalArr[i+ptnLength-1] * d)%MOD) % MOD;
        }

        // find string
        int count=0;
        for(int i = startIdx; i < endIdx - ptnLength + 1; i++ ){
            if (processedText[i] == ptnHash && isSamePtn(totalArr, ptnArr, i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private boolean isSamePtn(char[] totalArr, char[] ptnArr, int offset) {
        int count = 0;
        for(int j=0; j< ptnArr.length; j++) {
            if(totalArr[offset+j] != ptnArr[j]) {
                break;
            }
            count++;
        }
        return count == ptnArr.length;
    }
}
