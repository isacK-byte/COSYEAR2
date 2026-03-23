//446077 Monday Practical 7 - CSC211

import java.util.*;

public class tryBST
{
    //NODE SETUP
  public class tNode
  {
    private long key;
    private String data;
    private tNode left, parent, right ;

    public tNode()                      //construct w/o params
    {
        key = 0;
        data = "";
        parent = null; 
        left = null;
        right = null;
    }

    public tNode(long k, String d)      //constructor with params
    {
        key = k;
        data = d;
        parent = null; 
        left = null;
        right = null;
    }

    public long getKey(){ return key;}  //getters
    public void setKey(long k){key = k;} //setters
    public String getData(){ return data;}
    public void setData(String d){data = d;}
    public tNode getLeft(){return left;}
    public void setLeft(tNode n){left = n;}
    public tNode getRight(){return right;}
    public void setRight(tNode n){right = n;}
    public tNode getParent(){return parent;}
    public void setParent(tNode n){parent = n;}

    public void insert(tNode n) // insert procedure for NODES TO BST
    {
        if (n.key < key)    // n into left subtree
            if (left == null)
                {
                    n.parent = this;
                    left = n;
                }
                else 
                    left.insert(n);
                
        
        if (n.key >= key)    // n into right subtree
            if (right == null)
                {
                    n.parent = this;
                    right = n;
                }
                else 
                    right.insert(n);   //  If right !=null(if point has child on the left), thenleft.insert(n)
    }    
  }
  
  public class Tree 
  {
    private  int N = 20;
    private  int listed = 0;
    private  int  length;
    private tNode root;

    public Tree()
    {
        root = null;
        length = 0;

    }

    public void setRoot(tNode n){root = n;}
    public tNode getRoot(){return  root;}
    
    public void insert(tNode n)
    {
        if (root==null){root = n;}
        else insert(root, n);
    
    }

    public void insert( long k, String d)
    {
        tNode n = new tNode(k,d);
        if (root == null){root = n;}
        else 
            insert(root, n);
        length++;
    }

    public void insert(tNode here, tNode n) 
    {
        if (n.getKey()< here.getKey())// n goes left
        // n enters left subtree
        if (here.getLeft()== null)
        {
            n.setParent(here);
            here.setLeft(n);
        }else insert(here.getLeft(),n);
        else if(here.getRight()==null)
        {   // n goes right and enters right subtree
            n.setParent(here);
            here.setRight(n);
        }else insert(here.getRight(),n);

    }
    public int size(){return length;}
    public boolean isEmpty(){return length == 0;}
    public boolean isFull(){return length == N;}

    public void fillBST(long low, long high)
    {
        if (low > high) return;
        long mid = (low + high)/2;
        insert(mid, String.valueOf(mid));
        fillBST(low, mid -1);
        fillBST(mid + 1, high);
    }
  }

}