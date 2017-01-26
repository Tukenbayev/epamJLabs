package kz.epam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        boolean isDone = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!isDone){
            System.out.println("Введите размеры первой матрицы через пробел(строка столбец):");
            String m1Sizes = reader.readLine();
            String m1Size[] = m1Sizes.split(" ");
            Matrix m1 = new Matrix(Integer.parseInt(m1Size[0]), Integer.parseInt(m1Size[1]));
            m1.fillWithRandomValues();
            m1.printMatrix();

            System.out.println("Введите размеры второй матрицы через пробел(строка столбец):");
            String m2Sizes = reader.readLine();
            String m2Size[] = m1Sizes.split(" ");
            Matrix m2 = new Matrix(Integer.parseInt(m2Size[1]), Integer.parseInt(m2Size[0]));
            m2.fillWithRandomValues();
            m2.printMatrix();

            try {
                Matrix result = m1.multiply(m2);
                System.out.println("Результат умножения двух матриц:");
                result.printMatrix();
                isDone = true;
            } catch (IllegalMatrixSize illegalMatrixSize) {
                System.out.println("Для умножения матриц: Количесвто столбцов первой матрицы должно быть равно количесвту");
                System.out.println("строк второй матрицы");
                System.out.println("Пожалуйста, повторите попытку");
                System.out.println();
            }

        }
    }
}
