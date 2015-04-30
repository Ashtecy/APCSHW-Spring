public class TreeNode<E>{
    
    private E data;
    private TreeNode[] children=new TreeNode[2];

    public TreeNode(E data){
	setData(data);
    }
    public E getData(){
	return data;
    }
    public int hasChildren(){
	return children.length;
    }    
    public TreeNode<E> getFirst(){
	return children[0];
    }
    public TreeNode<E> getSecond(){
	return children[1];
    }
    public void setData(E data){
	this.data=data;
    }
    public void setFirst(TreeNode<E> child){
	children[0]=child;
    }
    public void setSecond(TreeNode<E> child){
	children[1]=child;
    }
}
