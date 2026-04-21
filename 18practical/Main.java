public class Main {
    public static void main(String[] args) {
        BinaryTree<Character> bt1 = new BinaryTree<>(null, 0); 

        BinaryTreeNode<Character> root1 = new BinaryTreeNode<>('a', null, null);
        bt1.setRoot(root1);
        bt1.setSize(5);

        BinaryTreeNode<Character> b = new BinaryTreeNode<>('b', null, null);
        BinaryTreeNode<Character> c = new BinaryTreeNode<>('c', null, null);
        BinaryTreeNode<Character> d= new BinaryTreeNode<>('d', null, null);
        BinaryTreeNode<Character> e = new BinaryTreeNode<>('e', null, null);

        root1.setLeft(b);
        root1.setRight(c);
        b.setLeft(d);
        b.setRight(e);

        BinaryTree<Double> bt2= new BinaryTree<>(null, 0); 

        BinaryTreeNode<Double> root2= new BinaryTreeNode<>( 3.4, null, null);
        bt2.setRoot(root2);
        bt2.setSize(4);

        BinaryTreeNode<Double> n1 = new BinaryTreeNode<>(-1.5, null, null);
        BinaryTreeNode<Double> n2 = new BinaryTreeNode<>(2.9, null, null);
        BinaryTreeNode<Double> n3= new BinaryTreeNode<>(-9.3, null, null);
  

        root2.setLeft(n1);
        root2.setRight(n2);
        n1.setLeft(n3);
       



    }
}
