package BFS_DFS;

import java.util.LinkedList;
import java.util.Scanner;


public class Price_Of_1cm {
	static int tc;
	static int n; // number of friends
	static int m; // number of relationships
	static LinkedList<Integer>[] lists;
	static int[] d = new int[12];
	static int[] res = new int[12];
	static boolean[] visited = new boolean[12];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		tc = scanner.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = scanner.nextInt();
			m = scanner.nextInt();
			lists = new LinkedList[m + 1];
			for (int i = 1; i <=m; i++) {
				lists[i] = new LinkedList<>();
			}
			for (int i = 1; i <= m; i++) {
				int u = scanner.nextInt();
				int v = scanner.nextInt(); 
				lists[v].add(u);
			}
			System.out.print("#" + t + " ");
                       
			solve();
		}
	}

	private static void dfs(int u) {
		visited[u] = true;
		for (int v : lists[u]) {
			d[v] = Math.max(d[v], d[u] + 1);
			dfs(v);
		}
		visited[u] = false;
	}

	private static void solve() {
		for (int i = 1; i <= n; i++) {
			d[i] = 1;
			visited[i] = false;
		}
		for (int i = 1; i <= n; i++) {
			dfs(i);
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(d[i] + " ");
		}
	}
}
/**
 * 
1
4 4
1 3
3 2
4 3
1 4
 */