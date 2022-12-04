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
public class Check_Connected_Components {

    private static int n, m, u, v, testcase;
    private static LinkedList<Integer> list;
    private static LinkedList<Integer>[] graph;
    private static Scanner sc = new Scanner(System.in);
    private static boolean[] visited;

    public static void main(String[] args) {
        testcase = sc.nextInt();
        for (int t = 0; t < testcase; t++) {
            n = sc.nextInt();//n : number of nodes
            m = sc.nextInt();// m : number of edges
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
            for (int i = 1; i <=n; i++) {
            	if (!solve()) {
                    System.out.println("No");
                }
            	System.out.println("Yes");
			}
        }
    }

    private static boolean checkPerfect(int s) {
        // dùng bfs để duyệt các phần tử
        LinkedList<Integer> queue = new LinkedList<>();
        // visited = new boolean[n];//check n node if it's visited
        queue.add(s);// add start node
        visited[s] = true;// node visited
        list = new LinkedList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();// get first node in queue to find edges
            list.add(node);
            for (int b : graph[node]) {
                 if (!visited[b]) {
                    queue.add(b);
                    visited[b] = true;
                }
            }
        }
        for (int check : list) {
            if (graph[check].size() != list.size() - 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean solve() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (!checkPerfect(i)) {
                    
                    return false;
                }
            }

        }
        return true;
    }
}
