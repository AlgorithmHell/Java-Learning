package Matrix;

import java.util.List;
import Exception.MyException;


import java.util.Scanner;

/**
 * Created by Helga on 10/21/2017.
 */
public class Matrix {
    private double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }
    public Matrix(Scanner scanner) throws MyException {

            int size = scanner.nextInt();
            matrix = new double[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if(scanner.hasNextDouble())
                        matrix[i][j] = scanner.nextDouble();
                    else throw new MyException("Not enough Data");
                }
            }
            if(scanner.hasNext()) throw new MyException("Extra Data");


    }
    public Matrix inverse() {
        double[][] matrix = new double[this.matrix.length][this.matrix.length];
        double[][] inverse = new double[this.matrix.length][this.matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) inverse[i][j] = 1;
                else inverse[i][j] = 0;
            }
        }
        this.prepareMatrix(inverse);
        try {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = this.matrix[i][j];

                }
            }
            //System.out.println("Matrix");
            //this.show(matrix);
            //System.out.println("Inverse ");
            //this.show(inverse);
            for (int k = 0; k < matrix.length; k++) {//lines
                for (int i = 0; i < matrix.length; i++) {//lines
                    if (k == i) continue;
                    double saveIK = matrix[i][k];
                    double saveKK = matrix[k][k];
                    for (int j = 0; j < matrix.length; j++) {//columns
                        matrix[i][j] -= matrix[k][j] * saveIK / saveKK;
                        inverse[i][j] -= inverse[k][j] * saveIK / saveKK;
                    }
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                double save = matrix[i][i];
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] /= save;
                    inverse[i][j] /= save;
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You are out of index " + e.getMessage());
        }
        Matrix returnValue = new Matrix(inverse);
        return returnValue;

    }
    private void prepareMatrix(double[][]inverse) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    if (i == j) continue;
                    if (matrix[j][i] != 0) {
                        swapStrings(i, j);
                        swapStrings(i, j,inverse);
                        break;
                    }
                }
            }
        }
    }
    private void swapStrings(int firstIndex, int secondIndex) {
        for (int i = 0; i < matrix.length; i++) {
            double buf=matrix[firstIndex][i];
            matrix[firstIndex][i]= matrix[secondIndex][i];
            matrix[secondIndex][i]=buf;
        }
    }
    private void swapStrings(int firstIndex, int secondIndex,double[][]matrix) {
        for (int i = 0; i < matrix.length; i++) {
            double buf=matrix[firstIndex][i];
            matrix[firstIndex][i]= matrix[secondIndex][i];
            matrix[secondIndex][i]=buf;
        }
    }
    public double[][] getMatrix() {
        return matrix;
    }
    public void show(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(String.format("%.3f ", matrix[i][j]) + " ");
            }
            System.out.println("");
        }
    }
    public void show() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(String.format("%.3f ", matrix[i][j]) + " ");
            }
            System.out.println("");
        }
    }

}