package Backtrack;

import java.util.Scanner;

/**
 * Given an array of strings nums containing n unique binary strings each of
 * length n. Return a binary string of length n that does not appear in nums. If
 * there are multiple answers, you may return any of them.
 *
 * Example 1: Input: nums = ["01","10"] Output: "11" Explanation: "11" does not
 * appear in nums. "00" would also be correct.
 *
 * Example 2: Input: nums = ["00","01"] Output: "11" Explanation: "11" does not
 * appear in nums. "10" would also be correct.
 */

public class Find_Unique_Binary_String {
	private static int n;
	private static int []a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt();
		a = new int[n+1];
		 int[] b = {01,10};
		 gen_Binary(1,b);
	}
    private static void gen_Binary(int index, int[]b) {
    	
        if (index > n) {
            for (int i = 1; i <= n; i++) {
                //
            	for (int j = 1; j <=n; j++) {
					if(a[i]==b[j]) {
						return;
					}
					System.out.print(a[i] + " ");
				}
            }
            System.out.println("");
        } else {
            for (int i = 0; i <= 1; i++) {
                a[index] = i;
                gen_Binary(index + 1,b);
            }
        }

    }
	
}
