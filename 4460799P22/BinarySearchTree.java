//Binary Search Tree class
                                                //Question 1
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

    public boolean search(int data){                    //Question 2.1
        return complexSearch( root, data);      //Asked Copilot how to go about creating the function without having node as a parameter
    }

    private boolean complexSearch(Node n, int data){
        if (n == null) {        //if empty or no root exists, return false 
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

    public void insert(int data){                   // QUESTION 2.2
        root = complexInsert(root, data);
    }

    private Node complexInsert(Node n, int data){
        if (n == null) {
            size++;    //if no root exists/ empty tree
            return new Node(data);      //insert the data as the root
        }
        //CHECK FOR DUPES
        if (search(data)){
            System.out.println("Input not valid");
            return n;
            
        }


        if (data == n.getData()){
            System.out.println("Input not valid");
            return n;       //if data already exists, do not insert and return the node
        }
        //////////////////////
        if (data < n.getData()) {       //if smaller than root set left.
            n.setLeft(complexInsert(n.getLeft(), data));
            size++;
        } else if (data > n.getData()){                 //if bigger than root set right
            n.setRight(complexInsert(n.getRight(), data));
            size++;
        }
        return n;
    }

    public int height(){                        //Question 2.3
        if (root == null){
            return 0;   //if empty tree, height is 0
        }
        return complexHeight(root);
    }

    private int complexHeight(Node n){
        if (n == null) {
            return -1; 
        }
        int leftheight = complexHeight(n.getLeft());        
        int rightheight = complexHeight(n.getRight());
        return Math.max(leftheight, rightheight) + 1;
    
    }

    public void print_in_order(){       //Question 2.4
        complexPrintInOrder(root);
        System.out.println();   //newline after printing the tree
    }

    private void complexPrintInOrder(Node n){
        if(n != null){
            complexPrintInOrder(n.getLeft());       //get lower than
            System.out.print(n.getData() + " ");        // get root 
            complexPrintInOrder(n.getRight());      //get higher than (should result in ascending order)
        }
    }
    private int kthCounter;     //Question 2.5
    private int kthAnswer;

    public int find_kth_smallets(int k){
        if ( k <= 0 || k > size){ 
            System.out.println("Input not valid");
             return -1;
        }    //if k is out of bounds, return -1
    
        kthCounter = 0;
        kthAnswer = -1;
        complexFindKthSmallest(root, k);
        return kthAnswer;
    }
    private void complexFindKthSmallest(Node n, int k){
        if (n == null || kthCounter >= k) return ; //base case: if node is null or we already found the kth smallest 
        complexFindKthSmallest(n.getLeft(), k);     //go to the smallest first
        kthCounter++;      //increment counter when we visit a node
        if (kthCounter == k){      //if counter is equal to k, we found our answer
            kthAnswer = n.getData();
            return;
        }
        complexFindKthSmallest(n.getRight(), k);    //go to the bigger ones
    }    

    public void delete(int data){
      if (!search(data) ){
        System.out.println("Input not valid"); // first check if k exists 

        return;
      }
        root = complexDelete(root,data);
        size--;    //decrement size after deletion
    }

    private Node complexDelete(Node n, int data){
        if (n == null) return n;  // base case: if node is null, return null 
        
        
        if (data < n.getData()){
            n.setLeft(complexDelete(n.getLeft(), data));
        }
        else if (data > n.getData()){
            n.setRight(complexDelete(n.getRight(), data));
        }   
        else {      
            //found the node to delete
            
            if(n.getLeft() == null && n.getRight() == null){    //case 1: no children
                return null;    // remove the node
            }
            
            if (n.getLeft() == null){     //case 2a: no left child
                return n.getRight();
            }
            if (n.getRight() == null){   //case 2b: no right child
                return n.getLeft();
            }
                  //case 3: two children - in order predecessor (max of left)
            Node predecessor = findMax(n.getLeft());    //find the largest in the left subtree
            n.setData(predecessor.getData());     //replace data with predecessor's data
            n.setLeft(complexDelete(n.getLeft(), predecessor.getData()));   //delete the predecessor node       
        }
        return n;

    }

    private Node findMax(Node n){
        while (n.getRight() != null){     //keep going right until you find the largest
            n = n.getRight();
        }
        return n;
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

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;

    }

    public void setData(int data){this.data = data;}    //setters
    public void setLeft(Node left){this.left = left;}
    public void setRight(Node right){this.right = right;}
                                            //getters
    public int getData(){return data;}
    public Node getLeft(){return left;}
    public Node getRight(){return right;}
}