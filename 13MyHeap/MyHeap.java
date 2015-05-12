public class MyHeap{
    
    private int[] heap;
    private boolean mode;
    
    public MyHeap(){
	heap=new int[10];
	heap[0]=0;
	mode=true;
    }
    
    public MyHeap(boolean isMax){
	heap=new int[10];
	heap[0]=0;
	mode=isMax;
    }

    public void add(int val){
	if(heap[0]==0){
	    heap[1]=val;
	}else{
	    checkSize();
	    if(heap[(heap[0]+1)/2] > val){
		heap[heap[0]+1]=val;
	    }else{
		checkParent(heap[0]+1,val);
	    }
	}
    }
    
    public void checkParent(int pos,int val){
	if(pos==1){
	    heap[heap[0]+1]=heap[1];
	    heap[0]=val;
	    heap[0]++;
	    checkOrder(1);
	}else if(heap[pos/2] > val){
	    heap[heap[0]+1]=heap[pos];
	    heap[pos]=val;
	    heap[0]++;
	    checkOrder(pos);
	}else{
	    checkParent(pos/2;val);
	}
    }

    public void checkOrder(int pos){
	if(heap[pos]<heap[2*pos]){
	    swap(2*pos);
	}
	if(heap[pos]<heap[2*pos+1]){
	    swap(2*pos+1);
	    checkOrder(pos);
	}
	    

    public int getMax(){
	if(mode){
	    return heap[1];
	}else{
	    return null;
	}
    }

    public void checkSize(){
	if(heap.length()==heap[0]+1){
	    resize(2);
	}else if(heap.length()/4>=heap[0]){
	    resize(0.5);
	}
    }
    
    public void resize(int k){
	int[] newHeap=int[heap.length()*k];
	for(int i=0;i<=heap[0]+1;i++){
	    newHeap[i]=heap[i];
	}
    }