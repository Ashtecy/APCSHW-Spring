import java.util.*;
import java.io.*;

public class Mazesolver{

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    private char[][]maze;
    private Frontier f;
  
    private int maxx,maxy;
    private int startx,starty;

    public Mazesolver(String filename){
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    //keep reading next line
	    while(in.hasNext()){
		String line= in.nextLine();
		if(maxy==0){
		    //calculate width of the maze
		    maxx=line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans+=line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: "+filename+" could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	maze = new char[maxx][maxy];
	for(int i=0;i<ans.length();i++){
	    char c = ans.charAt(i);
	    maze[i%maxx][i/maxx]= c;
	    if(c=='S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
	f=new Frontier({startx,starty});	
    }
    
    public String toString(){
	return toString(false);
    }

    public String toString(boolean animate){
	if(animate){
	    return null;
	}
	String ans="";
	for(int i=0;i<maze[0].length;i++){
	    for(int j=0;j<maze.length;j++){
		ans+=maze[j][i]+" ";
	    }
	    ans+="\n";
	}
	return ans;
	
    }
    
    /*
      getNext
        markVisited/doneCheck
      findValid
      addValid
    */

    public boolean solveBFS(boolean animate){
	if(animate){
	    return null;
	}else{
	    f.setMode(false);
	    return BFS();
	}
    }

    public boolean BFS(){
	x=f.getNext()[0];
	y=f.getNext()[1];
	if(maze[x][y]=='E'){
	    return true;
	}
	h1(x+1,y);
	h1(x,y-1);
	h1(x-1,y);
	h1(x,y+1);
	return BFS()
    }

    public void h1(int x,int y){
	char pos=maze[x][y];
	if(pos==' '){
	    f.add({x,y});
	}
    }

    /*
    public boolean solveDFS(boolean animate){
    }
    
    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }
    */

    public class Frontier{
	
	private DoubleEndedQueue<Interger[]> search = new DoubleEndedQueue<Integer[]>();
	private boolean mode;
	
	public Frontier(int[]coords){
	    search.add0(coords);
	}
	
	public setMode(boolean mode){
	    this.mode=mode;
	}

	public add(int[] coords){
	    if(mode){
		search.addFirst(coords);
	    }else{
		search.addLast(coords);
	    }
	}

	public int[] getNext(){
	    return search.getFirst();
	}
	
    }
  
    public static void main(String[]args){
	Mazesovler f;
	if(args.length < 1){
	    f = new Mazesolver("data3.dat");
	}else{
	    f = new Mazesolver(args[0]);
	}
	//f.toString();
    }
    
}