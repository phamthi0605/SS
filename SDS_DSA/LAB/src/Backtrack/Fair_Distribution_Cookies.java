package Backtrack;

/**
 * You are given an integer array cookies, where cookies[i] denotes the number
 * of cookies in the ith bag. You are also given an integer k that denotes the
 * number of children to distribute all the bags of cookies to. All the cookies
 * in the same bag must go to the same child and cannot be split up. The
 * unfairness of a distribution is defined as the maximum total cookies obtained
 * by a single child in the distribution. Return the minimum unfairness of all
 * distributions.
 * 
 * 
 */
public class Fair_Distribution_Cookies {
	static int[] d = new int[8];
	static int[] bags;
	static int min_unfairness = 1000000, n, c = 0;

	static void back_track(int idx, int max_sum, int k) {
		c++;
		if (max_sum >= min_unfairness) {
			return;
		}
		if (idx >= n) {
			if (max_sum < min_unfairness)
				min_unfairness = max_sum;
			return;
		}
		for (int i = 0; i < k; i++) {
			d[i] += bags[idx];
			back_track(idx + 1, Math.max(max_sum, d[i]), k);
			d[i] -= bags[idx];
		}
	}

	static int distributeCookies(int[] cookies, int k) {
		bags = cookies;
		n = cookies.length;

		min_unfairness = 0;
		for (int i = k - 1; i < cookies.length; i++) {
			min_unfairness += cookies[i];
		}
		for (int i = 0; i < k - 1; i++) {
			min_unfairness = Math.max(min_unfairness, cookies[i]);
		}
		back_track(0, 0, k);
		return min_unfairness;
	}

	public static void main(String[] args) {
		int[] cookies = { 8, 15, 10, 20, 8 };

		int k = 2;
		System.out.println(distributeCookies(cookies, k));
	}
}
/**
 * Input: cookies = [8,15,10,20,8], k = 2 
 * Output: 31 
 * Explanation: One optimal distribution is [8,15,8] and [10,20]
 * The 1st child receives [8,15,8] which has a total of 8 + 15 + 8 = 31 cookies.
 * The 2nd child receives [10,20] which has a total of 10 + 20 = 30 cookies.
 * The unfairness of the distribution is max(31,30) = 31.
 * It can be shown that there is no distribution with an unfairness less than 31.
 */
