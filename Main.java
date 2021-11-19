// Main.java
// contains the main class for running the game

import ansi_terminal.*;

public class Main {
    public static void main(String args[]) {
        // put termain in raw mode
        Terminal.rawMode();
	//ask if they want to continue an old game or start a new one
	//if continue{
	//LOAD GAME
	//game.run
	//else{
	Terminal.setForeground(Color.RED);
   	System.out.print("You were sent by your employeers, a galatic freighting company, to check out a distress signal recently found on a deserted hauling ship.\n\r");
    	Terminal.pause(1);
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

