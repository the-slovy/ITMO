package lab1;

import java.util.Random;

import static java.lang.Math.*;

public class Main {
    // Константы
    private final static int NUM = 18;
    private final static double RANGE_MAX = 9.0;
    private final static double RANGE_MIN = -9.0;

    public static void main(String[] args) {
        long[] arrayA = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        double[] arrayX = new double[20];

        for (int i = 0; i < arrayX.length; i++) {
            // рандомное число от -9.0 до 9.0
            arrayX[i] = RANGE_MIN + (RANGE_MAX - RANGE_MIN) * new Random().nextDouble();
        }

        double[][] array = new double[12][20];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                long a = arrayA[i];
                double x = arrayX[j];

                if (a == 10) array[i][j] = firstFormula(x);
                else if (a == 7 || a == 9 || a > 11) array[i][j] = secondFormula(x);
                else array[i][j] = thirdFormula(x);
            }
        }

        // Вывод массива по строчно с форматированием чисел
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(String.format("%.4f", array[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    private static double firstFormula(double x) {
        return pow((log(acos(x / NUM)) / 2), tan(pow(x, x * (4 - x))));
    }

    private static double secondFormula(double x) {
        return pow((log(acos(x / NUM)) / 2), tan(pow(x, x * (4 - x))));
    }

    private static double thirdFormula(double x) {
        return pow(((pow(E, x)) / (pow(E, 0.25 * (x - 1) - 1))) /
                (pow((atan(0.25 * (x / NUM))) / (0.25 - 4 * pow(PI / x, 2)),
                        sin(log(abs(x)))) + 1), 2);
    }
}
