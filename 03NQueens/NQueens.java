import java.util.*;
import java.io.*;

public class NQueens{
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    private char[][]board;

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

    public NQueens(int size){
	board=new char[size][size];
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board.length;j++){
		board[i][j]='_';
	    }
	}		
    }
        
    public String toString(){
	String ans = "\n";
	for(int i=0;i<board.length;i++){
	    for(int j=0;j<board.length;j++){
		ans+=board[i][j]+" ";
	    }
	    ans+="\n";
	}
	return hide + clear+ go(0,0) + ans + "\n" + show;
    }

    public String name(){
	return "chowdhury,raashid";
    }
    
    public boolean solve(){
	return solve(8,0,0);
    }
    
    public boolean solve(int x){
	return solve(8,x,0);
    }

    public boolean solve(int queen,int x,int y){
	System.out.println(this);
	wait(200);
	if(queen==0){
	    return true;
	}
	try{
	    if(rowCheck(x) && diagCheck(x,y)){
		board[x][y]='Q';
		if(solver(queen-1,y+1)){
		    return true;
		}
		board[x][y]='_';
	    }
	    
	} catch(IndexOutOfBoundsException e){
	    return false;	   
	}
	return false;
    }

    public boolean rowCheck(int x){
	for(int i=0;i<board.length;i++){
	    if(board[x][i]=='Q'){
		return false;
	    }
	}
	return true;
    }

    public boolean diagCheck(int x,int y){
	for(int i=1;i<=Math.min(x,y);i++){
	    if(board[x-i][y-i]=='Q'){
		return false;
	    }
	}
	for(int i=1;i<=Math.min(board.length-x,y);i++){
	    if(board[x+i][y-i]=='Q'){
		return false;
	    }
	}
	return true;
    }

    public boolean solver(int queen,int y){
	for(int i=0;i<board.length;i++){
	    if(solve(queen,i,y)){
		return true;
	    }
	}
	return false;
    }
		
}
   
