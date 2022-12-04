package Backtrack;
/**
 * Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
 * Return a list of all possible strings we could create. Return the output in any order.
 * 
 * Example 1:
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * 
 * Example 2:
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 */
import java.util.ArrayList;
import java.util.List;

public class Letter_Case_Permutation {
	private static String s;
	private static List<String> res;

	public static void main(String[] args) {
		s = "a1b2";// s="3z4"
		res = new ArrayList<>();
		System.out.println(letterCasePermutation(s));
	}

	private static List<String> letterCasePermutation(String s) {
		// List<String> res = new ArrayList<>();
		gen(s, 0);
		return res;
	}

	private static void gen(String string, int start) {	
		res.add(string);
		for (int i = start; i < string.length(); i++) {
			char[] a = string.toCharArray();
			if (Character.isLetter(string.charAt(i))) {
				if (Character.isUpperCase(string.charAt(i))) {
					a[i] = Character.toLowerCase(string.charAt(i));
					gen(String.valueOf(a), i + 1);
				} else {
					a[i] = Character.toUpperCase(string.charAt(i));
					gen(String.valueOf(a), i + 1);
				}
			}
		}
	}

}
