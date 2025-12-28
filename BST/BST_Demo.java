/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

/**
 *
 *  */
import java.util.*;
public class BSTdemo {
    public static void main(String[] args) {
        // Make Scanner
        Scanner input = new Scanner(System.in);

        // Other variables
        int choice; // user choice
        int value;  // value to insert, delete, or search for

        // Make a new BST called myTree
        intBST myTree = new intBST();

        // Do/while loop showing menu, getting user choice, and performing actions
        do {
            // Show menu and get user choice
            showMenu();
            choice = input.nextInt();

            // INSERT new node into tree
            if (choice == 1) {
                System.out.print(">    What value do you want to insert: ");
                value = input.nextInt();

                // First, check to see if value already exists in tree. If so, give error message.
                if (myTree.search(value)) {
                    System.out.println(">    " + value + " already exists in the tree. Duplicates are not allowed.");
                } else {
                    myTree.insert(value);
                    System.out.println(">    " + value + " was successfully inserted into the tree.");
                }
                System.out.println();
                
            } else if (choice == 2) {
                if (myTree.isEmpty()) {
                    System.out.println(">    Error: cannot print nodes (the tree is empty)");
                    System.out.println();
                } else {
                    System.out.println(">    Inorder Traversal of nodes:");
                    System.out.print(">    ");
                    myTree.inorder();
                    System.out.println();
                    System.out.println();
                }
            
            } else if (choice == 3) {
                if (myTree.isEmpty()) {
                    System.out.println(">    Error: cannot print greater nodes (the tree is empty)");
                    System.out.println();
                } else {
                    System.out.println("Enter the value you want to get greater nodes:");
                    value = input.nextInt();
                    System.out.print(">All nodes greater than " + value + " are as follows:" +
                            "\n>    ");
                    myTree.GreaterThan(value);
                    System.out.println();
                }
            } else if (choice == 4) {
                if (myTree.isEmpty()) {
                    System.out.println(">    Error: cannot sum children (the tree is empty)");
                    System.out.println();
                } else {
                    System.out.println("Enter the node you want to get sum of its children:");
                    value = input.nextInt();
                    myTree.SumChildren(value);
                    System.out.println();
                }
            } else if (choice == 5) {
                if (myTree.isEmpty()) {
                    System.out.println(">    Error: cannot count number of interior nodes (the tree is empty)");
                    System.out.println();
                } else {
                    System.out.println(">Number of interior nodes in the tree is :" + myTree.NonLeaves());
                    System.out.println();
                }
            } else if (choice == 6) {
                if (myTree.isEmpty()) {
                    System.out.println(">    Error: cannot check if tree is full or not (the tree is empty)");
                    System.out.println();
                } else {
                    System.out.print(">The given BST is ");
                    if(myTree.isFullBST()){
                        System.out.println("a Full BST"); 
                    }
                    else { System.out.println("not a Full BST"); }
                    System.out.println();
                }
            } else if (choice == 7) {
                
                System.out.println(">    Goodbye!");
                System.out.println();
            } else {
                System.out.println(">    Wrong selection. Try again.");
                System.out.println();
            }
            
        } while (choice != 7);
        
    }
    
    public static void showMenu() {
        System.out.println("|---------------------------------------------------------|");
        System.out.println("|----------       Binary Search Tree Menu      -----------|");
        System.out.println("|---------------------------------------------------------|");
        System.out.println("|   1. Insert an item into the tree                       |");
        System.out.println("|   2. Print an inorder traversal of the tree             |");
        System.out.println("|   3. Print nodes greater than some value                |");
        System.out.println("|   4. Print sum of children of some node                 |");
        System.out.println("|   5. Print number of inner nodes of tree                |");
        System.out.println("|   6. Determine whether given BST is Full BST or not     |");
        System.out.println("|   7. Quit                                               |");
        System.out.println("|---------------------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter your choice: ");
    }
}

