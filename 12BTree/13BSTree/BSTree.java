import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

    private BSTreeNode<T> root;
    private Random r;

    public BSTree() {
	root = null;
	r = new Random();
    }
    public BSTree(long seed){
	root = null;
	r = new Random(seed);
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getFirst() == null && t.getSecond() == null);
    }

    public int getHeight(){
	return getHeight(root);
    }
    public int getHeight(BSTreeNode<T> curr){
	if(curr==null){
	    return 0;
	}
	return 1+Math.max(getHeight(curr.getFirst()),getHeight(curr.getSecond()));
    }

    public void add(T c){
	root = add( root, new BSTreeNode<T>(c));
    }

    private BSTreeNode<T> add(BSTreeNode<T> curr,BSTreeNode<T> t) {
	if(curr==null){
	    return t;
	}
	int x = curr.getData().compareTo(t.getData());
	/*	if(x==0){
	    curr.incCount();
	}
	*/
	if(x>0){
	    curr.setFirst(add(curr.getFirst(),t));
	}
	if(x<0){
	    curr.setSecond(add(curr.getSecond(),t));
	}
	return curr;
    }

    public void remove(T c) {
	root = remove(root,c);
    }
    
    private BSTreeNode<T> remove(BSTreeNode<T> curr, T c){
	if (curr == null){
	    return null;
	}
	if (curr.getData().compareTo(c) == 0){
	    if (isLeaf(curr)){
		return null;
	    }else if (curr.getFirst() == null){
		return curr.getFirst();
	    }else if (curr.getFirst() == null){
		return curr.getSecond();
	    }else{
		BSTreeNode<T> holder;
		if (r.nextInt(2) == 0){
		    holder = curr.getSecond();
		    while (holder.getFirst() != null){
			holder = holder.getFirst();
		    }
		    curr.setData(holder.getData());
		    curr.setSecond(remove(curr.getSecond(),holder.getData()));
		}else{
		    holder = curr.getFirst();
		    while (holder.getSecond() != null){
			holder = holder.getSecond();
		    }
		    curr.setData(holder.getData());
		    curr.setFirst(remove(curr.getFirst(), holder.getData()));
		}
	    }
	}
	else if (curr.getData().compareTo(c) < 0){
	    curr.setSecond(remove(curr.getSecond(), c));
	}else if (curr.getData().compareTo(c) > 0){
	    curr.setFirst(remove(curr.getFirst(), c));
	}
	return curr;
    }
    
    public void inOrder() {
	inOrderHelper(root);
	System.out.println();
    }

    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getFirst() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getSecond() );
    }
 
/*
  stolen from: Dennis Yatunin
*/
    
    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return maxLength(root);
    }
    
    private int maxLength(BSTreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getFirst() != null) {
	    temp = maxLength(curr.getFirst());
	    if (temp > max)
		max = temp;
	}
	if (curr.getSecond() != null) {
	    temp = maxLength(curr.getSecond());
	    if (temp > max)
		max = temp;
	}
	return max;
    }
    
    private String spaces(double n) {
	// returns a String of n spaces
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }
    
    private String getLevel(BSTreeNode<T> curr,int currLevel,int targetLevel,
			    int height,int wordLength) {
	if (currLevel == 1){
	    return curr.toString() + 
		spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * Math.pow(2, height - targetLevel + 1) - wordLength);
	}
	String result = "";
	if (curr.getFirst() != null){
	    result += getLevel(curr.getFirst(), currLevel - 1, targetLevel, height, wordLength);
	}else{
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	if (curr.getSecond() != null){
	    result += getLevel(curr.getSecond(), currLevel - 1, targetLevel, height, wordLength);
	}else{ 
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	return result;
    }
    
    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++){
	    // remove extra spaces from the end of each level's String to prevent lines from
	    // getting unnecessarily long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		"\n";
	}
	// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
	
	return result;
    }
    
    public static void main( String[] args ) {
	BSTree<Integer> t = new BSTree<Integer>();
	
	t.add(25);
	t.add(34);
	t.add(20);
	t.add(19);
	t.add(55);
	t.inOrder();
	System.out.println(t.toString());
	t.remove(20);
	System.out.println(t.toString());
	
    }

}
