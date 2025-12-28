/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

/**
 *
 * 
 */
public class BSTNode {
    
    private int data;
    private BSTNode left;
    private BSTNode right;
    
    // CONSTRUCTORS
    public BSTNode() {
        data = 0;
        left = right = null;
    }
    
    public BSTNode(int data) {
        this.data = data;
        left = right = null;
    }
    
    public BSTNode(int data, BSTNode left, BSTNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // ACCESSORS
    public int getData() {
        return data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getRight() {
        return right;
    }

    // MUTATORS
    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}
