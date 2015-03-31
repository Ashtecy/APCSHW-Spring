import java.util.*;

public class DoubleEndedQueue<T>{

    public static void main(String[]args){
	DoubleEndedQueue<Integer> A = new DoubleEndedQueue<Integer>();
	A.addLast(5);
	A.addLast(9);
	A.addLast(4);
	A.addLast(8);
	A.addFirst(6);
	A.addFirst(3);
       	A.addFirst(7);
	System.out.println(A.toString());
	A.removeLast();
	A.removeFirst();
	System.out.println(A.toString());
	System.out.println(A.getFirst());
	System.out.println(A.getLast());
    }
    
    private Object[] queue;
    private int capacity,head,tail;
    
    public DoubleEndedQueue(){
	queue=new Object[10];
	capacity=0;
	head=-1;
	tail=-1;
    }

    public String toString(){
	String ans="[";
	if(tail>head){
	    for(int i=head+1;i<tail;i++){
		ans+=" "+queue[i];
	    }    
	}else{
	    for(int i=head+1;i<queue.length;i++){
		ans+=" "+queue[i];
	    }
	    for(int i=0;i<tail;i++){
		ans+=" "+queue[i];
	    }
	}
	ans+=" ]"+"\n"+Arrays.toString(queue)+"\n"+"head:"+head+"  tail:"+tail;
	return ans;
    }
    
    public void addFirst(T value){
	capCheck();
	if(capacity==0){
	    add0(value);
	}else{
	    queue[head]=value;
	    head--;
	    if(head==-1){
		head=queue.length-1;
	    }
	    capacity++;
	}
    }
    
    public void addLast(T value){
	capCheck();
	if(capacity==0){
	    add0(value);
	}else{
	    queue[tail]=value;
	    tail++;
	    if(tail==queue.length){
		tail=0;
	    }
	    capacity++;
	}
    }
    
    public void add0(T value){
	queue[0]=value;
	head=queue.length-1;
	tail=1;
	capacity=1;
    }
    
    public void capCheck(){
	if(capacity==queue.length){
	    Object[] newQueue=new Object[queue.length*2];
	    resize(newQueue);
	}else if(capacity<queue.length/4){
	    Object[] newQueue=new Object[queue.length/2];
	    resize(newQueue);
	}
    }
    
    public void resize(Object[] newQueue){
	int i=0;
	if(head<=tail){
	    for(int j=head+1;j<tail;j++){
		newQueue[i]=queue[j];
		i++;
	    }
	}else{
	    for(int j=head+1;j<queue.length;j++){
		newQueue[i]=queue[j];
		i++;
	    }
	    for(int j=0;j<tail;j++){
		newQueue[i]=queue[j];
		i++;
	    }
	    head=0;
	    tail=queue.length-1;
	}
	queue=newQueue;
    }
    
    public T removeFirst(){
	if(capacity==0){
	    throw new NoSuchElementException();
	}else{
	    capCheck();
	    capacity--;
	    head++;
	    if(head==queue.length){
		head=0;
	    }
	    return (T)queue[head];
	}
    }
    
    public T removeLast(){
	if(capacity==0){
	    throw new NoSuchElementException();
	}else{
	    capCheck();
	    capacity--;
	    tail--;
	    if(tail==-1){
		tail=queue.length;
	    }
	    return (T)queue[tail];
	}
    }
    
    public T getFirst(){
	if(capacity==0){
	    throw new NoSuchElementException();
	}else{
	    int index=head+1;
	    if(index==queue.length){
		index=0;
	    }
	    return (T)queue[index];
	}
    }
    
    public T getLast(){
	if(capacity==0){
	    throw new NoSuchElementException();
	}else{
	    int index=tail-1;
	    if(index==-1){
		index=queue.length-1;
	    }
	    return (T)queue[index];
	}
    }
    
}
	    
		
		
