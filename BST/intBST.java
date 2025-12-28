/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11;

/**
 *
 * @author Aroub Alyami
 */
public class intBST {

    private BSTNode root;

    // CONSTRUCTORS
    public intBST() {
        root = null;
    }

    /* Below are MANY methods that are used on Binary Search Trees.
	 * 
	 * Examples:
	 * search, insert, delete, isEmpty, minVal, maxVal, inorder, sumNodes, and many more
     */
    //
    // boolean | isEmpty()
    //
    public boolean isEmpty() {
        return root == null;
    }

    //
    // boolean | search(int)
    //
    public boolean search(int data) {
        return search(root, data);
    }
    //
    // boolean | search(BSTnode, int)
    //

    private boolean search(BSTNode p, int data) {
        if (p == null) {
            return false;
        } else {
            // if the data we are searching for is found at p (at the current root)
            if (data == p.getData()) {
                return true;
            } else if (data < p.getData()) {
                return search(p.getLeft(), data);
            } else {
                return search(p.getRight(), data);
            }
        }
    }

    //
    // void | insert(int)
    //
    public void insert(int data) {
        BSTNode newNode = new BSTNode(data);
        root = insert(root, newNode);
    }
    //
    // BSTnode | insert(BSTnode, BSTnode)
    //

    private BSTNode insert(BSTNode p, BSTNode newNode) {
        // IF there is no tree, newNode will be the root, so just return it
        if (p == null) {
            return newNode;
        } // ELSE, we have a tree. Insert to the right or the left
        else {
            // Insert to the RIGHT of root
            if (newNode.getData() > p.getData()) {
                // Recursively insert into the right subtree
                // The result of insertion is an updated root of the right subtree
                BSTNode temp = insert(p.getRight(), newNode);
                // Save this newly updated root of right subtree into p.right
                p.setRight(temp);
            } // Insert to the LEFT of root
            else {
                // Recursively insert into the left subtree
                // The result of insertion is an updated root of the left subtree
                BSTNode temp = insert(p.getLeft(), newNode);
                // Save this newly updated root of left subtree into p.left
                p.setLeft(temp);
            }
        }
        // Return root of updated tree
        return p;
    }

    //
    // void | inorder()
    //
    public void inorder() {
        inorder(root);
    }
    //
    // void | inorder(BSTnode)
    //

    private void inorder(BSTNode p) {
        if (p != null) {
            inorder(p.getLeft());
            System.out.print(p.getData() + ", ");
            inorder(p.getRight());
        }
    }

    //
    // int | sumNodes()
    //
    public int sumNodes() {
        return sumNodes(root);
    }
    //
    // int | sumNodes(BSTnode)
    //

    private int sumNodes(BSTNode p) {
        if (p != null) {
            return p.getData() + sumNodes(p.getLeft()) + sumNodes(p.getRight());
        } else {
            return 0;
        }
    }

    //
    // void | delete(int)
    //
    public void delete(int data) {
        root = delete(root, data);
    }
    //
    // BSTnode | delete(BSTnode, int)
    //

    private BSTNode delete(BSTNode p, int data) {
        BSTNode node2delete, newnode2delete, node2save, parent;
        int saveValue;

        // Step 1: Find the node we want to delete
        node2delete = findNode(p, data);
        // If node is not found (does not exist in tree), we clearly cannot delete it.
        if (node2delete == null) {
            return root;
        }

        // Step 2: Find the parent of the node we want to delete
        parent = parent(p, node2delete);

        // Step 3: Perform Deletion based on three possibilities
        // **1** :  node2delete is a leaf node
        if (isLeaf(node2delete)) {
            // if parent is null, this means that node2delete is the ONLY node in the tree
            if (parent == null) {
                return null; // we return null as the updated root of the tree
            }
            // Delete node if it is a left child
            if (data < parent.getData()) {
                parent.setLeft(null);
            } // Delete node if it is a right child
            else {
                parent.setRight(null);
            }

            // Finally, return the root of the tree (in case the root got updated)
            return p;
        }

        // **2** : node2delete has only a left child
        if (hasOnlyLeftChild(node2delete)) {
            // if node2delete is the root
            if (parent == null) {
                return node2delete.getLeft();
            }

            // If node2delete is not the root,
            // it must the left OR the right child of some node
            // IF it is the left child of some node
            if (data < parent.getData()) {
                parent.setLeft(parent.getLeft().getLeft());
            } // ELSE it is the right child of some node
            else {
                parent.setRight(parent.getRight().getLeft());
            }

            // Finally, return the root of the tree (in case the root got updated)
            return p;
        }

        // **3** :  node2delete has only a right child
        if (hasOnlyRightChild(node2delete)) {
            // if node2delete is the root
            if (parent == null) {
                return node2delete.getRight();
            }

            // If node2delete is not the root,
            // it must the left OR the right child of some node
            // IF it is the left child of some node
            if (data < parent.getData()) {
                parent.setLeft(parent.getLeft().getRight());
            } // ELSE it is the right child of some node
            else {
                parent.setRight(parent.getRight().getRight());
            }

            // Finally, return the root of the tree (in case the root got updated)
            return p;
        }

        // **4** :  node2delete has TWO children.
        // Remember, we have two choices: the minVal from the right subtree (of the deleted node)
        // or the maxVal from the left subtree (of the deleted node)
        // We choose to find the minVal from the right subtree.
        newnode2delete = minNode(node2delete.getRight());
        // Now we need to temporarily save the data value(s) from this node
        saveValue = newnode2delete.getData();

        // Now, we recursively call our delete method to actually delete this node that we just copied the data from
        p = delete(p, saveValue);

        // Now, put the saved data (in saveValue) into the correct place (the original node we wanted to delete)
        node2delete.setData(saveValue);

        // Finally, return the root of the tree (in case the root got updated)
        return p;
    }

