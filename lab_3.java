package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class lab_3 {
    public static class Train {
        String name;
        int number;
        Calendar time;
        Train (String name, int number, int day, int month, int year, int time, int minute) {
            this.name = name;
            this.number = number;
            this.time = new GregorianCalendar(year, month, day, time, minute);
        }
    }
    static int numberTrainIn () {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть кількість потягів: ");
        return in.nextInt();
    }
    static Train inputInf () {
            Scanner in = new Scanner(System.in);
            System.out.print("Введіть назву пункту призначення: ");
            String name = in.nextLine();
            System.out.print("Введіть номер потягу: ");
            int number = in.nextInt();
            System.out.print("Введіть число дня, місяць та рік відправлення: ");
            int day = in.nextInt();
            int month = in.nextInt();
            --month;
            int year = in.nextInt();
            System.out.print("Введіть час відправлення: ");
            int time = in.nextInt();
            int minute = in.nextInt();
            return new Train(name, number, day, month, year, time, minute);
    }
    static Train sort (Train [] arr, int N, String nameSort, int numberSort, Calendar timeSort, int i){
            for (int j = i+1; j < N; j++){
                if ((arr[i].name.compareTo(arr[j].name))>0) {
                    nameSort = arr[i].name;
                    arr[i].name = arr[j].name;
                    arr[j].name = nameSort;
                    numberSort = arr[i].number;
                    arr[i].number = arr[j].number;
                    arr[j].number = numberSort;
                    timeSort = arr[i].time;
                    arr[i].time = arr[j].time;
                    arr[j].time = timeSort;
                }
            }
            return arr[i];
    }
    static void search (Train[] arr, int N) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть число дня, місяць та рік відправлення: ");
        int day = in.nextInt();
        int month = in.nextInt();
        --month;
        int year = in.nextInt();
        System.out.print("Введіть час відправлення: ");
        int time = in.nextInt();
        int minute = in.nextInt();
        Train date = new Train("", 0, day, month, year, time, minute);
        int k = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i].time.compareTo(date.time)>0) outPrint(i, arr);
            else ++k;
        }
        if (k == N) System.out.println("Таких рейсів немає.");
    }
    static int menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("0. Завершити.");
        System.out.println("1. Ввести дані.");
        System.out.println("2. Впорядкування за назвами пунктів призначення.");
        System.out.println("3. Вивести поїзди після певної дати та часу.");
        return in.nextInt();
    }
    static void outPrint(int i, Train[] arr){
        DateFormat firstDay = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat secondTime = new SimpleDateFormat("H:m");
        System.out.println(arr[i].name + "\t" + arr[i].number + "\t" + firstDay.format(arr[i].time.getTime())
                    + "\t" + secondTime.format(arr[i].time.getTime()));
    }

    public static void main (String[] args){
        int N = numberTrainIn();
        Train[] arr = new Train[N];
        for (int i = 0; i < N; i++)  arr[i] = inputInf();
        int n = menu();
        while (n != 0) {
            switch (n) {
                case 1 -> {
                    N = numberTrainIn();
                    inputInf();
                }
                case 2 -> {
                    String nameSort = "";
                    int numberSort = 0;
                    Calendar timeSort = new GregorianCalendar();
                    for (int i = 0; i < N; i++) {
                        arr[i] = sort(arr, N, nameSort, numberSort, timeSort, i);
                        outPrint(i, arr);
                    }
                }
                case 3 ->
                    search(arr, N);
            }
            n = menu();
        }
    }
}