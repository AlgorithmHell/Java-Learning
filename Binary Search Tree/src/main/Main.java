package main;

import ChristmasTree.ChristmasTree;
import bst.BinarySearchTree;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Helga on 10/29/2017.
 */
public class Main {
    public static void main(String...args){
        try{
            treeExample();
        }

        catch (NumberFormatException e) {
            System.out.println("Input Mismatch: " + e.getMessage());
        }
        catch(InputMismatchException e)
        {
            System.out.println("Incorrect Data ");
        }

    }
    private static void treeExample(){
        try {
            Scanner fileIn = new Scanner(new File("Tree.txt"));


            BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>(fileIn.nextInt());
            while(fileIn.hasNextInt()){
                binarySearchTree.insert(fileIn.nextInt());
            }
            System.out.println("Result of searching for value 5: " + binarySearchTree.find(5));
            System.out.println("\nRoot - Left - Right : Pre - Order");
            binarySearchTree.rootLeftRight();
            System.out.println("\nLeft - Right - Root : Post - Order");
            binarySearchTree.leftRightRoot();
            System.out.println("\nLeft - Root - Right : In - Order");
            binarySearchTree.leftRootRight();
            binarySearchTree.delete(7);
            System.out.println("\nValue 7 was deleted");
            binarySearchTree.leftRootRight();
            System.out.println("\nNow we will delete the root : " + binarySearchTree.getRoot());
            binarySearchTree.delete(Integer.parseInt(binarySearchTree.getRoot()));
            binarySearchTree.leftRootRight();
            System.out.println("\nNew root : " + binarySearchTree.getRoot());
            System.out.println("\nNow we will delete value that is not in the tree : 1000 ");
            binarySearchTree.delete(1000);

            binarySearchTree.leftRootRight();


        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage()+ " File not found");
        }
    }

    private static void tree1Example(){
        try{
            Scanner fileIn = new Scanner(new File("Tree1.txt"));
            BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>(fileIn.nextInt());
            while(fileIn.hasNextInt()){
                binarySearchTree.insert(fileIn.nextInt());
            }
            System.out.println("\nRoot - Left - Right : Pre - Order");
            binarySearchTree.rootLeftRight();
            System.out.println("\nLeft - Right - Root : Post - Order");
            binarySearchTree.leftRightRoot();
            System.out.println("\nLeft - Root - Right : In - Order");
            binarySearchTree.leftRootRight();
            binarySearchTree.delete(22);
            System.out.println("\nValue 22 was deleted");
            binarySearchTree.leftRootRight();
            System.out.println("\nNow we will delete the root : " + binarySearchTree.getRoot());
            binarySearchTree.delete(Integer.parseInt(binarySearchTree.getRoot()));
            binarySearchTree.leftRootRight();
            System.out.println("\nNew root : " + binarySearchTree.getRoot());

        } catch  (FileNotFoundException e) {
            System.out.println(e.getMessage()+ " File not found");
        }
    }

    private static void christmasTreeExample (){
        try {
            Scanner fileIn = new Scanner(new File("Data.txt"));

            ChristmasTree christmasTreeRoot=new ChristmasTree(2);
            christmasTreeRoot.addAttribute(1);
            christmasTreeRoot.addAttribute(99);
            christmasTreeRoot.addAttribute(70);
            BinarySearchTree<ChristmasTree> binarySearchTree=new BinarySearchTree<ChristmasTree>(christmasTreeRoot);
            System.out.println(" This is the root "+christmasTreeRoot.toString());
            while(fileIn.hasNextLine()){
                ChristmasTree christmasTree= new ChristmasTree(fileIn.nextInt());
                    for(int i=0;i<christmasTree.getCapacity();i++){
                        if(fileIn.hasNextInt())
                        christmasTree.addAttribute(fileIn.nextInt());
                    }
                System.out.println("\n value of current christmas tree : "+christmasTree.toString());
                binarySearchTree.insert(christmasTree);
            }
            System.out.println("\n\nRoot - Left - Right : Pre - Order");
            binarySearchTree.rootLeftRight();
            System.out.println("\n\nLeft - Right - Root : Post - Order");
            binarySearchTree.leftRightRoot();
            System.out.println("\n\nLeft - Root - Right : In - Order");
            binarySearchTree.leftRootRight();
            System.out.println("\n\nnow we will delete the root : " + binarySearchTree.getRoot());
            binarySearchTree.delete(christmasTreeRoot);
            binarySearchTree.leftRootRight();
            System.out.println("\n\nNew root : " + binarySearchTree.getRoot());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()+ " File not found");
        }

    }
}
