package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class lab_4 {
    static ArrayList <String> first = new ArrayList<String>();
    static ArrayList <String> second = new ArrayList<String>();
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int n = menu();
        int G;
        while (n != 0) {
            switch (n) {
                case 1 -> {
                    G = menuGroup();
                    while (G != 0) {
                        switch (G) {
                            case 1 -> {
                                System.out.print("Введіть кількість студентів: ");
                                int s = in.nextInt();
                                System.out.println("Прізвища:");
                                for (int i = 0; i <= s; i++) {
                                    first.add(in.nextLine());
                                }
                            }
                            case 2 -> {
                                System.out.print("Введіть прізвище: ");
                                first.remove(in.nextLine());
                            }
                            case 3 -> {
                                System.out.println("Введіть номер: ");
                                int number = in.nextInt();
                                System.out.println(first.get(number));
                            }
                            case 4 -> {
                                Object[] firstGroup = first.toArray();
                                for (Object person : firstGroup) {
                                    System.out.print(person + "\t");
                                }
                                System.out.println();
                            }
                        }
                        G = menuGroup();
                    }
                }
                case 2 -> {
                    G = menuGroup();
                    while (G != 0) {
                        switch (G) {
                            case 1 -> {
                                System.out.print("Введіть кількість студентів: ");
                                int s = in.nextInt();
                                System.out.println("Прізвища:");
                                for (int i = 0; i <= s; i++) {
                                    second.add(in.nextLine());
                                }
                            }
                            case 2 -> {
                                System.out.print("Введіть прізвище: ");
                                second.remove(in.nextLine());
                            }
                            case 3 -> {
                                System.out.println("Введіть номер: ");
                                int number = in.nextInt();
                                System.out.println(second.get(number));
                            }
                            case 4 -> {
                                Object[] secondGroup = second.toArray();
                                for (Object person : secondGroup) {
                                    System.out.print(person + "\t");
                                }
                                System.out.println();
                            }
                        }
                        G = menuGroup();
                    }
                }
                case 3 -> {
                    System.out.print("Введіть кількість студентів до переведення: ");
                    int ch = in.nextInt();
                    for (int i = 1; i <= ch; i++) {
                        first.add(second.get(i));
                        second.remove(second.get(i));
                    }
                }
            }
            n = menu();
        }

    }
    static int menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("0. Завершити.");
        System.out.println("1. Перша група.");
        System.out.println("2. Друга група.");
        System.out.println("3. Перевести студентів.");
        return in.nextInt();
    }
    static int menuGroup() {
        Scanner in = new Scanner(System.in);
        System.out.println("0. Повернутися до головного меню.");
        System.out.println("1. Додати студентів.");
        System.out.println("2. Вилучити студента.");
        System.out.println("3. Пошук за заданим номером студента.");
        System.out.println("4. Друкування списку.");
        return in.nextInt();
    }
}
