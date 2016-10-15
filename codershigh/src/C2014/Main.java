package C2014;

import java.util.*;

/**
 * @author sophie
 */
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.solve();
    }

    public static void print(String str) {
        System.out.println(str);
    }

    private class Node {
        int x;
        int y;
        int r;
        ArrayList<Integer> adjacentListIndex = new ArrayList<Integer>();
        boolean visit = false;

        Node(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }

        boolean isConnected(Node node) {
            double a = (this.x - node.x);
            double b = (this.y-node.y);
            double c = a*a + b*b;
            double d = Math.sqrt(c);
            if(d <= (r + node.r)) return true;
            return false;
        }
    }

    public void solve() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // test number
        for(int i = 0 ; i < n; i++) {
            int m = scan.nextInt(); // point number

            //point parsing
            ArrayList<Node> points = new ArrayList<>();
            for(int j=0; j<m; j++) {
                points.add(new Node(scan.nextInt(), scan.nextInt(), scan.nextInt()));
            }

            //connected edge 정보 구성
            for(int j=0; j<m; j++) {
                for(int k=0; k<j; k++) {
                    if(points.get(j).isConnected(points.get(k))){
                        points.get(j).adjacentListIndex.add(k);
                        points.get(k).adjacentListIndex.add(j);
                    }
                }
            }

            // count groups
            int count = 0;
            for(int l=0; l<m; l++) {
                if(!points.get(l).visit){
                    bfs(points, l);
                    count++;
                }
            }
            print(count+ "");
        }
    }

    public void bfs (ArrayList<Node> nodes, int i) {
        Queue<Node> que = new LinkedList<Node>();
        nodes.get(i).visit=true;
        que.add(nodes.get(i));
        while(!que.isEmpty()) {
            Node curNode = que.remove();
            for(int j: curNode.adjacentListIndex){
                if(!nodes.get(j).visit){
                    que.add(nodes.get(j));
                    nodes.get(j).visit = true;
                }
            }
        }
    }
}