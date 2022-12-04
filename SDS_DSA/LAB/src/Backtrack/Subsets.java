package Backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an integer array nums of unique elements, return all possible subsets
 * (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 *
 * Example 1: Input: nums = [1,2,3] Output:
 * [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * Example 2: Input: nums = [0] Output: [[],[0]]
 */

public class Subsets {
	static List<List<Integer>> output = new ArrayList();
	static int n;
	static int k;

	public static void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
		// if the combination is done
		if (curr.size() == k) {
			output.add(new ArrayList(curr));
			return;
		}
		for (int i = first; i < n; ++i) {
			// add i into the current combination
			curr.add(nums[i]);
			// use next integers to complete the combination
			backtrack(i + 1, curr, nums);
			// backtrack
			curr.remove(curr.size() - 1);
		}
	}

	static public List<List<Integer>> subsets(int[] nums) {
		n = nums.length;
		for (k = 0; k < n + 1; ++k) {
			backtrack(0, new ArrayList<Integer>(), nums);
		}
		return output;
	}
	public static void main(String[] args) {
		//int[]a = {1,2,3};
		int []a = {0};
		n =0;
		output = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			output.add(new ArrayList<>());
		}
		System.out.println(subsets(a));
	}
}
