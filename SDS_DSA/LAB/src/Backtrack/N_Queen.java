package Backtrack;

import java.util.Scanner;
import java.util.LinkedList;

public class N_Queen {
	static int test, n;
	static boolean[] check; // danh dau column da dat Queen
	static int[] a; // danh dau vi tri row dat Queen
	static LinkedList<LinkedList<String>> response;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			n = sc.nextInt();
			check = new boolean[n];
			a = new int[n];
			response = new LinkedList<>();
			gen(0, n);
			System.out.println(response);
		}
	}

	static void gen(int idx, int n) {
		if (idx == n) {
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (Math.abs(i - j) == Math.abs(a[i] - a[j])) {
						return;
					}
				}
			}
			LinkedList<String> table = new LinkedList<String>();
			for (int i = 0; i < n; i++) {
				String row = "";
				for (int j = 0; j < n; j++) {
					if (a[i] == j) {
						row += "Q";
					} else {
						row += ".";
					}
				}
				table.add(row);
			}
			response.add(table);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				a[idx] = i;
				gen(idx + 1, n);
				check[i] = false;
			}
		}
	}
}
