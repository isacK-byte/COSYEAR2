
// 4460799 Monday Practical 1A 2026/04/13

class BinaryTreeNode<E> {               //Q1.2 Added "private " keyword for encapsulation
    private E value;
    private BinaryTreeNode<E> left;
    private BinaryTreeNode<E> right;

    public BinaryTreeNode(){            //general constructor 
        this.value = null;
        this.left = null;
        this.right = null;
    } 
    public BinaryTreeNode(E value, BinaryTreeNode<E> left, BinaryTreeNode<E> right){ // Constructor with paraemeters Q1.3
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setValue( E value){ this.value = value ;}   //generic setters placed
    public void setLeft(BinaryTreeNode<E> left){ this.left = left;}
    public void setRight(BinaryTreeNode<E> right){ this.right = right;}
    public E getValue(){ return value;} //generic getters placed
    public BinaryTreeNode<E> getLeft(){return left;}    
    public BinaryTreeNode<E> getRight(){return right;} 
}

class BinaryTree<E>{
   private int size;
    private BinaryTreeNode<E> root;

    public BinaryTree(){        // General constructor 
        this.root = null;
        size = 0;
    }

    public BinaryTree(BinaryTreeNode<E> root, int size){            //constructor with parameters
        this.root = root;
        this.size = size;
    }

      public void setSize( int size){ this.size = size ;}   //generic setters placed
    public void setRoot(BinaryTreeNode<E> root){ this.root = root;}

    public int getSize(){ return size;} //generic getters placed
    public BinaryTreeNode<E> getRoot(){return root;}    
  
}