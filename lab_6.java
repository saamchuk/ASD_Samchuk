package com.company;

public class lab_6 {
    static Queue head;
    static class Queue {
        double data;
        Queue next;
    }

    static void add (double data) {
        Queue newObj = new Queue();
        newObj.data = data;
        newObj.next = null;
        if (head == null) {
            head = newObj;
        }
        else {
            Queue temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newObj;
        }
    }
    static void print() {
        Queue temp = head;
        while (temp.next != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
        System.out.print(temp.data + "\t");
        System.out.println();
    }
    static void del() {
        Queue temp = head;
        if (temp.next != null) {
            (head).data = temp.next.data;
            (head).next = temp.next.next;
        }
        else head = null;
    }
    public static void main(String[] args) {
        add(2.2);
        add(1.2);
        add(2);
        add(5.2);
        System.out.println("Після додавання в чергу 4 елементів: ");
        print();
        del();
        del();
        System.out.println("Після видалення 2 елементів: ");
        print();
        add(2.9);
        System.out.println("Після додавання в чергу 1 елементу: ");
        print();
    }
}
