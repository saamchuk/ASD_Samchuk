package com.company;
import java.util.Scanner;
public class lab_2 {
    public static void main (String[] args) {
        int N = size();
        int[] mas;
        mas = new int[N];
        for (int i = 0; i < N; i++) mas[i] = (int) (Math.random()*200-100);
        int n = input();
        while (n != 0){
            switch (n) {
                case 1:
                    OneNumber(N, mas);
                    break;
                case 2:
                    TwoNumber(N, mas);
                    break;
                case 3:
                    ThreeNumber();
                    break;
                case 4:
                    FourNumber(N);
                    break;
                case 5:
                    N = size();
                    break;
                case 6:
            }
            n = input();
        }
    }
    static int input () {
        Scanner in = new Scanner(System.in);
        System.out.println("\n0. Вихід з програми.");
        System.out.println("1. Обчислення в одновимірному масиві.");
        System.out.println("2. Перетворення матриці.");
        System.out.println("3. Повертання прямокутної матриці на 90 градусів.");
        System.out.println("4. Заповнення квадратної матриці.");
        System.out.println("5. Почати заново.");
        return in.nextInt();
    }
    static int size () {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть розмірність масиву: ");
        return in.nextInt();
    }
    static void OneNumber (int N, int[] mas) {
        for (int i = 0; i < N; i++) System.out.print(mas[i] + "\t");
        System.out.println("\nМодулі елементів з парними індексами: ");
        int sum = 0;
        for (int i = 0; i < N; i++){
            if (i % 2 == 0) System.out.print(i + " - " + Math.abs(mas[i]) + "\t");
            else sum += mas[i];
        }
        System.out.println("\nСума елементів між ними: " + sum);
    }
    static void TwoNumber (int N, int[] mas){
        System.out.println("Початковий масив: ");
        for (int i = 0; i < N; i++) System.out.print(mas[i] + "\t");
        int k;
        if (N % 2 == 0) k = N / 2;
        else k = (N/2) + 1;
        int[] arr;
        arr = new int[k];
        int l = 1;
        for (int i = 0; i < k; i++){
            arr[i] = mas[l];
            l += 2;
        }
        l = 0;
        System.out.println("\nЗмінений масив: ");
        for (int i = 0; i < N; i++) {
            if (i < k && i != 0) mas[i] = mas[2*i];
            else if ( i >= k) {
                mas [i] = arr[l];
                l++;
            }
            System.out.print(mas[i] + "\t");
        }
    }
    static void ThreeNumber () {
        int s = size();
        int m = size();
        int[][] temp;
        temp = new int[s][m];
        System.out.println("Початковий масив: ");
        for (int i = 0; i < s; i++) {
            for (int p = 0; p < m; p++) {
                temp[i][p] = (int) (Math.random()*200-100);
                System.out.print(temp[i][p] + "\t");
            }
            System.out.println();
        }
        System.out.println("\nЗмінений масив: ");
        for (int p = 0; p < m; p++) {
            for (int i = s - 1; i >= 0; i--) {
                System.out.print(temp[i][p] + "\t");
            }
            System.out.println();
        }
    }
    static void FourNumber (int N) {
        int[][] temp;
        temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int p = 0; p < N; p++) {
                if (i == p || i + p == N -1 || (i > p && i + p + 1 < N) || (i < p && i + p + 1 > N)) temp[i][p] = 1;
                else temp[i][p] = 0;
                System.out.print(temp[i][p]+"\t");
            }
            System.out.println();
        }
    }
}
