public class Sorts{

    
    public static void mergesort(int[]anArray){
       	System.out.println(toString(anArray));
	anArray=msh(anArray);
	System.out.println(toString(anArray));
    }

    public static String toString(int[]anArray){
	String ans="";
       	for(int e:anArray){
	    ans+=e+" ";
	}
	return ans;
    }

    public static int[] msh(int[]anArray){
	if(anArray.length<=1){
	    return anArray;
	}
	int[]a=new int[anArray.length/2];
	int[]b=new int[anArray.length-a.length];
	System.arraycopy(anArray,0,a,0,a.length);
	System.arraycopy(anArray,a.length,b,0,b.length);
	msh(a);
	msh(b);
	merge(a,b,anArray);
	return anArray;
    }
  

    public static int[] merge(int[]a,int[]b,int[]ans){
	int aPos=0;
	int bPos=0;
	int ansPos=0;
	while(aPos<a.length && bPos<b.length){
	    if(a[aPos]<b[bPos]){
		ans[ansPos]=a[aPos];
		aPos++;
	    }else{
		ans[ansPos]=b[bPos];
		bPos++;
	    }
	    ansPos++;
	}
	System.arraycopy(a,aPos,ans,ansPos,a.length-aPos);
	System.arraycopy(b,bPos,ans,ansPos,b.length-bPos);
	return ans;
    }

}
