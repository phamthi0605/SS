
/**
 * Function Description

Complete the function roadsAndLibraries in the editor below.
roadsAndLibraries has the following parameters:

int n: integer, the number of cities
int c_lib: integer, the cost to build a library
int c_road: integer, the cost to repair a road
int cities[m][2]: each cities[i] contains two integers that represent cities that can be connected by a new road
Returns
- int: the minimal cost

Input Format

The first line contains a single integer q, that denotes the number of queries.

The subsequent lines describe each query in the following format:
- The first line contains four space-separated integers that describe the respective values of n,m ,c_clib  and ,c_road the number of cities, number of roads, cost of a library and cost of a road.
- Each of the next m lines contains two space-separated integers,  and , that describe a bidirectional road that can be built to connect cities u[i] and v[i].

Sample Input
STDIN       Function
-----       --------
2           q = 2
3 3 2 1     n = 3, cities[] size m = 3, c_lib = 2, c_road = 1
1 2         cities = [[1, 2], [3, 1], [2, 3]]
3 1
2 3
6 6 2 5     n = 6, cities[] size m = 6, c_lib = 2, c_road = 5
1 3         cities = [[1, 3], [3, 4],...]
3 4
2 4
1 2
2 3
5 6

Sample Output
4
12
 */
package BFS_DFS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


/**
 *
 * @author admin
 */
public class Practice_2 {

    private static int testcase;
    static LinkedList<Integer>[] road;
    private static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int t = 0; t < testcase; t++) {
            int n = sc.nextInt();//n : number of nodes( city)
            int m = sc.nextInt();// m : number of edges(road)
            int c_lib = sc.nextInt();//cost library 
            int c_road = sc.nextInt();;// cost build road
            ArrayList<ArrayList<Integer>> cites = new ArrayList<>();
            //add node city
            for (int i = 1; i <= n; i++) {
                cites.add(new ArrayList<Integer>());
            }
            //add edge
            for (int j = 0; j < m; j++) {
                int u, v;// 2 nodes u and v
                u = sc.nextInt();
                u--;
                v = sc.nextInt();
                v--;
                // undirected graph (nên khai báo 2 chiều)
                cites.get(u).add(v);
                cites.get(v).add(u);
            }
            System.out.println(solve(n, m, c_lib, c_road, cites));
        }
    }


    private static long solve(int n, int m, int c_lib, int c_road, ArrayList<ArrayList<Integer>> cites) {
        //chi phí xây dựng thư viện nhỏ hơn chi phí xây đường
        if (c_lib < c_road) {
            return c_lib * n;
        }
        //total_cost = cost_lib+ n*cost_road
        int cost = 0;
        //dùng bfs
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {//visited các thành phố
            if (!visited[i]) {
                visited[i] = true;
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(i);//nếu các cities dc visited thì add vào queue
                long tempCost = c_lib;//chi phí xây dựng thư viện ở thành phố đầu tiên
                while (!queue.isEmpty()) {
                    int node = queue.poll();//lấy ra node đầu tiên
                    Iterator<Integer> item = cites.get(node).iterator();
                    while (item.hasNext()) {
                        // thực hiện duyệt các node mà liên thông với node item 
                        //đã được lấy ra
                        int next_node = item.next();
                        if (!visited[next_node]) {
                            visited[next_node] = true;
                            tempCost += c_road;
                        }
                    }
                }
                cost+= tempCost;
                //total_cost = cost_lib+ n*cost_road
            }

        }
        return cost;
    }
}
