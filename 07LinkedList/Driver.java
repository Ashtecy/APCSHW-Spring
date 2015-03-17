public class Driver{
    
    public static void main(String[]args){
	MyLinkedList<Integer> A = new MyLinkedList<Integer>();
	A.add(5);
	A.add(0,8);
	A.add(1,1);
	A.add(2,4);
	/*	System.out.println(A.indexOf(5));
		A.remove(0);
		A.remove(2);
	*/	
	System.out.println(A.toString());
	A.set(3,9);
	System.out.println(A.get(3));
    }   
}
