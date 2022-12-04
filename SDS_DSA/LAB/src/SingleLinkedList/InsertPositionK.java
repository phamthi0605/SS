package SingleLinkedList;

import java.io.*;
import java.util.*;

public class InsertPositionK {

    private static final Scanner scanner = new Scanner(System.in);

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

    static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static Node insertNodeAtPosition(Node head, int data, int position) {
        Node node = new Node(data);
        if (head == null) {
            return node;
        }

        if (position == 0) {
            node.next = head;
            return node;
        }

        Node curr = head;

        for (int i = 0; i < position - 1 && curr.next != null; i++) {
            curr = curr.next;
        }

        node.next = curr.next;
        curr.next = node;

        return head;

    }

    static Node deleteNode(Node head, int position) {
        Node node = head;
        if (position == 0) {
            return node.next;
        }
        while (--position > 0) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;

    }

    static void reversePrint(Node head) {
        Node node = head;
        StringBuilder s = new StringBuilder();
        while (node != null) {
            s.insert(0, Integer.toString(node.data) + '\n');
            node = node.next;
        }
        System.out.print(s);
    }

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();
        int llistCount = scanner.nextInt();

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            llist.insertNode(llistItem);
        }

        // int data = scanner.nextInt();
        //  int position = scanner.nextInt();
        //Node llist_head = insertNodeAtPosition(llist.head, data, position);
        //Node llist_head = deleteNode(llist.head, position);
        System.out.println("---------------------");
        reversePrint(llist.head);
        //  printLinkedList(llist_head);

        scanner.close();
    }
}
/**
 * Function Description Complete the function insertNodeAtPosition in the editor
 * below. It must return a reference to the head node of your finished list.
 *
 * insertNodeAtPosition has the following parameters:
 *
 * head: a SinglyLinkedListNode pointer to the head of the list data: an integer
 * value to insert as data in your new node position: an integer position to
 * insert the new node, zero based indexing
 *
 * Returns: SinglyLinkedListNode pointer: a reference to the head of the revised
 * list
 */
