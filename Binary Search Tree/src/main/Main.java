package main;

import ChristmasTree.ChristmasTree;
import bst.BinarySearchTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Helga on 10/29/2017.
 */
public class Main {
    public static void main(String...args){
      christmasTreeExample();
    }
    public static void bstTest(){
        BinarySearchTree<Integer> binarySearchTree=new BinarySearchTree<Integer>(12);
        binarySearchTree.insert(9);
        binarySearchTree.insert(15);
        binarySearchTree.insert(7);
        binarySearchTree.insert(8);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(13);
        binarySearchTree.insert(19);
        binarySearchTree.insert(22);
        binarySearchTree.insert(1);
        binarySearchTree.find(5);
        System.out.println("\nRoot - Left - Right");
        binarySearchTree.rootLeftRight();
        System.out.println("\nLeft - Right - Root");
        binarySearchTree.leftRightRoot();
        System.out.println("\nLeft - Root - Right");
        binarySearchTree.leftRootRight();
        binarySearchTree.delete(7);
        System.out.println("\nHey");
        binarySearchTree.leftRootRight();

        BinarySearchTree<Integer> binarySearchTree1=new BinarySearchTree<Integer>(25);
        binarySearchTree1.insert(15);
        binarySearchTree1.insert(50);
        binarySearchTree1.insert(10);
        binarySearchTree1.insert(4);
        binarySearchTree1.insert(12);
        binarySearchTree1.insert(22);
        binarySearchTree1.insert(18);
        binarySearchTree1.insert(24);
        binarySearchTree1.insert(35);
        binarySearchTree1.insert(31);
        binarySearchTree1.insert(44);
        binarySearchTree1.insert(70);
        binarySearchTree1.insert(66);
        binarySearchTree1.insert(90);
        System.out.println("\nRoot - Left - Right  PreOrder");
        binarySearchTree1.rootLeftRight();
        System.out.println("\nLeft - Right - Root PostOrder");
        binarySearchTree1.leftRightRoot();
        System.out.println("\nLeft - Root - Right  InOrder");
        binarySearchTree1.leftRootRight();
    }
    public static void christmasTreeExample (){
        try {
            Scanner fileIn = new Scanner(new File("Data.txt"));
            ChristmasTree christmasTreeRoot=new ChristmasTree(1);
            christmasTreeRoot.addAttribute(1);
            BinarySearchTree<ChristmasTree> binarySearchTree=new BinarySearchTree<ChristmasTree>(christmasTreeRoot);

            while(fileIn.hasNextLine()){
                ChristmasTree christmasTree= new ChristmasTree(fileIn.nextInt());
                    for(int i=0;i<christmasTree.getCapacity();i++){
                        if(fileIn.hasNextInt())
                        christmasTree.addAttribute(fileIn.nextInt());
                    }
                System.out.println("value of current christmas tree : "+christmasTree.toString());
                binarySearchTree.insert(christmasTree);
            }
            binarySearchTree.leftRootRight();
            System.out.println();
            binarySearchTree.leftRightRoot();
            System.out.println();
            binarySearchTree.delete(christmasTreeRoot);
            System.out.println();
            binarySearchTree.leftRightRoot();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()+ " File not found");
        }
        catch (NumberFormatException e) {
            System.out.println("Input Mismatch: " + e.getMessage());
        }
        catch(InputMismatchException e)
        {
            System.out.println("Incorrect Data ");
        }
    }
}