    //
    // BSTnode | minNode(BSTnode)
    //
    public BSTNode minNode(BSTNode root) {
        if (root == null) {
            return null;
        } else {
            if (root.getLeft() == null) {
                return root;
            } else {
                return minNode(root.getLeft());
            }
        }
    }


    public BSTNode maxNode(BSTNode root) {
        if (root == null) {
            return null;
        } else {
            if (root.getRight() == null) {
                return root;
            } else {
                return maxNode(root.getRight());
            }
        }
    }


    public BSTNode findNode(int data) {
        return findNode(root, data);
    }
   

    private BSTNode findNode(BSTNode p, int data) {
        if (p == null) {
            return null;
        } else {
         
            if (data == p.getData()) {
                return p;
            } else if (data < p.getData()) {
                return findNode(p.getLeft(), data);
            } else {
                return findNode(p.getRight(), data);
            }
        }
    }


    public BSTNode parent(BSTNode p) {
        return parent(root, p);
    }

    private BSTNode parent(BSTNode root, BSTNode p) {

        if (root == null || root == p) {
            return null; 
        }
       
        if (root.getLeft() == p || root.getRight() == p) {
            return root; 
        }
       
        if (p.getData() < root.getData()) {
            return parent(root.getLeft(), p);
        } 
        else if (p.getData() > root.getData()) {
            return parent(root.getRight(), p);
        } 
        else {
            return null;
        }
    }


    public boolean isLeaf(BSTNode p) {
        return (p.getLeft() == null && p.getRight() == null);
    }


    public boolean hasOnlyLeftChild(BSTNode p) {
        return (p.getLeft() != null && p.getRight() == null);
    }

    public boolean hasOnlyRightChild(BSTNode p) {
        return (p.getLeft() == null && p.getRight() != null);
    }
      
    public void GreaterThan(int num) {
        GreaterThan(root, num);
    }
    
    private void GreaterThan(BSTNode p, int num) {
        if(p!= null){
            GreaterThan(p.getRight(), num);            
            if(num < p.getData()){
                System.out.print(p.getData() +", ");
            }
            GreaterThan(p.getLeft(), num);             
        }
    }
    
    public void SumChildren(int num) {
        SumChildren(root, num);
    }
    
    private void SumChildren(BSTNode p, int num) {
        if ( p==null ){
            System.out.println("The node " + num + " does not exist in the BST");
        } else {
            if (p.getData() == num){  
                if(p.getLeft()!=null && p.getRight()!=null){
                    System.out.println(">The sum of children of node " + num + " is: " + (p.getLeft().getData() + p.getRight().getData()));
                } else if ( p.getLeft() != null && p.getRight() == null ){
                    System.out.println(">The sum of children of node " + num + " is: " + p.getLeft().getData());
                } else if ( p.getLeft() == null && p.getRight() != null ) {
                    System.out.println(">The sum of children of node " + num + " is: " + p.getRight().getData());
                } else {
                    System.out.println("The node "+num+" does not have any children");
                }
            } else {              
                if(num < p.getData()) {
                    SumChildren(p.getLeft(),num);
                } else {
                    SumChildren(p.getRight(),num);
                }
            }
        }
    }
    
    //___________________________________________________________________________________________________________
    public int NonLeaves() {
        return NonLeaves(root);
    }

    private int NonLeaves(BSTNode p) {
        if (p != null) {
            if (isLeaf(p)) {
               return 0;
            } else {
                return 1 + NonLeaves(p.getLeft()) + NonLeaves(p.getRight());
            }
        } else 
            return 0;
    }
    
   
    public boolean isFullBST() {
        return isFullBST(root);
    }
    private boolean isFullBST(BSTNode p) {  
            if(p.getLeft() == null && p.getRight() != null){
                return false;
            }
            if (p.getLeft() != null && p.getRight() == null){
                return false;
            }
            if(p.getLeft() == null && p.getRight() == null){
                return true;
            }
            return isFullBST(p.getLeft()) && isFullBST(p.getRight());
    }
    
    
}
