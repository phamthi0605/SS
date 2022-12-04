package BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class FindAllPathsSourceTarget {
	private static List<List<Integer>> list;

	public static void main(String[] args) {
		int n = 0;
		//int[][] a = { { 1, 2 }, { 3 }, { 3 }, {} };
		int[][] a = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
		// a = new int[n + 1][n + 1];
	
		list = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		System.out.println(allPathsSourceTarget(a));
		
	}

	private static void find_path(int index, int graph[][], ArrayList<Integer> listChild) {
		listChild.add(index);
		// điều kiện dừng
		if (index == graph.length - 1) {
			list.add(new ArrayList<>(listChild));
			listChild.remove(listChild.size() - 1);
			return;
		}
		// backtrack
		for (int i : graph[index]) {
			find_path(i, graph, listChild);
		}
		listChild.remove(listChild.size() - 1);
	}

	private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		ArrayList<Integer> listChild = new ArrayList<>();
		find_path(0, graph, listChild);
		return list;
	}

}
/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
