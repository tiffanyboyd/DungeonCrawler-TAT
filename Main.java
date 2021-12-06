// Main.java
// contains the main class for running the game

import ansi_terminal.*;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	System.out.println("What is your name?");
	String name = in.nextLine();
	System.out.println("Are you an (A)lien or a (H)uman");
	String race = in.next();
        // put termain in raw mode
        Terminal.rawMode();
	//ask if they want to continue an old game or start a new one
	//if continue{
	//LOAD GAME
	//game.run
	//else{
	Terminal.setForeground(Color.RED);
   	System.out.print(name +", you were sent by your employeers, a galatic freighting company, to check out a distress signal recently found on a deserted hauling ship.\n\r");
    	Terminal.pause(1);
	if(race.equals("H")){
		System.out.print("As a human normally you would be above this kind of work but the superiors citied their contract and you have no choice but to follow.\n\r");
		Terminal.pause(1);
	}else if(race.equals("A")){
		System.out.print("As an alien this kind of dirty, risky work is something you're used to being forced to do, hopefully this is the last time.\n\r");
		Terminal.pause(1);
	}else{
		System.out.print("Your species is not recognized in our databases, please select one of the options.\n\r");//THIS NEEDS TO GO HIGHER
		Terminal.pause(1);
		System.exit(-1);
	}
    	System.out.print("As your shuttle docs a message from the crew patches through to your monitor:\n\r");
    	Terminal.pause(1);
    	System.out.print("Whoever finds this, our ship has been overrun by alien life forms, the only hope is to reach the self destruct button at the center of the ship.\n\r");
    	Terminal.pause(1);
    	System.out.print("You grab your industry standard shock baton and get ready as the shuttle doors open\n\r");
    	Terminal.pause(1);
    	Terminal.reset();
        // make and run the Game
        Game game = new Game();
        game.run();
	//}
        // put terminal back into cooked mode
        Terminal.cookedMode();
    }
}

