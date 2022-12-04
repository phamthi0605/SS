package Backtrack;

/*
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * 
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 */

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Gender_Binary_Permute {

    private static int n;
    private static int[] a;
    private static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n + 1];
        check = new boolean[n + 1];
       gen_Binary(1);
       // gen_Permute(1);

    }
    // sinh nhị phân
    private static void gen_Binary(int index) {
        if (index > n) {
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("");
        } else {
            for (int i = 0; i <= 1; i++) {
                a[index] = i;
                gen_Binary(index + 1);
            }
        }

    }
    // sinh hoán vị
    private static void gen_Permute(int index) {
        if (index > n) {
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("");
        } else {
            for (int i = 1; i <= n; i++) {
                if (!check[i]) {
                    a[index] = i;
                    check[i] = true;
                    gen_Permute(index + 1);
                    check[i] = false;
                }
            }
        }

    }

}

