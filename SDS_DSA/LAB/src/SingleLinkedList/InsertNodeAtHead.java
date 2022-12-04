/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleLinkedList;

import java.util.Scanner;

/**
 *
 * @author phamthi
 */
public class InsertNodeAtHead {

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

    }

    static void printLinkedList(Node head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }


    static Node insertNodeAtHead(Node llist, int data) {
        Node insert = new Node(data);
        insert.next = llist;
        llist = insert;
        return llist;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        int llistCount = scanner.nextInt();

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();

            Node llist_head = insertNodeAtHead(llist.head, llistItem);
          
            llist.head = llist_head;
        }
        System.out.println("-----------------");
        printLinkedList(llist.head);

        scanner.close();
    }
}
