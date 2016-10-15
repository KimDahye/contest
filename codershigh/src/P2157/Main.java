package P2157;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/2157
 * @author sophie
 */
public class Main {
//    int n;
//    int m;
//    int k;
//    ArrayList<City> cities;
//    Integer memo [][];
//
//    public static void main(String[] args) {
//        Main m = new Main();
//        m.solve();
//    }
//
//    public static void print(String str) {
//        System.out.println(str);
//    }

//    public void solve() {
//        Scanner s = new Scanner(System.in);
//        n = s.nextInt(); // city number
//        m = s.nextInt(); // m개 이하 도시
//        k = s.nextInt(); // 항공로 개수
//
//        memo = new Integer [n+1][m+1]; //** outOfIndex; 대회용 무조건 이렇게 해두고 시작하는 게 좋다.
//        for(int i = 0; i < n+1; i++){
//            for(int j = 0; j < m+1; j++) {
//                memo[i][j] = -1;
//            }
//        }
//        cities = new ArrayList<>(n+1);
//        cities.add(0, new City(-1));
//        for(int i = 0; i < n; i++) {
//            cities.add(i+1, new City(i+1));
//        }
//
//        for(int i = 0 ; i < k; i ++) {
//            int from = s.nextInt();
//            int to = s.nextInt();
//            int score = s.nextInt();
//            if(from < to) {
//                City key = cities.get(to);
//                Integer temp = cities.get(from).possibleCities.get(key);
//                if(temp == null || temp < score) {
//                    cities.get(from).possibleCities.put(key, score);
//                }
//            }
//        }
//
//        print(""+navigateScore(1, m));
//    }
//
//    //cityNum 부터 시작하는 항해!
//    public int navigateScore (int cityNum, int limit) {
//        if(memo[cityNum][limit] != -1) return memo[cityNum][limit];
//
//        //** 기저사례 순서
//        if(cityNum == n) {
//            return 0;
//        }
//
//        if(limit == 1) {
//            return -987654321;
//        }
//
//        Integer max = memo[cityNum][limit];
//        max = -987654321; // ** 현욱's point
//        City start = cities.get(cityNum);
//        for(City to : start.possibleCities.keySet()) {
//            int score = start.possibleCities.get(to);
//            int subScore = navigateScore(to.num, limit - 1);
//            if( max < subScore + score){
//                max = subScore + score;
//            }
//        }
//        return max;
//    }
//
//    private class City {
//        private int num;
//        Map<Integer, Integer> possibleCities = new HashMap<>();
//
//        City(int num) {
//            this.num = num;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            City city = (City) o;
//
//            return num == city.num;
//
//        }
//
//        @Override
//        public int hashCode() {
//            return num;
//        }
//    }
}
