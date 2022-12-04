package BFS_DFS;

import java.util.LinkedList;
import java.util.Scanner;

public class Excel {
	static int n;// number of cells
	static int m;// influence information between two cells
	static int c;// total number of initial cells changed
	static LinkedList<Integer>[] list;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();
			list = new LinkedList[n + 1];
			for (int i = 1; i <= n; i++) {
				list[i] = new LinkedList<>();
			}
			for (int j = 1; j <= m; j++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				list[u].add(v);
			}
			result = 0;
			visited = new boolean[n + 1];
			for (int i = 1; i <= c; i++) {
				int z = sc.nextInt();
				if (visited[z] == false) {
					BFS(z);
				}
			}
			System.out.println("#" + t + " " + result);

		}
	}

	private static void BFS(int z) {
		LinkedList<Integer> queue = new LinkedList<>();
		if (visited[z] == false) {
			result++;
			visited[z] = true;

		}
		queue.add(z);
		while (!queue.isEmpty()) {
			int cr = queue.poll();
			for (Integer e : list[cr]) {
				if (visited[e] == false) {
					visited[e] = true;
					result++;
					queue.add(e);
				}
			}
		}

	}
}
