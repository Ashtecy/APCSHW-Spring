import java.util.*;

public class DoubleEndedQueue<T>{

    public static void main(String[]args){
	DoubleEndedQueue<Integer> A = new DoubleEndedQueue<Integer>();
	A.addLast(5);
	A.addLast(9);
	A.addLast(4);
	A.addLast(8);
	System.out.println(A.toString());
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
	for(int i=head;i<queue.length;i++){
	    ans+=" "+queue[i];
	}
	if(tail<head){
	    for(int i=0;i<=tail;i++){
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
	    int i=0;
	    if(head<=tail){
		for(int j=head;j<=tail;j++){
		    newQueue[i]=queue[j];
		    i++;
		}
	    }else{
		for(int j=head;j<queue.length;j++){
		    newQueue[i]=queue[j];
		    i++;
		}
		for(int j=0;j<=tail;j++){
		    newQueue[i]=queue[j];
		}
		head=0;
		tail=queue.length-1;
	    }
	    queue=newQueue;
	}
    }

}
	    
		
		
