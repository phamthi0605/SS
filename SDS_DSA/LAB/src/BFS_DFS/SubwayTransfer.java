package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SubwayTransfer {
	private static class Node {
		int n;
		int nTransfer; // number of transfer

		public Node(int n, int nTransfer) {
			super();
			this.n = n;
			this.nTransfer = nTransfer;
		}

		@Override
		public String toString() {
			return "Node [n=" + n + ", nTransfer=" + nTransfer + "]";
		}

	}

	static int T;
	static int n, m, s, e;
	static LinkedList<Integer> subwayLine[];
	static LinkedList<Integer> listSubway[];
	static int[] a ;
	static int min;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		int x;
		for (int t = 1; t <= T; t++) {
			n = scanner.nextInt();
			m = scanner.nextInt();
			s = scanner.nextInt();
			e = scanner.nextInt();
			subwayLine = new LinkedList[m];
			for (int i = 0; i < m; i++) {
				subwayLine[i] = new LinkedList<>();
			}
			listSubway = new LinkedList[n + 1];
			for (int j = 1; j <= n; j++) {
				listSubway[j] = new LinkedList<>();
			}
			// trên mỗi line của mảng a sẽ chứa các điểm dừng
			a = new int[m];
			for (int i = 0; i < m; i++) {
				a[i] = scanner.nextInt();
			}
			// read subway
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < a[i]; j++) {
					x = scanner.nextInt();
					subwayLine[i].add(x);// each of subway line add number of station
					listSubway[x].add(i);
				}
			}
			min = -1;
			BFS(s);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void BFS(int start) {
		Queue<Node> queue = new LinkedList<Node>();
		int[] visit = new int[n + 1];
		for (Integer e : listSubway[start]) {
			for (Integer sub : subwayLine[e]) {
				if (visit[sub] == 0) {
					visit[sub] = 1;
					Node node = new Node(sub, 0);
					queue.add(node);
				}
			}
		}
		while (!queue.isEmpty()) {
			// get current node
			Node currNode = queue.poll();
			if (currNode.n == e) {
				min = currNode.nTransfer;
				return;
			}
			else {
				for (Integer i : listSubway[currNode.n]) {
					// get subways
					for (Integer sub : subwayLine[i]) {
						if (visit[sub] == 0) {
							visit[sub] = 1;
							Node node = new Node(sub, currNode.nTransfer + 1);
							queue.add(node);
						}
					}
				}
			}
		}

	}
}
