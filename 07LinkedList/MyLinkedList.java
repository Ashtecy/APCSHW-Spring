public class MyLinkedList<T>{
    
    private LNode<T> head;
    private LNode<T> tail;
    private int size;

    public MyLinkedList(){
	head=null;
	tail=head;
	size=0;
    }

    public static String name(){
	return "chowdhury.raashid";
    }

    public String toString(){
	String ans="[ ";
	LNode<T> node=head;
	while(node!=null){
	    ans+=node.getData()+" ";
	    node=node.getNext();
	}
	return ans+"]";
    }

    public T get(int index){
	LNode<T> node=head;
	while(index>0){
	    node=node.getNext();
	    index--;
	}
	return node.getData();
    }
    
    public void set(int index,T value){
	LNode<T> newNode= new LNode<T>(value);
	LNode<T> node=head;
	while(index>1){
	    node=node.getNext();
	    index--;
	}
	newNode.setNext(node.getNext().getNext());
	node.setNext(newNode);
    }

    public boolean add(T value){
	LNode<T> newNode=new LNode<T>(value);
	if(head==null){
	    head=newNode;
	    tail=newNode;
	}
	else{
	    LNode<T> node=head;
	    while(node.getNext()!=null){
		node=node.getNext();
	    }
	    node.setNext(newNode);
	}
	tail=newNode;
	size++;
	return true;
    }

    public void add(int index,T value){
	LNode<T> newNode=new LNode<T>(value);
	if(index==0){
	    newNode.setNext(head);
	    head=newNode;
	}else{
	    LNode<T> node=head;
	    for(int i=1;i<index;i++){
		node=node.getNext();
	    }
	    newNode.setNext(node.getNext());
	    node.setNext(newNode);
	}
	tail=newNode;
	size++;
    }

    public T remove(int index){
	LNode<T> removed;
	if(index==0){
	    removed=head;
	    head=head.getNext();
	}else{
	    LNode<T> node=head;
	    for(int i=1;i<index;i++){
		node=node.getNext();
	    }
	    removed=node.getNext();
	    node.setNext(node.getNext().getNext());
	}
	size--;
	return removed.getData();
    }

    public int size(){
	return size;
    }
    
    public int indexOf(T value){
	LNode<T> node=head;
	int index=0;
	while(node.getData()!=value){
	    node=node.getNext();
	    index++;
	}
	return index;
    }
    
}
