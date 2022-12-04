//package Backtrack;
//
//import java.util.Scanner;
//
///**
// * You are given a 0-indexed string pattern of length n consisting of the
// * characters 'I' meaning increasing and 'D' meaning decreasing.
// * 
// * A 0-indexed string num of length n + 1 is created using the following
// * conditions:
// * 
// * num consists of the digits '1' to '9', where each digit is used at most once.
// * If pattern[i] == 'I', then num[i] < num[i + 1]. If pattern[i] == 'D', then
// * num[i] > num[i + 1]. Return the lexicographically smallest possible string
// * num that meets the conditions.
// *
// */
//public class Smallest_Number_From_DI_String {
//	private static boolean[] check;
//	private static int[] a;
//	private static String s;
//	private static String res = "";
//
//	private static void gen(int idx, int n) {
//		if (res != "")
//			return;
//		if (idx > n) // điều kiện dừng
//		{
//
//			for (int i = 0; i < n; i++) {
//				if (s[i] == 'I') {
//					if (a[i + 1] < a[i])
//						return;
//				}
//				if (s[i] == 'D') {
//					if (a[i + 1] > a[i])
//						return;
//				}
//			}
//			for (int i = 0; i <= n; i++) {
//				res = res + (a[i]);
//			}
//			return;
//		}
//		for (int i = 1; i <= n + 1; i++) {
//			if (!check[i]) {
//				check[i] = true;
//				a[idx] = i;
//				gen(idx + 1, n);
//				check[i] = false;
//			}
//		}
//	}
//
//	private static String smallestNumber(String pattern) {
//		s = pattern;
//		for (int i = 1; i <= s.length() + 1; i++) {
//			a[0] = i;
//			check[i] = true;
//			gen(1, s.length());
//			check[i] = false;
//		}
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String pattern  = sc.nextLine();
//		smallestNumber(pattern);
//	}
//}
