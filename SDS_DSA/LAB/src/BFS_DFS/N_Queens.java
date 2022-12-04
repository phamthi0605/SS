package BFS_DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N_Queens {
	private static boolean[] check;
	private static int a[];
	private static List<List<String>> res;

	private static void gen(int idx, int n) {
		if (idx >= n) // điều kiện dừng
		{
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (Math.abs(i - j) == Math.abs(a[i] - a[j])) {
						return;
					}
				}
			}

			List<String> table = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String row = "";
				for (int j = 0; j < n; j++) {
					if (a[i] == j) {
						row = row + "Q";
					} else
						row = row + ".";
				}
				table.add(row);
				// cout << a[i] << " ";
			}
			res.add(table);
			return;
		}

	}

	private static List<List<String>> solveNQueens(int n) {
		gen(0, n);
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		res = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			res.add(new ArrayList<>());
		}
		check = new boolean[n + 1];
		solveNQueens(n);
	}
}
