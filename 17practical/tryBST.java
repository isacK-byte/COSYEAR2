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
    private static int N = 20;
    private static int
  }

}