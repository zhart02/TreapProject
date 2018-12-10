// Algorithms implemented from C++ version by Jai Goyal

import java.util.Random;


public class TreapNode {

    private TreapNode left;
    private TreapNode right;
    private int key;
    private int priority;
    static Random r = new Random();


    public TreapNode(){
        this.key = key;
        this.priority = priority;
        this.left = left;
        this.right = right;
    }


// A utility function to right rotate subtree rooted with y
    public static TreapNode rightRotate(TreapNode y)
    {
        TreapNode x = y.left,  T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Return new root
        return x;
    }

// A utility function to left rotate subtree rooted with x
    public static TreapNode leftRotate(TreapNode x)
    {
        TreapNode y = x.right, T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Return new root
        return y;
    }

    /* Utility function to add a new key */
    public static TreapNode newNode(int key)
    {
        TreapNode temp = new TreapNode();
        temp.key = key;
        temp.priority = (r.nextInt(100));
        temp.left = temp.right = null;
        return temp;
    }

// function to search a given key in a given BST
    public static TreapNode search(TreapNode root, int key)
    {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;

        // Key is greater than root's key
        if (root.key < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

    /* Recursive implementation of insertion in Treap */
    public static TreapNode insert(TreapNode root, int key)
    {
        // If root is null, create a new node and return it
        if (root == null)
            return newNode(key);

        // If key is smaller than root
        if (key <= root.key)
        {
            // Insert in left subtree
            root.left = insert(root.left, key);

            // Fix Heap property if it is violated
            if (root.left.priority > root.priority)
                root = rightRotate(root);
        }
        else  // If key is greater
        {
            // Insert in right subtree
            root.right = insert(root.right, key);

            // Fix Heap property if it is violated
            if (root.right.priority > root.priority)
                root = leftRotate(root);
        }
        return root;
    }

    /* Recursive implementation of Delete() */
    public static TreapNode deleteNode(TreapNode root, int key)
    {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);

            // IF KEY IS AT ROOT

            // If left is null
        else if (root.left == null)
        {
            TreapNode temp = root.right;
            root = temp;  // Make right child as root
        }

        // If Right is null
        else if (root.right == null)
        {
            TreapNode temp = root.left;
            root = temp;  // Make left child as root
        }

        // If key is at root and both left and right are not null
        else if (root.left.priority < root.right.priority)
        {
            root = leftRotate(root);
            root.left = deleteNode(root.left, key);
        }
        else
        {
            root = rightRotate(root);
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    //function to inorder traverse the tree
    public static void inorder(TreapNode root)
    {
        if (root != null)
        {
            inorder(root.left);
            System.out.println("key: " + root.key + " priority: " + root.priority);
            if (root.left != null){
                System.out.println("left child: " + root.left.key);
            }
            if (root.right != null){
                System.out.println("right child: " + root.right.key);
            }
            inorder(root.right);
        }
    }


//    public static void main(String[] args)
//    {
//
//        TreapNode root = null;
//        root = insert(root, 50);
//        root = insert(root, 30);
//        root = insert(root, 20);
//        root = insert(root, 40);
//        root = insert(root, 70);
//        root = insert(root, 60);
//        root = insert(root, 80);
//
//        System.out.println("Inorder traversal of the given tree");
//        inorder(root);
//
//        System.out.println("\nDelete 20\n");
//        root = deleteNode(root, 20);
//        System.out.println("Inorder traversal of the modified tree");
//        inorder(root);
//
//        System.out.println("\nDelete 30\n");
//        root = deleteNode(root, 30);
//        System.out.println("Inorder traversal of the modified tree");
//        inorder(root);
//
//        System.out.println("\nDelete 50\n");
//        root = deleteNode(root, 50);
//        System.out.println("Inorder traversal of the modified tree");
//        inorder(root);
//
//        TreapNode res = search(root, 50);
//        if (res == null){
//            System.out.println("50 Not Found ");
//        }
//        else{
//            System.out.println("50 found");
//        }
//
//    }
}
