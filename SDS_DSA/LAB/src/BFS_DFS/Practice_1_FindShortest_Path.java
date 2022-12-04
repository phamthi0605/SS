package BFS_DFS;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Function Description
 * 
 * Complete the bfs function in the editor below. If a node is unreachable, its
 * distance is .
 * 
 * bfs has the following parameter(s):
 *  int n: the number of nodes 
 *  int m: the number of edges 
 *  int edges[m][2]: start and end nodes for edges
 *  int s: the node to start traversals from
 *  Returns int[n-1]: the distances to nodes in increasing node number order, 
 *  not including the start node (-1 if a node is not reachable)
 * 
 *
 */

public class Practice_1_FindShortest_Path {

	private static int testcase;
	private static int m, n;
	static LinkedList<Integer>[] edges;
	private static int[] d;// distance from starting node to others

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testcase = sc.nextInt();
		for (int t = 0; t < testcase; t++) {
			n = sc.nextInt();// n : number of nodes
			m = sc.nextInt();// m : number of edges
			edges = new LinkedList[n + 1];// mảng chứa n nodes
			for (int i = 1; i <= n; i++) {
				edges[i] = new LinkedList();// khởi tạo list phần tử
			}
			for (int j = 0; j < m; j++) {
				int u, v;// 2 nodes u and v
				u = sc.nextInt();
				v = sc.nextInt();
				// undirected graph (nên khai báo 2 chiều)
				edges[u].add(v);
				edges[v].add(u);
			}

			int s;// start node
			s = sc.nextInt();
			// initialize value for array d
			d = new int[n + 1]; // khoi tao array chua cost cua points
			for (int i = 1; i <= n; i++) {
				d[i] = -1;// -1 not visited yet
			}
			solve(s);
		}
	}

	private static void solve(int s) {
		d[s] = 0;// initial distance for the first node
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(s);
		// continue until the BFS is done
		while (!queue.isEmpty()) {
			int u = queue.poll();// head
			for (int v : edges[u]) {
				if (d[v] == -1) {
					d[v] = d[u] + 6;
					queue.add(v);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (i != s) { // (d[i] != 0)// điểm bắt đầu
				System.out.print(d[i] + " ");
			}

		}
		System.out.println();

	}

}
/**
 * Input Format
 * 
 * The first line contains an integer q, the number of queries. 
 * Each of the following q sets of lines has the following format:
 * The first line contains two space-separated integers n and m, the number of
 * nodes and edges in the graph. 
 * Each line i of the m subsequent lines contains two
 * space-separated integers,u  and v, that describe an edge between nodes u and v
 * . The last line contains a single integer,s , the node number to start from
 */

/**
Sample Input:
2
4 2
1 2
1 3
1
3 1
2 3
2
**/

/**
 * Sample Output
6 6 -1
-1 6
**/