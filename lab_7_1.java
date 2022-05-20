package com.company;
public class lab_7_1 {
    static int t = 0;
    static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    static Node add(Node current, int value) {
        if (current == null) current = new Node(value);
        else {
            if (value < current.value) current.left = add(current.left, value);
            else if (value > current.value) current.right = add(current.right, value);
        }
        return current;
    }
    static void find(Node current, int value) {
        if (current == null) System.out.println("Не знайдено.");
        else if (current.value == value) System.out.println("Знайдено елемент: " + current.value);
        else if (current.left != null) find(current.left, value);
        else find(current.right, value);
    }
    static void round (Node current) {
        if (current != null) {
            System.out.println(current.value);
            round(current.left);
            round(current.right);
        }
    }
    static boolean equal (Node first, Node second) {
        if (first.value != second.value || first.left == null && second.left != null ||
                first.left != null && second.left == null || first.right == null && second.right != null ||
                first.right != null && second.right == null) {
            return false;
        }
        if (first.left == null && first.right == null){
            return true;
        }
        if (first.left == null){
            return (equal(first.right, second.right));
        }
        if (first.right == null){
            return (equal(first.left, second.left));
        }
        if ((equal(first.left, second.left)) && (equal(first.right, second.right))){
            System.out.println("Pівні.");
        }
        else System.out.println("Не рівні.");
        return false;
    }
    static void print (Node current) {
        if (current != null) {
            t += 5;
            if (current.right != null) print(current.right);
            for (int i = 0; i < t; i++) System.out.print(" ");
            System.out.println(current.value);
            if (current.left != null) print(current.left);
            t -= 5;
        }
    }
    public static void main (String[] args) {
        Node tree = new Node(2);
        add(tree, 10);
        add(tree, 8);
        add(tree, 3);
        add(tree, 0);
        add(tree, -5);
        add(tree, -2);
        System.out.println("Утворене дерево:");
        print(tree);
        System.out.println();
        System.out.println("Пошук елемента, якого немає в дереві: ");
        find(tree, 5);
        System.out.println("Пошук елемента, який є в дереві: ");
        find(tree, 3);
        System.out.println("Обхід дерева: ");
        round(tree);
        Node tree1 = new Node(2);
        add(tree1, 10);
        add(tree1, 8);
        add(tree1, 3);
        add(tree1, 0);
        add(tree1, -5);
        add(tree1, -2);
        System.out.println("Порівняння двух дерев: ");
        equal(tree, tree1);
    }
}