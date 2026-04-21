//Binary Search Tree class

class BinarySearchTree {
    private Node root;
    private int size;

    public BinarySearchTree(){      //default constructor
        this.root = null;
        this.size = 0;
    }

    public BinarySearchTree(Node root, int size){  //loaded constructor 
        this.root = root;
        this.size = size;

    }

    public void setRoot(Node root){this.root = root;}       //setters
    public void setSize(int size){this.size = size;}        

    public Node getRoot(){return root;}             //getters
    public int getSize(){return size;}

    public boolean search(int data){
        return complexSearch( root, data);      //Asked Copilot how to go about creating the function without having node as a parameter
    }

    private boolean complexSearch(Node n, int data){
        if (n == null) {
            return false;
        } 
        else if ( n.getData() == data){
            return true;
        }     
        else if ( data < n.getData() ) {
            return complexSearch(n.getLeft(), data);
        }
        else 
            return complexSearch(n.getRight(), data);
        

    }

    

}

 










class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(){
        this.data = 0;          //default constructor
        this.left = null;
        this.right = null;

    }

    public Node(int data, Node left, Node right){   //loaded constructor
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void setData(int data){this.data = data;}    //setters
    public void setLeft(Node left){this.left = left;}
    public void setRight(Node right){this.right = right;}
                                            //getters
    public int getData(){return data;}
    public Node getLeft(){return left;}
    public Node getRight(){return right;}
}