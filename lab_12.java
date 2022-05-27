package com.company;

public class lab_12 {
    public static void main (String[] args) {
        float[] x = new float[10];
        create(x);
        float[] y = new float[15];
        create(y);
        float[] z = new float[12];
        create(z);
    }
    static void create (float[] mas){
        for (int i = 0; i < mas.length; i ++)
            mas[i] = (float) Math.random()*200-100;
        System.out.println("Початковий масив: ");
        print(mas);
        for (int i = 0; i < mas.length; i ++) {
            if (i % 3 == 0 && i != 0) {
                if (mas[i-1] * mas[i-2] < 0) {
                    mas[i] = (mas[i-1] + mas[i-2]) / 2;
                }
            }
        }
        System.out.println("Змінений масив: ");
        print(mas);
        System.out.println();
    }
    static void print (float[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + "\t");
            if (i % 10 == 9) System.out.println();
        }
        if (mas.length % 10 != 0)
        System.out.println();
    }
}
