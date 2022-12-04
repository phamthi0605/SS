package Exam;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	static int tc, m, n, k;
	static LinkedList<Integer>[] lampLinkedLists;
	static int[] visited;
	static int result;
	static int a[];// state array light

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		tc = scanner.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = scanner.nextInt();
			m = scanner.nextInt();
			k = scanner.nextInt();
			result = Integer.MAX_VALUE;
			System.out.println();
			int x;
			// state array light
			a = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				x = scanner.nextInt();
				a[i] = x;
			}
			for (int i = 1; i <= n; i++) {
				System.out.print(a[i] + " ");
			}

			// read light
			lampLinkedLists = new LinkedList[m + 1];
			for (int j = 1; j <= m; j++) {
				lampLinkedLists[j] = new LinkedList<>();
				for (int s = 0; s < k; s++) {
					x = scanner.nextInt();
					lampLinkedLists[j].add(x);
				}

			}
			visited = new int[m + 1];
			System.out.println("Cac bong den bat duoc: ");
			for (int j = 1; j <= m; j++) {

				System.out.println(lampLinkedLists[j]);
			}
			System.out.println();

			// sinh to hop cac truong hop cac cong tac co the bat duoc den
			System.out.println("Cac truong hop: ");
			backtrack(1);
			result = result == Integer.MAX_VALUE ? -1 : result;

			System.out.println("# " + t+ " "+ result);
		}
	}

	private static void backtrack(int i) {
		// stop condition
		if (i > m) {
			System.out.println(Arrays.toString(visited));
			// step 1: clone array
			int[] a1 = Arrays.copyOf(a, a.length);
			int count = 0;
			for (int j = 1; j <= m; j++) {
				if (visited[j] == 0) {
					continue;
				} else {
					count++;
					for (Integer p : lampLinkedLists[j]) {
						if (a1[p] == 0) {
							a1[p] = 1;
						} else {
							a1[p] = 0;
						}
					}
				}
			}
			if (check(a1)) {
				if (result > count) {
					result = count;
				}
				// 
				
			}
			return;

		} else {
			// add
			visited[i] = 1;
			backtrack(i + 1);
			visited[i] = 0;
			// not add
			backtrack(i + 1);
		}

	}

	private static boolean check(int[] a1) {
	//	System.out.println(Arrays.toString(a1));
		for (int i = 1; i < a1.length; i++) {
			if (a1[i] != 1) {
				return false;
			}
		}
		return true;
	}
}
