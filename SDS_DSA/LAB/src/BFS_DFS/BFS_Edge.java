package BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BFS_Edge {

    private static int n;
    private static Integer[] prev;
    private static List<List<Edge>> graph;

    private static class Edge {

        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

    }

    private static void createEmptyGraph(int n) {
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
    }
    //add an dirrected edge between nodes u and v

    //add an undirected edge between nodes 'u' and 'v'
    public static void addUndirectedEdge(int u, int v, int cost) {
        graph.get(u).add(new Edge(u, v, cost));
        graph.get(v).add(new Edge(v, u, cost));
    }

    //perform a BFS on a graph a starting node start
    private static void BFS(int start) {
        prev = new Integer[n];
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();

        //start by visiting the 'start' node add it to queue
        queue.add(start);
        visited[start] = true;

        //continue until the BFS is done
        while (!queue.isEmpty()) {
            int node = queue.poll();//head
            List<Edge> edges = graph.get(node);
            System.out.print(node + ", ");
            for (Edge edge : edges) {
                if (!visited[edge.to]) {
                    visited[edge.to] = true;
                    prev[edge.to] = node;
                    queue.offer(edge.to);
                }
            }

        }

    }

    public static void main(String[] args) {
        n = 13;
        createEmptyGraph(n);

        addUndirectedEdge(0, 7, 1);
        addUndirectedEdge(0, 9, 1);
        addUndirectedEdge(0, 11, 1);

        addUndirectedEdge(7, 11, 1);
        addUndirectedEdge(7, 6, 1);
        addUndirectedEdge(7, 3, 1);

        addUndirectedEdge(6, 5, 1);

        addUndirectedEdge(3, 4, 1);

        addUndirectedEdge(2, 3, 1);
        addUndirectedEdge(2, 12, 1);

        addUndirectedEdge(12, 8, 1);

        addUndirectedEdge(8, 1, 1);

        addUndirectedEdge(1, 10, 1);

        addUndirectedEdge(10, 9, 1);
        
        int start = 10, end = 5;
        BFS(start);

        //print path graph from -to
        List<Integer> path = new ArrayList<>();
        for (Integer at = end; at != null; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        if (path.get(0) == start) {
            System.out.println("\n"+path.toString());
        }

    }
}