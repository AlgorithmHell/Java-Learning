package main;
   import Exception.MyException;
   import Matrix.Matrix;
   import java.io.File;
   import java.io.FileNotFoundException;
   import java.util.InputMismatchException;
   import java.util.Scanner;

public class Main {
    public static void main(String... args)  {
        try {
            Scanner scanner=new Scanner(new File("Exception3.txt"));
            Matrix matrix = new Matrix(scanner);
            System.out.println("Matrix");
            matrix.show();
            Matrix inverse = matrix.inverse();
            System.out.println("Matrix");
            matrix.show();
            System.out.println("Inverse ");
            inverse.show();
        } catch (NumberFormatException e) {
            System.out.println("Input Mismatch: " + e.getMessage());
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found "+e.getMessage());
        }
        catch(MyException e)
        {
            System.out.println("Incorrect Input " +e.getMessage());
        }
        catch(InputMismatchException e)
        {
            System.out.println("Incorrect Data ");
        }
    }
}