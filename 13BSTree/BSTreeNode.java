public class TreeNode<T extends Comparable>{
    
    private T data;
    private TreeNode[] children=new TreeNode[2];
    private int counter;

    public TreeNode(T data){
	this.data=data;
	counter=1;
    }
    public T getData(){
	return data;
    }
    public int hasChildren(){
	return children.length;
    }    
    public TreeNode<T> getFirst(){
	return children[0];
    }
    public TreeNode<T> getSecond(){
	return children[1];
    }
    public void setData(T data){
	this.data=data;
    }
    public void setFirst(TreeNode<T> child){
	children[0]=child;
    }
    public void setSecond(TreeNode<T> child){
	children[1]=child;
    }
    public int getCount(){
	return counter;
    }
    public void incCount(){
	count++;
    }
}
