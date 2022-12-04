/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connected_Component;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Count_Connected_Components {

    private static int testcase, m, n, u, v;
    private static LinkedList<Integer>[] graph;
    private static boolean[] visited;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        testcase = sc.nextInt();
        for (int t = 0; t < testcase; t++) {
            n = sc.nextInt();//n number of nodes
            m = sc.nextInt(); // m is number of edges
            graph = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList();
            }
            for (int j = 1; j <= m; j++) {
                u = sc.nextInt();
                v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }
            visited = new boolean[n + 1];
            //count_connected_components();
            int result= 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    result++;
                    bfs(i);
                }
                
            }
            System.out.println(result);
        }

    }

    private static void bfs(int start) {
        // dùng bfs để duyệt các phần tử
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int item : graph[node]) {
                if (!visited[item]) {
                    queue.add(item);
                    visited[item]=true;
                }
            }
        }
      
    }

}
