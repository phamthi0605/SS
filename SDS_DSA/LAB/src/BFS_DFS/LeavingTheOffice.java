package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeavingTheOffice {

	private static class Node {
		int r;
		int c;
		int step;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		public Node(int r, int c, int step) {
			super();
			this.r = r;
			this.c = c;
			this.step = step;
		}

		@Override
		public String toString() {
			return "(" + r + "," + c + ")";
		}

	}

	static int r, c, sR, sC, eR, eC;
	static char[][] map;
	static int[][] keyMap; // save min step from key to outdoor
	static int nKeys; // save number of keys
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int minStep;

	static final int MAX_VALUE = 1000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			r = sc.nextInt();
			c = sc.nextInt();

			sR = sc.nextInt();
			sC = sc.nextInt();

			map = new char[r + 1][c + 1];
			keyMap = new int[r + 1][c + 1];

			String line;

			for (int i = 1; i <= r; i++) {
				line = sc.next();
				for (int j = 1; j <= c; j++) {
					map[i][j] = line.charAt(j - 1);

					if (map[i][j] == 'a') {
						nKeys++;
					}

					if (map[i][j] == 'O') {
						eR = i;
						eC = j;
					}

					keyMap[i][j] = MAX_VALUE;

				}
			}

			// Find min value from exit to each keys
			BFSKey();

			minStep = MAX_VALUE;
			// Find min step from start to key
			BFS();

			minStep = minStep == MAX_VALUE ? -1 : minStep;
			System.out.println("#" + t + " " + minStep);
		}
	}

	private static void BFS() {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visit = new boolean[r + 1][c + 1];

		queue.add(new Node(sR, sC, 0));
		visit[sR][sC] = true;

		while (!queue.isEmpty()) {
			Node cr = queue.poll();

			// If found a key, check total step: from start to key + key to exit
			if (map[cr.r][cr.c] == 'a') {
				minStep = cr.step + keyMap[cr.r][cr.c] < minStep ? cr.step + keyMap[cr.r][cr.c] : minStep;
			}

			// There is a case that we can go to exit without case
			if (map[cr.r][cr.c] == 'O') {
				minStep = cr.step < minStep ? cr.step : minStep;
			}

			for (int i = 0; i < 4; i++) {
				int nR = cr.r + dx[i];
				int nC = cr.c + dy[i];

				// Can not go through A if don't have key
				if (isValidRow(nR) && isValidCol(nC) && !visit[nR][nC] && map[nR][nC] != 'X' && map[nR][nC] != 'A') {
					queue.add(new Node(nR, nC, cr.step + 1));
					visit[nR][nC] = true;
				}
			}
		}
	}

	private static void BFSKey() {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visit = new boolean[r + 1][c + 1];

		queue.add(new Node(eR, eC, 0));
		visit[eR][eC] = true;

		int crKeyFound = 0;

		while (!queue.isEmpty()) {
			Node cr = queue.poll();

			if (map[cr.r][cr.c] == 'a') {
				keyMap[cr.r][cr.c] = cr.step;
				crKeyFound++;

				if (crKeyFound == nKeys)
					break;
			}

			for (int i = 0; i < 4; i++) {
				int nR = cr.r + dx[i];
				int nC = cr.c + dy[i];

				if (isValidRow(nR) && isValidCol(nC) && !visit[nR][nC] && map[nR][nC] != 'X') {
					queue.add(new Node(nR, nC, cr.step + 1));
					visit[nR][nC] = true;
				}
			}
		}
	}

	private static boolean isValidCol(int nC) {
		return 1 <= nC && nC <= c;
	}

	private static boolean isValidRow(int nR) {
		return 1 <= nR && nR <= r;
	}

}
