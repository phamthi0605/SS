package SingleLinkedList;

import java.util.*;

public class PrintSingleLinkedList {

    static class Node {

        public int data;
        public Node next;

        public Node(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {

        public Node head;
        public Node tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            Node node = new Node(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    // Complete the printLinkedList function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static void printLinkedList(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        printLinkedList(llist.head);

        scanner.close();
    }
}
