public class Driver{
    public static void main(String[]args){
	NQueens b = new NQueens(8);
	if(b.solve()){
	    System.out.println(b.toString());
	}else{
	    System.out.println("No Solution");
	}
    }
}
