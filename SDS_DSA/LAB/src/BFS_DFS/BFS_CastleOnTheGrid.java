package BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author phamthi
 */
public class BFS_CastleOnTheGrid {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;//the size of the array grid
    static char[][] grid;

    private static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }

        }
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int goalX = sc.nextInt();
        int goalY = sc.nextInt();
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println(solve(grid, startX, startY, goalX, goalY));
    }

    private static int solve(char[][] grid, int startX, int startY, int goalX, int goalY) {
        if (startX == goalX && startY == goalY) {
            return 0;
        }
        int size = grid.length;
        int[][] step = new int[size][size];
        IntStream.range(0, size).forEach(x -> Arrays.fill(step[x], -1));
        step[startX][startY] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        while (true) {
            Point head = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nR = head.x;
                int nC = head.y;
                while (isValid(grid, nR + dx[i], nC + dy[i])) {
                    nR += dx[i];
                    nC += dy[i];
                    if (nR == goalX && nC == goalY) {
                        return step[head.x][head.y] + 1;
                    }
                    if (step[nR][nC] < 0) {
                        step[nR][nC] = step[head.x][head.y] + 1;
                        queue.offer(new Point(nR, nC));
                    }

                }
            }
        }
        //return 0;

    }

    private static boolean isValid(char[][] grid, int nC, int nR) {
        return nC >= 0 && nC < grid.length && nR >= 0 && nR < grid.length && grid[nC][nR] == '.';
    }
    
}
/**
STDIN       FUNCTION
-----       --------
3           grid[] size n = 3
.X.         grid = ['.X.','.X.', '...']
.X.
...
0 0 0 2     startX = 0, startY = 0, goalX = 0, goalY = 2
 */
// OUTPUT: 3

/**
 * Explanation
 * Here is a path that one could follow in order to reach the destination in  steps:
 * (0,0) -> (2,0) -> (2,2) -> (0,2)
 */
