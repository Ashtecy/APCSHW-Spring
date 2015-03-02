public class LakeMaking{

    private int[][]lake;
    private int R,C,E,N;
    
    public LakeMaking(String filename){
	String ans="";
	try{
	    Scanner in = new Scanner(new File(filename));
	    String line=in.nextLine();
	    R=line.charAt(0);
	    C=line.charAt(2);
	    E=line.charAt(4);
	    N=line.charAt(6);
	    lake = new int[R][C];
	    for(int i=R;i>0;i--){
		line=in.nextLine();
		for(int j=0;j<2*C;j+=2){
		    lake[i][j]=line.charAt(j);
	    }
	    while(in.hasNext()){
		line=in.nextLine();
		stomp(line.charAt(0),line.charAt(2),line.charAt(3));
	    }
	    


	    
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	