package com.company;
import java.util.Scanner;
public class lab_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = input();
        while (n != 0) {
            switch (n) {
                case 1 -> {
                    System.out.print("Значення координат першої точки: ");
                    float x1 = in.nextFloat();
                    float y1 = in.nextFloat();
                    System.out.print("Значення координат другої точки: ");
                    float x2 = in.nextFloat();
                    float y2 = in.nextFloat();
                    System.out.println("Відстань між точками: " + (Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2))));
                }
                case 2 -> {
                    System.out.print("Введіть значення х: ");
                    double x = in.nextDouble();
                    double y = (1 + (3 * x)) / (2 + Math.cbrt(1 + x));
                    System.out.println("Значення у: " + y);
                }
                case 3 -> {
                    System.out.print("Введіть чотиризначне число: ");
                    int number = in.nextInt();
                    String result;
                    if (number / 10000 == 0 && number / 1000 != 0) {
                        int a = 0, b = 0;
                        for (int i = 1; i <= 4; i++) {
                            if (i == 1 || i == 2) a += (number % 10);
                            else b += (number % 10);
                            number /= 10;
                        }
                        result = (a == b) ? "Істинне" : "Хибне";
                        System.out.println("Твердження: Сума двох перших цифр даного чотиризначного числа дорівнює сумі двох його останніх цифр \n- є: " + result);
                    } else System.out.println("Введене число не чотиризначне.");
                }
                default -> System.out.println("Номер введено не вірно.");
            }
            n = input();
        }
    }
    static int input () {
        Scanner in = new Scanner(System.in);
        System.out.println("0. Вихід з програми.");
        System.out.println("1. Знайти відстань між точками.");
        System.out.println("2. Обчислити значення у.");
        System.out.println("3. Перевірити істинність твердження.");
        return in.nextInt();
    }
}
