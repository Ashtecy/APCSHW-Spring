public class Driver{
    public static void main(String[]args){
	KnightsTour b = new KnightsTour(7);
	if(b.solve()){
	    System.out.println(b.toString());
	}else{
	    System.out.println("No Solution");
	}
    }
}