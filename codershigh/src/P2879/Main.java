package P2879;

import java.util.Scanner;

/**
 * @author sophie
 */
public class Main {
    int lineNum;
    int [] curIndent; // 0으로 맞춰야 함.
    int MAX_TAB_COUNT = 80;

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
        Scanner s = new Scanner(System.in);
        lineNum = s.nextInt();

        curIndent = new int [lineNum];
        for(int i = 0; i<lineNum; i++){
            curIndent[i] = s.nextInt();
        }

        int min = 987654321;
        int firstNotZeroIdx = -1;
        for(int i = 0; i<lineNum; i++){
            curIndent[i] = s.nextInt() - curIndent[i];
            if(min > curIndent[i]) {
                min = curIndent[i];
            }
            if(curIndent[i] != 0 && firstNotZeroIdx == -1) {
                firstNotZeroIdx = i;
            }
        }

        boolean isBeforePlusBoolean = false;
        int subFromIdx = firstNotZeroIdx;
        int subMin = curIndent[firstNotZeroIdx];
        int count =0;
        int i = firstNotZeroIdx;
        while(i < lineNum) {
            if(curIndent[i] == 0) {
                // 연속이 아니면 여기서 부분 문제 부름
                count = count + minTabCount(subFromIdx, i-1, subMin);

                // 다음 부분문제 준비
                int j;
                for(j = i+1; j < lineNum; j++) {
                    if(curIndent[j] != 0) {
                        break;
                    }
                }
                subFromIdx = j;
                i = j;
                continue;
            }

            if(subFromIdx == i) {
                isBeforePlusBoolean = (curIndent[subFromIdx] > 0);
                subMin = curIndent[i];
                continue;
            }

            if((curIndent[i] > 0) != isBeforePlusBoolean) { // curIndent[i] * curIndent[subFromIdx] < 0
                // 연속이 아니면 여기서 부분 문제 부름
                count = count + minTabCount(subFromIdx, i-1, subMin);

                // 다음 부분문제 준비
                subFromIdx = i;
                continue;
            }

            if(abs(subMin) > abs(curIndent[i])) {
                subMin = curIndent[i];
            }
            i++;
        }
        print(count);
    }

    private int minTabCount(int fromIdx, int toIdx, int min) {
        int firstNotZeroIdx = -1; // not setting
        for(int i = fromIdx; i < toIdx+1; i++) {
            curIndent[i] = curIndent[i] - min;
            if(curIndent[i] != 0 && firstNotZeroIdx == -1) {
                firstNotZeroIdx = i;
            }
        }

        int count = abs(min);
        if(fromIdx == toIdx) {
            return count;
        }

        boolean isBeforePlusBoolean = false;
        int subFromIdx = firstNotZeroIdx;
        int subMin = curIndent[firstNotZeroIdx];
        int i = firstNotZeroIdx;
        while(i < toIdx + 1) {
            if(curIndent[i] == 0) {
                // 연속이 아니면 여기서 부분 문제 부름
                count = count + minTabCount(subFromIdx, i-1, subMin);

                // 다음 부분문제 준비
                int j;
                for(j = i+1; j < toIdx + 1; j++) {
                    if(curIndent[j] != 0) {
                        break;
                    }
                }
                subFromIdx = j;
                i = j;
                continue;
            }

            if(subFromIdx == i) {
                isBeforePlusBoolean = (curIndent[subFromIdx] > 0);
                subMin = curIndent[i];
                continue;
            }

            if((curIndent[i] > 0) != isBeforePlusBoolean) { // curIndent[i] * curIndent[subFromIdx] < 0
                // 연속이 아니면 여기서 부분 문제 부름
                count = count + minTabCount(subFromIdx, i-1, subMin);

                // 다음 부분문제 준비
                subFromIdx = i;
                continue;
            }

            if(abs(subMin) > abs(curIndent[i])) {
                subMin = curIndent[i];
            }
            i++;
        }
        return count;
    }

    private int abs(int i) {
        if(i < 0) {
            return -i;
        }
        return i;
    }
}
