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
            Queue<Node> que = new LinkedList<>();
            for(int j=0; j<m; j++) {
                que.add(new Node(scan.nextInt(), scan.nextInt(), scan.nextInt()));
            }

            //graph 구성 -> connected edge 만들고, bfs나 dfs를 돌리는 걸로 해야겠다.

            // count groups
            int count = 0;
            while(!que.isEmpty()) {
                Node node = que.remove();
                LinkedList<Node> newGroup = new LinkedList<>();
                newGroup.add(node);
                count++;

                Iterator<Node> queIter = que.iterator();
                while(queIter.hasNext()) {
                    Node curNode = queIter.next();
                    for(Node inNode : newGroup) {
                        if (curNode.isConnected(inNode)) {
                            queIter.remove();
                            newGroup.add(curNode);
                            break;
                        }
                    }
                }
            }
            print(count+ "");
        }
    }
}