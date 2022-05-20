package com.company;
import java.util.Scanner;
public class lab_8_1 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть розмір першого масиву: ");
        int n = in.nextInt();
        int[] mas = new int[n];
        System.out.print("Введіть розмір другого масиву: ");
        int l = in.nextInt();
        int[] arr = new int[l];
        System.out.println("1. Заповнити вручну.");
        System.out.println("2. Заповнити рандомно");
        int k = in.nextInt();
        if (k == 1) {
            addKeyboard(mas, n);
            addKeyboard(arr, l);
        }
        if (k == 2) {
            addRandom(mas, n);
            addRandom(arr, l);
        }
        System.out.println("Утворений перший масив: ");
        print(mas, n);
        System.out.println();
        System.out.println("Утворений другий масив: ");
        print(arr, l);
        System.out.println();
        find(mas, n, arr, l);
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
    static void find (int[] mas, int n, int[] arr, int l) {
        int[] search1 = new int[n];
        int[] search2 = new int[l];
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть шуканий елемент: ");
        int key = in.nextInt();
        int h1 = 0;
        int h2 = 0;
        for(int i = 0; i < n; i++) {
            if (mas[i] == key) {
                search1[h1] = i;
                h1++;
            }
        }
        for(int i = 0; i < l; i++) {
            if (arr[i] == key) {
                search2[h2] = i;
                h2++;
            }
        }
        if ((h1 + h2) > 1) {
            if (h1 != 0) {
                System.out.println("В першому масиві значення " + key + " займає: ");
                for (int i = 0; i < h1; i++) {
                    System.out.print(search1[i] + "\t");
                }
            }
            System.out.println();
            if (h2 != 0) {
                System.out.println("В другому масиві значення " + key + " займає: ");
                for (int i = 0; i < h2; i++) {
                    System.out.print(search2[i] + "\t");
                }
            }
        }
        else if ((h1 + h2) == 1) System.out.println("Знайдено лише в єдиному екземплярі.");
        else System.out.println("Не знайдено.");
    }
}
