package BFS_DFS;
import java.util.LinkedList;
import java.util.Stack;

public class BFS_DFS_Node {
	 static LinkedList<Node>[] link = new LinkedList[13];

	    private static class Node {

	        int x;
	        int w;

	        public Node(int x, int w) {
	            this.x = x;
	            this.w = w;
	        }

	        @Override
	        public String toString() {
	            return "(" + x + ", " + w + ")";
	        }

	    }

	    private static void DFS(int s) {
	        Stack<Integer> stack = new Stack<>();
	        boolean visit[] = new boolean[13];

	        //init
	        stack.add(s, 0);

	        visit[s] = true;

	        while (!stack.isEmpty()) {
	            int cr = stack.pop();//get top element
	            System.out.print(cr + ", ");

	            for (Node n : link[cr]) {
	                if (!visit[n.x]) {
	                    stack.add(n.x);
	                    visit[n.x] = true;
	                }
	            }

	        }
	    }

	    private static void BFS(int start) {
	        LinkedList<Integer> queue = new LinkedList<>();
	        boolean visit[] = new boolean[13];

	        //start by visiting the 'start' node and add it to the queue
	        queue.add(start, 0);
	        visit[start] = true;

	        //continue until the BFS is done
	        while (!queue.isEmpty()) {
	            int node = queue.poll();//head
	            System.out.print(node + ", ");
	            for (Node n : link[node]) {
	                if (!visit[n.x]) {
	                    queue.add(n.x);
	                    visit[n.x] = true;
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	        for (int i = 0; i < 13; i++) {
	            link[i] = new LinkedList<>();
	        }

	        link[0].add(new Node(7, 1));
	        link[0].add(new Node(9, 1));
	        link[0].add(new Node(11, 1));

	        link[1].add(new Node(8, 1));
	        link[1].add(new Node(10, 1));

	        link[2].add(new Node(3, 1));
	        link[2].add(new Node(12, 1));

	        link[3].add(new Node(7, 1));
	        link[3].add(new Node(2, 1));
	        link[3].add(new Node(4, 1));

	        link[4].add(new Node(3, 1));

	        link[5].add(new Node(6, 1));

	        link[6].add(new Node(5, 1));
	        link[6].add(new Node(7, 1));

	        link[7].add(new Node(0, 1));
	        link[7].add(new Node(3, 1));
	        link[7].add(new Node(6, 1));
	        link[7].add(new Node(11, 1));

	        link[8].add(new Node(1, 1));
	        link[8].add(new Node(9, 1));
	        link[8].add(new Node(12, 1));

	        link[9].add(new Node(8, 1));
	        link[9].add(new Node(0, 1));
	        link[9].add(new Node(10, 1));

	        link[10].add(new Node(1, 1));
	        link[10].add(new Node(9, 1));

	        link[11].add(new Node(0, 1));
	        link[11].add(new Node(7, 1));

	        link[12].add(new Node(2, 1));
	        link[12].add(new Node(8, 1));


	        DFS(0);
	        System.out.println("\nBFS: ");
	        BFS(0);
	    }
}
