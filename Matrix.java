package kz.epam;

import java.util.Random;

public class Matrix {

    private int matrix[][];

    public Matrix(int line, int column){
        this.matrix = new int[line][column];
    }

    public Matrix multiply(Matrix matrix) throws IllegalMatrixSize {

        if (this.getMatrixColumnLength() != matrix.getMatrixLineLength())
            throw new IllegalMatrixSize();

        Matrix result = new Matrix(this.getMatrixLineLength(),matrix.getMatrixColumnLength());
        int resultMatrix[][] = result.getMatrix();

        for (int i=0;i<this.matrix.length;i++){
            for (int j=0;j<matrix.getMatrixColumnLength();j++){
                int newValue = 0;
                for (int k = 0; k<matrix.getMatrixLineLength();k++){
                    newValue += this.matrix[i][k]*matrix.getMatrix()[k][j];
                }
                resultMatrix[i][j] = newValue;
            }
        }

        result.setMatrix(resultMatrix);

        return result;
    }

    public void fillWithRandomValues(){
        Random random = new Random();

        for (int i = 0; i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                matrix[i][j] = random.nextInt(100);
            }
        }
    }

    public int[][] getMatrix(){
        return matrix;
    }

    public void setMatrix(int matrix[][]){
        this.matrix = matrix;
    }

    public int getMatrixLineLength(){
        return this.matrix.length;
    }

    public int getMatrixColumnLength(){
        return this.matrix[0].length;
    }

    public void printMatrix(){
        System.out.println();
        for (int i = 0; i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
