package main;

import ChristmasTree.ChristmasTree;
import bst.BinarySearchTree;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Helga on 10/29/2017.
 */
public class Main {
    public static void main(String...args){
        try{
            testLCA();
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

    private static void testLCA(){

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(2);
        binarySearchTree.insert(1);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);

        System.out.println(LCA( binarySearchTree.root,4, 6));
    }


    private static Integer LCA(BinarySearchTree.Node root, Integer a, Integer b) {
        if(root == null) return null;
        if(a.equals(b)) return a;
        if(a.compareTo(0) <= 0 || b.compareTo(0) <= 0 ) {

            return -1;

        }
        Stack <Integer> firstPath = path(root, a);
        Stack <Integer> secondPath = path(root, b);

        while(firstPath.peek().compareTo(secondPath.peek()) != 0) {
            firstPath.pop();
            secondPath.pop();
        }

        return firstPath.peek();
    }

    private static Stack<Integer> path(BinarySearchTree.Node root, Integer value) {


        Stack<Integer> stack = new Stack<>();
        if(root == null) {
            // stack.pop();
            return stack;
        }
        stack.push((Integer) root.value);
        if(root.value == value){
            return stack;
        }


        stack.addAll(path(root.left, value));
        stack.addAll(path(root.right, value));
        return stack;
    }
}
