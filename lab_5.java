package com.company;

public class lab_5 {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node prev;
    }
    static void addNode(int value) {
        if (head == null) {
            Node newNode = new Node();
            newNode.data = value;
            newNode.next = newNode.prev = newNode;
            head = newNode;
        }
        else {
            Node last = (head).prev;
            Node new_node = new Node();
            new_node.data = value;
            new_node.next = head;
            (head).prev = new_node;
            new_node.prev = last;
            last.next = new_node;
        }
    }
    static void changePosition () {
        Node temp;
        int i = 0;
        for (temp = head; temp.next != head; temp = temp.next) {
            if ((i % 2) == 0) {
                Node last = (head).prev;
                Node change = new Node();
                change.data = temp.data;
                change.next = head;
                (head).prev = change;
                change.prev = last;
                last.next = change;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                temp = temp.next;
            }
            if (i == 0) {
                head = temp;
            }
            i += 2;
        }
    }
    static void printNodes() {
        Node temp = head;
        while (temp.next != head) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("%d ", temp.data);
        System.out.println();
    }
    public static void main(String[] args) {
        addNode(10);
        addNode(20);
        addNode(30);
        addNode(40);
        addNode(50);
        addNode(60);
        addNode(70);
        addNode(80);
        addNode(90);
        addNode(100);
        addNode(110);
        System.out.print("Початковий список: ");
        printNodes();
        System.out.println("Покажчик на перший елемент становить: " + (head.data));
        changePosition();
        System.out.print("Змінений список: ");
        printNodes();
        System.out.println("Покажчик на перший елемент становить: " + (head.data));
    }
}
