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
public class Find_Node {

    private static int n, m, k;
    private static LinkedList<Integer>[] graph;
    private static LinkedList<Integer> listPeople;
    private static boolean[] visited;
    private static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();// choose node that node can connected k node
        n = sc.nextInt();// number of node
        m = sc.nextInt();// number of edges
        graph = new LinkedList[n + 1];
        listPeople = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            int u = sc.nextInt();
            listPeople.add(u);
        }
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList();
        }
        for (int j = 1; j <= m; j++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        visited = new boolean[n + 1];
        d = new int[n + 1];
        for (int item : listPeople) {
            bfs(item);
        }
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void bfs(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        d[start]++;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int item : graph[node]) {
                if (!visited[item]) {
                    queue.add(item);
                    visited[item] = true;
                    d[item]++;
                }
            }
        }
    }
}
