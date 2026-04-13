// 4460799 Monday Practical 1A 2026/04/13

class BinaryTreeNode<E> {               //Q1.2 Added "private " keyword for encapsulation
    private E value;
    private BinaryTreeNode<E> left;
    private BinaryTreeNode<E> right;

    public BinaryTreeNode(){
        this.value = null;
        this.left = null;
        this.right = null;
    } 

}

class BinaryTree<E>{
   private int size;
    private BinaryTreeNode<E> root;

}