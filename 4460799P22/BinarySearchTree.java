//Binary Search Tree class
class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(){
        this.data = 0;
        this.left = null;
        this.right = null;

    }
}


class BinarySearchTree {
    private Node root;
    private int size;

    public BinarySearchTree(){
        this.root = null;
        this.size = 0;
    }

    public BinarySearchTree(Node root, int size){
        this.root = root;
        this.size = size;

    }

    public void setRoot(Node root){this.root = root;}
    public void setSize(int size){this.size = size;}

    public Node getRoot(){return root;}
    public int getSize(){return size;}
    

    

}