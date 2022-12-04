package Game_Mario;


import java.io.*;
import java.util.*;

public class Mario {
	static int n;
	static int crMap[][];

	static int bomb5, bomb2, bomb1; // 3 type of bombs
	static int coins, oldCoins;
	static int maxCoins;

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner sc = new Scanner(new File("mario_input.txt"));
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {

			readInput(sc);

			init();

			BT(0);

			System.out.println("Case #" + t + ": " + maxCoins);

		}
	}

	private static void BT(int i) {

		// Stop condition -- pass all gates
		if (i == n) {
			if (coins > maxCoins) {
				maxCoins = coins;
			}
			return;
		}

		// Save time -- find max --> can not save

		// Check all available cases

		// Don't have Pakkun
		if (crMap[i][0] == 0) {

			int oldBomb1 = bomb1;
			int oldBomb2 = bomb2;
			int oldBomb5 = bomb5;

			coins += crMap[i][2];
			System.out.println(coins);
			bomb1 = bomb2;
			bomb2 = bomb5;
			bomb5 = crMap[i][3];

			BT(i + 1);

			// This is backtrack
			bomb1 = oldBomb1;
			bomb2 = oldBomb2;
			bomb5 = oldBomb5;
			coins -= crMap[i][2];

		} 
		else {
			// Have Pakkun - 3 actions can be considered

			// Throw bombs - note that if it is, coins + bombs after gate is zero
			if (bomb1 + 2 * bomb2 + 5 * bomb5 >= crMap[i][1]) {
				int oldBomb1 = bomb1;
				int oldBomb2 = bomb2;
				int oldBomb5 = bomb5;
				
				// Priority use bomb1 > bomb2 > bomb5
				// Example we have: 10 bomb1, 2 bomb2, 1 bomb5
				// Case 1: petals = 5 --> we have left: 2 bomb1, 1 bomb2, 0 bomb5
				// Case 2: petals = 11 --> we have left : 1 bomb1, 1 bomb2, 0 bomb5
				// Case 3: petals = 14 --> we have left : 0 bomb1, 1 bomb2, 0 bomb5
				// Case 4: petals = 16--19 --> we have left : 0 bomb1, 0 bomb2, 0 bomb5
				if (bomb1 >= crMap[i][1]) {
					bomb1 = bomb2;
					bomb2 = bomb5;
					bomb5 = 0;
				} else {
					if (bomb1 + 2 * bomb2 >= crMap[i][1]) {
						bomb1 = (crMap[i][1] - bomb1) % 2 == 0 ? bomb2 - (crMap[i][1] - bomb1) / 2
								: bomb2 - (crMap[i][1] - bomb1) / 2 - 1;
						bomb2 = bomb5;
						bomb5 = 0;
					} else {
						bomb5 = (crMap[i][1] - bomb1 - 2 * bomb2) % 5 == 0
								? bomb5 - (crMap[i][1] - bomb1 - 2 * bomb2) / 5
								: bomb5 - (crMap[i][1] - bomb1 - 2 * bomb2) / 5 - 1;
						bomb1 = bomb2;
						bomb2 = bomb5;
						bomb5 = 0;
					}
				}

				BT(i + 1);

				bomb1 = oldBomb1;
				bomb2 = oldBomb2;
				bomb5 = oldBomb5;
			}

			// Pay money to pakkun
			if (coins >= crMap[i][1]) {
				int oldBomb1 = bomb1;
				int oldBomb2 = bomb2;
				int oldBomb5 = bomb5;
				coins = coins - crMap[i][1] + crMap[i][2];
				bomb1 = bomb2;
				bomb2 = bomb5;
				bomb5 = crMap[i][3];

				BT(i + 1);

				coins = coins + crMap[i][1] - crMap[i][2];

				bomb1 = oldBomb1;
				bomb2 = oldBomb2;
				bomb5 = oldBomb5;
			}

			// Do not pay anything, bombs > 0
			if (bomb1 + bomb2 + bomb5 > 0) {
				int oldBomb1 = bomb1;
				int oldBomb2 = bomb2;
				int oldBomb5 = bomb5;
				bomb1 = bomb2 = 0;
				bomb5 = crMap[i][3];
				coins = coins + crMap[i][2];
				BT(i + 1);
				bomb1 = oldBomb1;
				bomb2 = oldBomb2;
				bomb5 = oldBomb5;
				coins = coins - crMap[i][2];
			}
		}

	}

	// Reset for each testcase
	private static void init() {
		coins = bomb5 = bomb2 = bomb1 = 0;
		maxCoins = -1;
	}

	private static void readInput(Scanner sc) {
		n = sc.nextInt();
		crMap = new int[n][4];

		int x = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 4; j++) {
				x = sc.nextInt();

				crMap[i][j] = x;
			}
		}
	}

}
