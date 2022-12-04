package BFS_DFS;

import java.util.LinkedList;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class BFS_ShortestPath {

    private static String[][] a;
    private static int[] dx = {0, 0, 1, -1};//right, left, down, up
    private static int[] dy = {1, -1, 0, 0};
    private static int shortestPath;
    private static int step;
    private static boolean[][] visited = new boolean[5][7];
    private static int cost;

    private static class Node {

        int r;
        int c;
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "(" + r + "," + c + "," + cost + ")";
        }

    }

    /**
     * #: can't remove .: can move S: start E: end
     */
    private static void setup() {
        a = new String[5][7];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                a[i][j] = ".";
            }
        }
        a[0][0] = "S";
        a[0][3] = "#";

        a[1][1] = "#";
        a[1][5] = "#";

        a[2][1] = "#";

        a[3][2] = "#";
        a[3][3] = "#";

        a[4][0] = "#";
        a[4][2] = "#";
        a[4][3] = "E";
        a[4][5] = "#";
    }

    private static void print() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static boolean validRow(int row) {
        return 0 <= row && row < 5;
    }

    private static boolean validCol(int column) {
        return 0 <= column && column < 7;
    }

    private static void BFS(Node node) {
        LinkedList<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][7];

        visited[node.r][node.c] = true;
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cr = queue.poll();

            //stop condition
            if (a[cr.r][cr.c].compareTo("E") == 0) {
                shortestPath = cr.cost;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nR = cr.r + dx[i];
                int nC = cr.c + dy[i];
                if (validRow(nR) && validCol(nC) && !visited[nR][nC] && a[nR][nC].compareTo("#") != 0) {
                    Node next = new Node(nR, nC, cr.cost + 1);
                    queue.add(next);
                    visited[nR][nC] = true;
                }
            }

        }
    }

    private static void DFS(Node node) {
        shortestPath = Integer.MAX_VALUE;
        Stack<Node> stack = new Stack<>();
        boolean[][] visited = new boolean[5][7];
        visited[node.r][node.c] = true;
        stack.add(node);

        while (!stack.isEmpty()) {
            Node cr = stack.pop();
            if (cr.cost > shortestPath) {
                continue;
            }
            System.out.println(cr);
            //stop condition
            if (a[cr.r][cr.c].compareTo("E") == 0) {
                if (cr.cost < shortestPath) {
                    shortestPath = cr.cost;
                }
            }
            for (int i = 0; i < 4; i++) {
                int nR = cr.r + dx[i];
                int nC = cr.c + dy[i];
                if (validRow(nR) && validCol(nC) && !visited[nR][nC] && a[nR][nC].compareTo("#") != 0) {
                    Node next = new Node(nR, nC, cr.cost + 1);
                    stack.add(next);
                    visited[nR][nC] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        setup();
        print();
        step=0;
        visited[0][0]=true;
        shortestPath=Integer.MAX_VALUE;
        //shortestPath = -1;
       // BFS(new Node(0, 0, 0));
        DFS(new Node(0, 0, 0));
        System.out.println("Shortest Path:S-E:" + shortestPath);
    }

}
