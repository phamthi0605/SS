package Backtrack;

import java.util.Scanner;

public class TheMerchants {
	static int rMax, cMax, sR, sC, d, iQty;
	static int[][] products, price;
	static int max;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int crProfit;
	static int crQty;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			rMax = sc.nextInt();
			cMax = sc.nextInt();
			sR = sc.nextInt();
			sC = sc.nextInt();
			d = sc.nextInt();
			iQty = sc.nextInt();

			products = new int[rMax + 1][cMax + 1];
			price = new int[rMax + 1][cMax + 1];

			for (int i = 1; i <= rMax; i++) {
				for (int j = 1; j <= cMax; j++) {
					products[i][j] = sc.nextInt();
				}
			}

			for (int i = 1; i <= rMax; i++) {
				for (int j = 1; j <= cMax; j++) {
					price[i][j] = sc.nextInt();
				}
			}

			max = Integer.MIN_VALUE;
			crProfit = 0;
			crQty = iQty;
			BT(sR, sC, 0);
			System.out.println("#" + t + " " + max);

		}
	}

	private static void BT(int r, int c, int day) {

		// Stop condition
		if (day == d) {
			max = crProfit > max ? crProfit : max;
			return;
		}

		// Travel case
		for (int i = 0; i < 4; i++) {
			int nR = r + dx[i];
			int nC = c + dy[i];

			if (isValidRow(nR) && isValidCol(nC)) {
				BT(nR, nC, day + 1);
			}
		}

		// Produce case
		int oldProduct = products[r][c];
		int oldQty = crQty;
		crQty += products[r][c];
		products[r][c] = products[r][c] / 2;
		BT(r, c, day + 1);
		products[r][c] = oldProduct;
		crQty = oldQty;

		// Trade case
		int oldPrice = price[r][c];
		int oldQty1 = crQty;
		int oldProfit = crProfit;
		crProfit += crQty * price[r][c];
		crQty = 0;
		price[r][c] = price[r][c] - 1;
		BT(r, c, day + 1);
		price[r][c] = oldPrice;
		crQty = oldQty1;
		crProfit = oldProfit;

	}

	private static boolean isValidCol(int nC) {
		return 1 <= nC && nC <= cMax;
	}

	private static boolean isValidRow(int nR) {
		return 1 <= nR && nR <= rMax;
	}
}
