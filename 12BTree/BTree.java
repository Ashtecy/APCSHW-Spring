import java.io.*;
import java.util.*;

public class BTree<E> {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    

    private TreeNode<E> root;

    public BTree() {
	root = null;
    }

    public void add(E value){
	TreeNode<E> newNode = new TreeNode<E>(value);
	if(root==null){
	    root=newNode;
	}else{
	    add(root,newNode);
	}	  
    }

    private void add( TreeNode<E> curr,TreeNode<E> newNode){
	if(curr.getFirst()==null){
	    curr.setFirst(newNode);
	}else if(curr.getSecond()==null){
	    curr.setSecond(newNode);
	}else{
	    Random rand=new Random();
	    if(rand.nextInt(2)==0){
		add(curr.getFirst(),newNode);
	    }else{
		add(curr.getSecond(),newNode);
	    }
	}
    }
    
    public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }

    public void preOrder(TreeNode<E> curr){
	if(curr!=null){
	    System.out.print(curr.getData()+" ");
	    preOrder(curr.getFirst());
	    preOrder(curr.getSecond());
	}
    }

    public void inOrder(TreeNode<E> curr){
	if(curr!=null){
	    inOrder(curr.getFirst());
	    System.out.print(curr.getData()+" ");
	    inOrder(curr.getSecond());
	}
    }

    public void postOrder(TreeNode<E> curr){
	if(curr!=null){
	    preOrder(curr.getFirst());
	    preOrder(curr.getSecond());
	    System.out.print(curr.getData()+" ");
	}
    }
    
    public int getHeight(){
	return getHeight(root);
    }
    public int getHeight(TreeNode<E> curr){
	if(curr==null){
	    return 0;
	}else{
	    return getHeight(curr.getFirst())+1;
	} 
    }

    /*======== public String getLevel() ==========
      Inputs:   TreeNode<E> curr
                int level
                int currLevel  
      Returns: A string containing all the elements on the
               given level, ordered left -> right
      
      ====================*/
    private String getLevel( TreeNode<E> curr, int level, int currLevel ) {
	return "";
    }
    
    /*======== public String toString()) ==========
      Inputs:   
      Returns: A string representation of the tree
     
      This string should display each level as a separate line.
      A simple version might look something like this:

      0
      1 2
      3 4 5

      Note that you cannot tell exactly where 3, 4 and 5 lie.
      That is ok, but if you want a CHALLENGE, you can try to
      get the output to look nicer, something like this:
             0

          1      2

            3  4   5

      ====================*/
    public String toString() {
	return "";
    }
	
    public static void main( String[] args ) {

	BTree<Integer> t = new BTree<Integer>();
	/*
	BTree<Integer> u = new BTree<Integer>();
	u.add(5);
	u.add(6);
	u.add(7);
       	u.traverse( PRE_ORDER );
	u.traverse( IN_ORDER );
	u.traverse( POST_ORDER );
	*/
	for ( int i=0; i < 8; i++ ) 
	    t.add( i );
	System.out.println( "Pre-order: ");
	t.traverse( PRE_ORDER );
	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
	System.out.println( "Post-order: ");
	t.traverse( POST_ORDER );
	System.out.println( "Height: " + t.getHeight() );
	System.out.println( t );
    }

}
	
 