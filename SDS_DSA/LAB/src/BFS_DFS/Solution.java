package BFS_DFS;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	private static int testcase, n, k, u, v;
	private static LinkedList<Integer>[] pair;
	private static boolean[] visited;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			n = sc.nextInt(); // number of node
			k = sc.nextInt(); // number of pairs
			pair = new LinkedList[n + 1];
			for (int i = 1; i <= n; i++) {
				pair[i] = new LinkedList<>();
			}
			for (int j = 1; j <= k; j++) {
				u = sc.nextInt();
				v = sc.nextInt();
				pair[u].add(v);
				pair[v].add(u);
			}
			visited = new boolean[n + 1];
			int result = 0;
			int count_edges=0;
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					result = Math.max(result, bfs(i));
					bfs(i);
					count_edges++;
				
				}
			}
			System.out.println("");
			System.out.println("#"+t+" "+count_edges+" "+result);

		}
	}

	private static int bfs(int start) {
		int count = 0;
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(start);
		count++;
		visited[start] = true;
		while (!queue.isEmpty()) {
			int node = queue.poll();			
			for (int item : pair[node]) {
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
