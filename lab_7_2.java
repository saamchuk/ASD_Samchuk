package com.company;

public class lab_7_2 {
    static class Node {
        int value;
        String name;
        Node left;
        Node right;
        Node(int value, String name) {
            this.value = value;
            this.name = name;
            left = null;
            right = null;
        }
    }
    static Node add(Node current, int value, String name) {
        if (current == null) current = new Node(value, name);
        else {
            if (value < current.value) current.left = add(current.left, value, name);
            else if (value > current.value) current.right = add(current.right, value, name);
        }
        return current;
    }
    static void print (Node current) {
        if (current != null) {
            if (current.right != null) print(current.right);
            System.out.println(current.name + " - " + current.value);
            if (current.left != null) print(current.left);
        }
    }
    public static void main (String[] args) {
        Node list = new Node(1900, "Степан");
        add(list, 1200, "Марк");
        add(list, 2600, "Оксана");
        add(list, 900, "Анна");
        add(list,560, "Андрій");
        add(list, 6000, "Таня");
        print(list);
    }
}
