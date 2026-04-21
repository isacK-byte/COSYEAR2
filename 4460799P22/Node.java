//Node class
 class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(){
        this.data = 0;
        this.left = null;
        this.right = null;

    }

    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}