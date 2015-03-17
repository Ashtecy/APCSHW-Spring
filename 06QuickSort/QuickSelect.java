import java.util.*;

public class QuickSelect{
    
    public static void main(String[]args){
	int[]ar={4,2,7,3,1,9,6,8,5};
	System.out.println(quickSelect(ar,5));
	
    }

    public static int quickSelect(int[]ar,int n){
	return qsh(ar,0,ar.length-1,n-1);
    }

    public static int qsh(int[]ar,int s,int e,int n){
	System.out.println(Arrays.toString(ar));
	int pivotPoint = partition(ar,s,e);
	if(pivotPoint==n){
	    return ar[n];
	}
	if(pivotPoint>n){
	    return qsh(ar,s,pivotPoint-1,n);
	}
	return qsh(ar,pivotPoint+1,e,n);
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
