package ALLERGY;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * example: https://algospot.com/judge/problem/read/ALLERGY

 2
 4 6
 cl bom dara minzy
 2 dara minzy
 2 cl minzy
 2 cl dara
 1 cl
 2 bom dara
 2 bom minzy
 10 7
 a b c d e f g h i j
 6 a c d h i j
 3 a d i
 7 a c f g h i j
 3 b d g
 5 b c f h i
 4 b e g j
 5 b c g h i
 ======
 2
 3

 * @author sophie
 */
public class Main {
    int best;
    int friends, foods;
    Map<Integer, ArrayList<Integer>> info;

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
        int test = scan.nextInt();
        for(int i = 0; i < test; i++) {
            friends = scan.nextInt();
            foods = scan.nextInt();
            info = new HashMap<>();
            Map<String, Integer> names = new HashMap<>();
            for(int j = 0; j < friends; j++) {
                names.put(scan.next(), j);
            }

            for(int j=0; j<foods; j++) {
                int count = scan.nextInt();
                info.put(j, new ArrayList<Integer>());
                for(int k=0; k < count; k++) {
                    info.get(j).add(names.get(scan.next()));
                }
            }
            best = foods;
            leastFoodCount(new BitSet(friends), 0, 0);
            print(best);
        }
    }


    // eatable: curFoodIdx 전까지 돌면서 먹을 수 있는 사람 조합
    // curFoodIdx: 지금 넣을지 말지 결정하는 idx
    // foodCount: curFoodIdx 전까지 돌면서 선택된 food 개수
    public int leastFoodCount(BitSet eatable, int curFoodIdx, int foodCount) {
        // 가지치기1: best값보다 큰 거는 더 해볼 필요 없이 그만 둔다.
        if(foodCount >= best) {
            return best;
        }

        // 종료조건 2: 더이상 돌아볼 food가 없을 때
        if(curFoodIdx == foods) {
            return best;
        }

        // 종료 조건: 이미 다 먹을 수 있다면 best값과 비교하여 셋팅해준다.
        if(eatable.cardinality() == friends) {
            best = Math.min(best, foodCount); // best는 다 먹었을 때만, 문제 조건을 만족할 때만 갱신해줘야함.
            return best;
        }

        int notIncluded = leastFoodCount(eatable, curFoodIdx+1, foodCount);
        BitSet eatableCopy = (BitSet) eatable.clone();
        for(int idx : info.get(curFoodIdx)) {
            eatableCopy.set(idx);
        }
        int included = leastFoodCount(eatableCopy, curFoodIdx+1, foodCount+1);
        return Math.min(notIncluded, included);
    }
}
