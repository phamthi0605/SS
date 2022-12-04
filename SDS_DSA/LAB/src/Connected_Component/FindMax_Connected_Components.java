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
public class FindMax_Connected_Components {

    private static int testcase, n, m, u, v;
    private static LinkedList<Integer>[] graph;
    private static Scanner sc = new Scanner(System.in);
    private static boolean[] visited;

    public static void main(String[] args) {
        testcase = sc.nextInt();
        for (int t = 0; t <= 20; t++) {
            n = sc.nextInt();
            m = sc.nextInt();
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
            int result = 0;
            for (int i = 1; i <= n; i++) {
              //  System.out.println(graph[i]);
                if (!visited[i]) {
                    result = Math.max(result, bfs(i));
                }
            }
            
            System.out.println(result);
        }
    }

    private static int bfs(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        int count = 0; //count node
        queue.add(start);//add first node
        count++;
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();           
            for (int item : graph[node]) {
                if (!visited[item]) {
                    queue.add(item);
                    visited[item] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
