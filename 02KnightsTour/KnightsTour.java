import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;

    
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
   
    public KnightsTour(int size){
	board=new int[size][size];
    }
 
    public String toString(){
	String ans = "\n";
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board.length;j++){
		if(board[i][j]<10){
		    ans+=0;
		}
		ans+=board[i][j]+" ";
	    }
	    ans+="\n";
	}
	return hide + clear+ go(0,0) + ans + "\n" + show;
    }

    public String name(){
	return "chowdhury.raashid";
    }

    public boolean solve(){
	return solve(0,0,1);
    }
        
    public boolean solve(int x,int y){
	return solve(x,y,1);
    }
        
    public boolean solve(int x,int y,int currentMoveNumber){
	//System.out.println(this);
	//	wait(20);
	if(currentMoveNumber==board.length*board.length+1){
	    return true;
	}
	try{
	    if(board[x][y]==0){
		board[x][y]=currentMoveNumber;
		currentMoveNumber++;
		if(solve(x-1,y+2,currentMoveNumber)||
		   solve(x+1,y+2,currentMoveNumber)||
		   solve(x-2,y+1,currentMoveNumber)||
		   solve(x+2,y+1,currentMoveNumber)||
		   solve(x-2,y-1,currentMoveNumber)||
		   solve(x+2,y-1,currentMoveNumber)||
		   solve(x-1,y-2,currentMoveNumber)||
		   solve(x+1,y-2,currentMoveNumber)){
		    return true;	   
		}
		board[x][y]=0;
	    }
	} catch(IndexOutOfBoundsException e){
	    return false;
	}
	return false;
    }
    
}
