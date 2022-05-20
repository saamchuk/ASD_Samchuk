package com.company;
import java.util.Scanner;

public class lab_8_2 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть розмір масиву: ");
        int n = in.nextInt();
        int[] mas = new int[n];
        System.out.println("1. Заповнити вручну.");
        System.out.println("2. Заповнити рандомно");
        int k = in.nextInt();
        if (k == 1) {
            addKeyboard(mas, n);
        }
        if (k == 2) {
            addRandom(mas, n);
        }
        System.out.println("Початковий масив: ");
        print(mas, n);
        System.out.println();
        System.out.println("1. Кількість ітерацій та утворений масив.");
        System.out.println("2. Результат кожної ітерації та підсумковий масив");
        k = in.nextInt();
        if (k == 1) {
            bubbleSortTotal(mas, n);
        }
        if (k == 2) {
            bubbleSortDetail(mas, n);
        }
    }
    static void addKeyboard (int[] mas, int n) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть " + n + " елементів масиву: ");
        for (int i = 0; i < n; i ++)
            mas[i] = in.nextInt();
    }
    static void addRandom (int[] mas, int n) {
        for (int i = 0; i < n; i ++)
            mas[i] = (int) (Math.random()*200-100);
    }
    static void print (int[] mas, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(mas[i] + "\t");
            if (i % 10 == 9) System.out.println();
        }
    }
    static void bubbleSortTotal (int[] mas, int n) {
        int number = 0;
        for (int i = 0; i + 1 < n; ++i) {
            for (int j = 0; j + 1 < n - i; ++j) {
                if (mas[j+1] < mas[j]) {
                    int k = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = k;
                    number++;
                }
            }
        }
        System.out.println("Кількість ітерацій: " + number);
        System.out.println("Підсумковий масив: ");
        print(mas, n);
        System.out.println();
    }
    static void bubbleSortDetail (int[] mas, int n) {
        for (int i = 0; i + 1 < n; ++i) {
            for (int j = 0; j + 1 < n - i; ++j) {
                if (mas[j+1] < mas[j]) {
                    int k = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = k;
                    System.out.println("Утворений масив: ");
                    print(mas, n);
                    System.out.println();
                    System.out.println();
                }
            }
        }
        System.out.println("Підсумковий масив: ");
        print(mas, n);
        System.out.println();
    }
}
