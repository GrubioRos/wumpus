package game;

import java.util.Scanner;

import enemys.*;


public class Main {
	public  static final  int WIDTH = 4;
	public  static final  int HEIGHT = 4;
	public  static final  String HELLO_MSG = "Hello, you are playing in a " + WIDTH + " x " + HEIGHT + " map. \nPlease type an action { go(moves foward), shoot(shoots foward), left(turns), right(turns) }.\nExample: go \nYou are in the left bottom corner facing up.\n";
	public Player player;
	public Enemy[] enemys;
	public boolean end = false;
	
	 public static void main(String[] parametro) {
		Main m = new Main();
		m.player = new Player(1,1);
		m.enemys = new Enemy[4];
		m.enemys[0] = new Wumpus(3,3); 
		Scanner keyboard = new Scanner(System.in);		
	 	String input;
	    System.out.print(HELLO_MSG);
	    System.out.print( "> ");
	    while(!m.end){
		    input = keyboard.next();
		    if(checkInput(input)) m.player.run(input);
		    else System.out.print( "I did not understand.\n> ");
	    }
	        
	 }
	 


	public static boolean checkInput(String input){
		 if(input.equalsIgnoreCase("go") || input.equalsIgnoreCase("shoot") || input.equalsIgnoreCase("left") || input.equalsIgnoreCase("right")){
			 return true;
		 }
		 return false;
	 }
	 
	 
}
