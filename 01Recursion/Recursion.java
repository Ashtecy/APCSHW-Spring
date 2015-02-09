public class Recursion implements hw1{

    public String name(){
	return "Chowdhury,Raashid";
    }

    public int fact(int n){
	if(n==1){
	    return 1;
	}
	return n*fact(n-1);
    }

    public int fib(int n){
	if(n==0){
	    return 0;
	}
	if(n==1){
	    return 1;
	}
	return fib(n-1)+fib(n-2);
    }

    public double sqrt(double n){
	return sqrt2(n,1);
    }

    public double sqrt2(double n,double guess){
	if(guess*guess==n){
	    return guess;
	}
	return sqrt2(n,(n/guess+guess)/2);
    }
    
}
