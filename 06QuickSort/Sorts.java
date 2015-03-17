import java.util.*;

public class Sorts{

    public static void main(String[]args){
	int[]ar={4,2,7,3,1,9,6,8,5};
	System.out.println(Arrays.toString(quickSort(ar)));
    }
    
    public static int[] quickSort(int[] ar){
	qsh(ar,0,ar.length-1);
	return ar;
    }

    public static void qsh(int[] ar,int s,int e ){
	int pivotPoint=partition(ar,s,e);
	System.out.println(Arrays.toString(ar));
	if(pivotPoint>s){
	    qsh(ar,s,pivotPoint-1);
	}
	if(pivotPoint<e){
	    qsh(ar,pivotPoint+1,e);
	}
    }
    
    public static int partition(int[]ar,int s,int e){
	int pivotPoint=new Random().nextInt(e-s+1)+s;
	swap(ar,e,pivotPoint);
	for(int i=s;i<e;i++){
	    if(ar[i]<ar[e]){
		swap(ar,i,s);
		s++;
	    }
	}
	swap(ar,s,e);
	return s;
    }
    
    public static void swap(int[]ar,int x, int y){
	int holder=ar[x];
	ar[x]=ar[y];
	ar[y]=holder;
    }
}
