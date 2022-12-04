/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * 
 */
package Backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Generate_Parentheses {

    private static int[] a;
    private static List<String> ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ans = new ArrayList<>();
        a = new int[2*n];
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        gen( 0, 0, 0, n);
        return ans;
    }

    private static void gen( int idx, int op, int cl, int n) {
        // 0 = (
        // 1 = )
        if (idx >= 2 * n) {
            if (op == cl) {
                String s = "";
                for (int i = 0; i < 2 * n; i++) {
                    if (a[i] == 0) {
                        s = s + "(";
                    } else {
                        s = s + ")";
                    }
                }
                ans.add(s);
            }

        }
        if (op < n) {
            a[idx] = 0;
            gen( idx + 1, op + 1, cl, n);
        }
        if (cl < n && cl + 1 <= op) {
            a[idx] = 1;
            gen(idx + 1, op, cl + 1, n);
        }

    }
}
