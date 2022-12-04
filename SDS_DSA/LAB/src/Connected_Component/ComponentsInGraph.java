package Connected_Component;

import java.util.LinkedList;
import java.util.Scanner;

public class ComponentsInGraph {

    static int n;
    static LinkedList<Integer>[] graph = new LinkedList[30001];
    static boolean[] visited = new boolean[30001];
    static Scanner sc = new Scanner(System.in);

    static int bfs(int s) {
        int c = 1;
        LinkedList<Integer> q = new LinkedList<>();
        q.push(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Integer v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.push(v);
                    c++;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        graph = new LinkedList[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 1; i <= n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[v].add(u);
            graph[u].add(v);
        }
        int min_nodes = 30001;
        int max_nodes = 0;
        for (int i = 1; i <= 2 * n; i++) {
            if (!visited[i] && graph[i].size() != 0) {
                int tmp = bfs(i);
                min_nodes = Math.min(min_nodes, tmp);
                max_nodes = Math.max(max_nodes, tmp);
            }
        }
        System.out.println("Min: "+min_nodes +"\tMax: "+ max_nodes);
    }

}
/**
5 
1 6
2 7
3 8
4 9
2 6
 */