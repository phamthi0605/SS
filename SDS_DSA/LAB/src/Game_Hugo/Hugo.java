package Game_Hugo;

import java.io.*;
import java.util.*;

public class Hugo {

	// For calcuate fire
	private static class FireNode {
		int r;
		int c;
		int time;

		public FireNode(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public String toString() {
			return "(" + r + ", " + c + ", " + time + ")";
		}

	}

	static int n, m, sr, sc;
	static int[][] map;
	static boolean[][] lakes;
	static boolean[][] exits;
	static int[][] fireMap;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int step;
	static int maxValue;
	static int crDiamond;
	static boolean[][] visit;

	static LinkedList<FireNode> queue;

	public static void main(String[] args) throws IOException {
		// Read input by BufferReader is fastest, this method MUST be use when do Pro
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input_hugo.txt")));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= tc; t++) {
			// Read input
			readInput(br, st);

			// BFS for calculate fire map
			BFS();

			// Reset value for each testcase
			init();

			BT(sr, sc);

			System.out.println("Case #" + t);
			System.out.println(maxValue);
		}
	}

	private static void BT(int sr, int sc) {

		// Update value
		step++;
		crDiamond += map[sr][sc];
		visit[sr][sc] = true;

		// Stop condition
		if (exits[sr][sc]) {
			if (crDiamond > maxValue) {
				maxValue = crDiamond;
			}
		}

		// Save time -- find max --> can not save

		// All available case hugo can move
		// 1. Can move through water
		// 2. Can move if fire is not on next cell
		// ...
		for (int i = 0; i < 4; i++) {
			int nR = sr + dx[i];
			int nC = sc + dy[i];

			if (isValidRow(nR) && isValidCol(nC) && visit[nR][nC] == false) {
				// Note that a cell can be around by all lakes
				if (step + 1 < fireMap[nR][nC] || lakes[nR][nC] == true || fireMap[nR][nC] == 0) {
					// If next step is lake
					if (lakes[nR][nC]) {
						step = step + 1;
					}

					BT(nR, nC);

					// Back track
					if (lakes[nR][nC]) {
						step = step - 1;
					}
				}
			}
		}

		// Backtrack
		step--;
		crDiamond -= map[sr][sc];
		visit[sr][sc] = false;

	}

	private static void BFS() {
		boolean[][] visit = new boolean[n + 1][m + 1];

		while (!queue.isEmpty()) {
			FireNode cr = queue.poll();
			visit[cr.r][cr.c] = true;
			fireMap[cr.r][cr.c] = cr.time;
			// 4 directions
			for (int i = 0; i < 4; i++) {
				int nR = cr.r + dx[i];
				int nC = cr.c + dy[i];

				if (isValidRow(nR) && isValidCol(nC) && visit[nR][nC] == false && lakes[nR][nC] == false) {
					visit[nR][nC] = true;
					queue.add(new FireNode(nR, nC, cr.time + 1));
				}
			}
		}
	}

	private static boolean isValidCol(int c) {
		return 1 <= c && c <= m;
	}

	private static boolean isValidRow(int r) {
		return 1 <= r && r <= n;
	}

	private static void init() {
		step = 0;
		crDiamond = 0;
		maxValue = -1;
		visit = new boolean[n + 1][m + 1];
	}

	private static void readInput(BufferedReader br, StringTokenizer st) throws IOException {

		// Line 1
		st = new StringTokenizer(br.readLine());
		// n,m,sr,sc
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sr = Integer.parseInt(st.nextToken());
		sc = Integer.parseInt(st.nextToken());

		// Init map depend on n, m
		// Array index start from 1
		map = new int[n + 1][m + 1];
		fireMap = new int[n + 1][m + 1];
		lakes = new boolean[n + 1][m + 1];
		exits = new boolean[n + 1][m + 1];

		// Line 2 -- read fire then push to queue for BFS
		st = new StringTokenizer(br.readLine());
		int f = Integer.parseInt(st.nextToken()); // number of fire
		queue = new LinkedList<>();

		for (int i = 0; i < f; i++) {
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			FireNode node = new FireNode(r, c, 1);
			queue.add(node);
		}

		// Line 3 -- read lakes
		st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		for (int i = 0; i < l; i++) {
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			lakes[r][c] = true;
			fireMap[r][c] = Integer.MAX_VALUE; // fire can not go lake
		}

		// Line 4 -- read exits
		st = new StringTokenizer(br.readLine());
		int e = Integer.parseInt(st.nextToken());
		for (int i = 0; i < e; i++) {
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			exits[r][c] = true;
		}

		// other - read diamond value
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				int d = Integer.parseInt(st.nextToken());
				map[i][j] = d;
			}
		}

	}

}
