package B2016;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author sophie
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.solve();
    }

    public void solve() {
        ArrayList<Data> container = new ArrayList<>(25);
        HashMap<Integer, Integer> keyMap = new HashMap<>();

        saveDatas(container, keyMap);
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // test number
        for(int i = 0 ; i < n; i++) {
            int from = scan.nextInt();
            int to = scan.nextInt();

            if(to < 1967) {
                print("0");
                continue;
            }

            if(from < 1967) {
                from = 1967;
            }

            Integer fromIndex = null;
            Integer toFirstIndex = null;
            int tempFrom = from;
            while(from < 2017) {
                fromIndex = keyMap.get(from);
                if(fromIndex ==null) {
                    from++;
                } else {
                    break;
                }
            }
            while(to > 1966) {
                toFirstIndex = keyMap.get(to);
                if(toFirstIndex == null){
                    to--;
                } else {
                    break;
                }
            }
            if(fromIndex==null || toFirstIndex==null){
                print("0");
                continue;
            }

            int after = toFirstIndex;
            if(after < container.size()-1) {
                while (container.get(after + 1).year == to) {
                    after++;
                }
            }
            int toIndex = after;

            print((toIndex-fromIndex+1)+"");
            for(int j=fromIndex; j<toIndex+1; j++){
                print(container.get(j).toString());
            }
        }
    }

    public void saveDatas(ArrayList<Data> container, HashMap<Integer, Integer> keyMap) {
        container.add(new Data(1967, "DavidBowie"));
        container.add(new Data(1969, "SpaceOddity"));
        container.add(new Data(1970, "TheManWhoSoldTheWorld"));
        container.add(new Data(1971, "HunkyDory"));
        container.add(new Data(1972, "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars"));
        container.add(new Data(1973, "AladdinSane"));
        container.add(new Data(1973, "PinUps"));
        container.add(new Data(1974, "DiamondDogs"));
        container.add(new Data(1975, "YoungAmericans"));
        container.add(new Data(1976, "StationToStation"));
        container.add(new Data(1977, "Low"));
        container.add(new Data(1977, "Heroes"));
        container.add(new Data(1979, "Lodger"));
        container.add(new Data(1980, "ScaryMonstersAndSuperCreeps"));
        container.add(new Data(1983, "LetsDance"));
        container.add(new Data(1984, "Tonight"));
        container.add(new Data(1987, "NeverLetMeDown"));
        container.add(new Data(1993, "BlackTieWhiteNoise"));
        container.add(new Data(1995, "1.Outside"));
        container.add(new Data(1997, "Earthling"));
        container.add(new Data(1999, "Hours"));
        container.add(new Data(2002, "Heathen"));
        container.add(new Data(2003, "Reality"));
        container.add(new Data(2013, "TheNextDay"));
        container.add(new Data(2016, "BlackStar"));

        for(int i=0; i<container.size(); i++) {
            int year = container.get(i).year;
            if(keyMap.get(year) == null) {
                keyMap.put(year, i);
            }
        }
    }

    public static void print(String str) {
        System.out.println(str);
    }

    private class Data {
        int year;
        String album;

        Data(int year, String album) {
            this.year = year;
            this.album = album;
        }

        @Override
        public String toString(){
            return year + " " + album;
        }
    }
}