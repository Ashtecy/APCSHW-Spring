import java.util.Random;

public class Driver{
    
    public static void main(String [] args){
	
	Sorts A = new Sorts();

	int[]a={0,1,2,3,4,5,6,7,8,9};
	int[]b={9,8,7,6,5,4,3,2,1,0};
	int[]c=new int[10];
	c=randArray(c,3,1);
	int[]d=new int[10];
	d=randArray(d,2000000,-1000000);	
	
	A.mergesort(a);
	A.mergesort(b);
	A.mergesort(c);
	A.mergesort(d);
    }

    public static int[] randArray(int[]anArray,int range,int start){
	Random rand = new Random();
	for(int i=0;i<anArray.length;i++){
	    anArray[i]=rand.nextInt(range)+start;
	}
	return anArray;
    }
    
}


