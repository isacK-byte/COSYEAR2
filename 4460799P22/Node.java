//Node class
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