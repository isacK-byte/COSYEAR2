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
  }  
}