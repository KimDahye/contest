package GRADUATION;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

/**
 * problem uri: https://algospot.com/judge/problem/read/GRADUATION
 * SOLVED
 * @author sophie
 */
public class Main {
    ArrayList<Integer> coursePreInfo;
    ArrayList<Integer> coursesPerSemester;
    int totalCourseNum; //N
    int minCourseNum;
    int semesterNum; // M
    int maxCourseCountPerSemester;
    int [][] memo;

    int NUM_OF_EVENTS = (int)Math.pow(2, 13);
    int INF = 987654321;

    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public void solve() {
        //parsing
        Scanner scan = new Scanner(System.in);
        int testNum = scan.nextInt();
        for(int i = 0; i<testNum; i++) {
            totalCourseNum = scan.nextInt(); //N
            minCourseNum = scan.nextInt();
            semesterNum = scan.nextInt(); // M
            maxCourseCountPerSemester = scan.nextInt();

            //과목 정보 parsing
            coursePreInfo = new ArrayList<>(totalCourseNum);
            for(int j = 0; j < totalCourseNum; j++) {
                int preRequisiteNum = scan.nextInt();
                int curPreReq = 0;
                for(int k = 0; k < preRequisiteNum; k++) {
                    curPreReq = curPreReq | (1 << scan.nextInt());
                }
                coursePreInfo.add(j, curPreReq);
            }

            // M X N 배열에 학기별 과목 정보
            coursesPerSemester = new ArrayList<>(semesterNum);
            for(int j=0; j<semesterNum; j++) {
                int courseNumThisSemester = scan.nextInt();
                int curCourse = 0;
                for(int k=0; k<courseNumThisSemester; k++) {
                    curCourse = curCourse | (1 << scan.nextInt());
                }
                coursesPerSemester.add(j, curCourse);
            }

            memo = new int[semesterNum][NUM_OF_EVENTS];
            for(int j=0; j<semesterNum; j++) {
                for(int k = 0; k< NUM_OF_EVENTS; k++) {
                    memo[j][k] = -1;
                }
            }
            int sol = getMinSemester(0, 0);
            print((sol == INF) ? "IMPOSSIBLE" :  Integer.toString(sol));
        }
    }

    public int getMinSemester(int curSemester, int takenCourses) {
        //종료 조건: 최대 학기 내에 최소 과목 수강했거나, 최대학기 넘었거나
        if(Integer.bitCount(takenCourses) >= minCourseNum) return 0;
        if(curSemester == semesterNum) return INF;

        // caching 확인
        int cache = memo[curSemester][takenCourses];
        if(cache != -1) {
            return cache;
        }

        // real logic
        int curSemesterCourses = coursesPerSemester.get(curSemester);
        int min = INF;

        // 아직 안들은 과목만 찾는다.
        int canTake = curSemesterCourses & ~takenCourses;

        // prerequisite 충족 안하는 것들은 뺀다.
//        BitSet bitSet = BitSet.valueOf(new long[] { canTake });
        int temp;
        for(int i = 0; i < totalCourseNum; i++) {
            int preReq = coursePreInfo.get(i);
            if((canTake & (1 << i)) != 0 && (preReq != (preReq & takenCourses))) {
                canTake = canTake & ~(1 << i);
            }
        }

        for(int subset = canTake; subset > 0; subset = (subset - 1) & canTake) {
            if(isPossibleToTake(subset, takenCourses)){
                temp = getMinSemester(curSemester+1, (subset | takenCourses)) + 1;
                if(temp < min) min = temp;
            }
        }

        temp = getMinSemester(curSemester+1, takenCourses);
        if(temp < min) min = temp;

        memo[curSemester][takenCourses] = min;
        return min;
    }

    public boolean isPossibleToTake(int subset, int takenCourses) {
        int subsetCount = Integer.bitCount(subset);
        if(subsetCount > maxCourseCountPerSemester) return false;

        return true;
    }

    // 확인 완료
    public static ArrayList<Integer> getIntArrByBitSet(BitSet b) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = b.nextSetBit(0);
        if (i != -1) {
            result.add(i);
            for (i = b.nextSetBit(i+1); i >= 0; i = b.nextSetBit(i+1)) {
                int endOfRun = b.nextClearBit(i);
                do { result.add(i); }
                while (++i < endOfRun);
            }
        }
        return result;
    }
}