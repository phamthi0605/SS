package Backtrack;

import java.util.Scanner;

public class Maximum_Compatibility_Score_Sum {
	private static int[][] point;


	private static int result = 0;
	private static boolean[] check;

	public static int maxCompatibilitySum(int[][] students, int[][] mentors) {  
		int[] studentSurveys = new int[students.length];
    int[] mentorSurveys = new int[mentors.length];
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < mentors.length; j++) {
				point[i][j] = 0;
				for (int t = 0; t < students[i].length; t++) {
					if (students[i][t] == mentors[j][t]) {
						point[i][j]++;
					}
				}
			}
		}
		backtrack(0, students.length, 0);
		return result;
	}

	private static void backtrack(int idx, int n, int sum) {
		if (idx >= n) {
			result = Math.max(result, sum);
			// N^2
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				backtrack(idx + 1, n, sum + point[idx][i]);
				check[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int m = sc.nextInt();
		int n = 0;
		int[][] student = { {0,0}, { 0,0}, { 0,0} };
		int[][] mentors = {{1,1},{1,1},{1,1}};
		
		check = new boolean[n+1];
		point = new int[n+1][n+1];
		System.out.println(maxCompatibilitySum(student, mentors));
	}
}
