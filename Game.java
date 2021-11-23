// Game.java
// contains logic for running the Game
import java.util.Scanner;
import java.util.ArrayList;
import ansi_terminal.*;
import java.io.PrintWriter;
//import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;

public class Game {
    Scanner s = new Scanner(System.in);
    private Room currentRoom;
    private World world;
    private Player player;
    private ArrayList<Box> boxes;
    private ArrayList<Enemy> enemies;
    private ArrayList<Teleporter> teles;

    public Game() {
	world = new World();
	currentRoom = world.getRoom1();
	currentRoom.draw();
        player = new Player(currentRoom.getPlayerStart());
        boxes = currentRoom.getBoxes();
        enemies = currentRoom.getEnemies();
	teles = currentRoom.getTeleporters(); //MAKE A GET TELEPORTER METHOD
    }

    // prints a help menu to the left of the map
    private void showHelp() {
        String[] cmds = {"Commands:",
                         "---------",
                         "Move: Arrow Keys",
                         "Pickup an item: p",
                         "Drop an item: d",
                         "List items: l",
                         "Equip weapon: w",
                         "Equip armor: a",
			 "Teleport: t",
                         "Save: s",
			 "Restore: r",
                         "Quit: q"
        };
        Terminal.setForeground(Color.GREEN);
        for (int row = 0; row < cmds.length; row++) {
            Terminal.warpCursor(row + 1, currentRoom.getCols());
            System.out.print(cmds[row]);
        }
        Terminal.reset();
    }

    // right under the map we keep a line for status messages
    private void setStatus(String mesg) {
        // clear anything old first
        Terminal.warpCursor(currentRoom.getRows(), 0);
        for (int i = 0; i < 100; i++) {
            System.out.print(" ");
        }

        // then print the message
        Terminal.warpCursor(currentRoom.getRows(), 0);
        System.out.print(mesg);
    }
    
    // code for when the player tries to pickup an item
    private void pickup() {
        Box thing = checkForBox();
        if (thing == null) {
            setStatus("There is nothing here to pick up...");
            Terminal.pause(1.25);
        } else {
            if (player.getInventory().add(thing.getItem())) {
                setStatus("You added the " + thing.getItem().getName() + " to your inventory.");
                boxes.remove(thing);
            } else {
                setStatus("This is too large for you to add!");
            }
            Terminal.pause(1.25);
        }
    }

    private void changeRoom() {
       Room tempRoom1 = world.getRoom1();
       Teleporter gate = checkForTele();
       if (gate == null) {
	   setStatus("There is no teleporter here to jump from...");
	   Terminal.pause(1.25);
       }else{
	   setStatus("Teleporter found, jump commencing in: 3");
	   Terminal.pause(1);
	   setStatus("Teleporter found, jump commencing in: 2");
	   Terminal.pause(1);
	   setStatus("Teleporter found, jump commencing in: 1");
	   Terminal.pause(1);
	   if(currentRoom == tempRoom1){
		currentRoom = world.getRoom2();
		redrawMapAndHelp();
	        player = new Player(currentRoom.getPlayerStart());
        	boxes = currentRoom.getBoxes();
        	enemies = currentRoom.getEnemies();
		teles = currentRoom.getTeleporters(); 
	   }else{
		currentRoom = world.getRoom3();
		redrawMapAndHelp();
        	player = new Player(currentRoom.getPlayerStart());
        	boxes = currentRoom.getBoxes();
        	enemies = currentRoom.getEnemies();
		teles = currentRoom.getTeleporters(); 
	   }
    }
   }
    // code for when the player tries to drop an item
    private void drop() {
        if (checkForBox() == null) {
            Item dropped = player.getInventory().drop();
            if (dropped != null) {
                boxes.add(new Box(player.getRow(), player.getCol(), dropped));
            }
            redrawMapAndHelp();
        } else {
            setStatus("You cannot drop something on an existing item...");
            Terminal.pause(1.25);
        }
    }

    // handle the key which was read - return false if we quit the game
    private boolean handleKey(Key key) {
        switch (key) {
            case p:
                pickup();
                break;

            case l:
                player.getInventory().print();
                redrawMapAndHelp();
                break;

            case d:
                drop();
                break;

            case w:
                player.getInventory().equipWeapon();
                redrawMapAndHelp();
                break;

            case a:
                player.getInventory().equipArmor();
                redrawMapAndHelp();
                break;
	    
	    case t:
		changeRoom();
		break;
	    case s:
		save();
		System.out.print("Game Saved!");
		break;
	    //case r:
	//	restore();
	//	break;
            // handle movement
            case LEFT: player.move(0, -1, currentRoom);
                break;
            case RIGHT: player.move(0, 1, currentRoom);
                break;
            case UP: player.move(-1, 0, currentRoom);
                break;
            case DOWN: player.move(1, 0, currentRoom);
                break;

            // and finally the quit command
            case q:
                return false;
        }

        return true;
    }

    // this is called when we need to redraw the room and help menu
    // this happens after going into a menu like for choosing items
    private void redrawMapAndHelp() {
        currentRoom.draw();
        showHelp();
    }

    // returns a Box if the player is on it -- otherwise null
    private Box checkForBox() {
        Position playerLocation = player.getPosition();

        for (Box box : boxes) {
            if (playerLocation.equals(box.getPosition())) {
                return box;
            }
        }

        return null;
    }

    // returns a Teleporter if the player is on it -- otherwise null
    private Teleporter checkForTele(){
	Position playerLocation = player.getPosition();

	for (Teleporter teleporter : teles){
	    if (playerLocation.equals(teleporter.getPosition())){
		return teleporter;
	    }
	}

	return null;
    }

    // check for battles and return false if player has died
    private boolean checkBattles() {
        Position playerLocation = player.getPosition();

        // look for an enemy that is close
        Enemy opponent = null;
        for (Enemy enemy : enemies) {
            if (playerLocation.isAdjacent(enemy.getPosition())) {
                opponent = enemy;
            }
        }

        // now do the battle
        if (opponent != null) {
            opponent.setBattleActive();
            return player.fight(opponent, currentRoom, enemies);
        }

        return true;
    }

    public void save(){
	PrintWriter pw;
	try{
	   //FileInputStream file = new FileInputStream("Save.txt");
	   File f = new File("Save.txt");
	   pw = new PrintWriter(f);
	   //world.save(pw);
	   player.save(pw);
	   //for(enemy e : enemies

	}catch (FileNotFoundException e){
	   System.out.print("Something went wrong =(");
	   System.exit(-1);
	}
    }
    public void run() {
        // draw these for the first time now
        redrawMapAndHelp();

        boolean playing = true;
        while (playing) {
            // draw the entities
            for (Box box : boxes) {
                box.draw();
            }
	    for (Teleporter teleporter : teles) {
		teleporter.draw();
	    }
            for (Enemy enemy : enemies) {
                enemy.draw();
            }
            player.draw();

            // read a key from the user
            Terminal.warpCursor(currentRoom.getRows() + 1, 0);
            Key key = Terminal.getKey();
            playing = handleKey(key);

            // clear status by default
            setStatus("");

            // move the enemies
            for (Enemy enemy : enemies) {
                enemy.walk(currentRoom);
            }

            // check for battles
            if (checkBattles() == false) {
                setStatus("You have been killed :(\n\r");
                playing = false;
            }

            // check if we are on a box and print what's in it
            Box thingHere = checkForBox();
            if (thingHere != null) {
                setStatus("Here you find: " + thingHere.getItem().getName());
            } //NEW CALL, if(thingHere !=null) CHANGE ROOM, SET ROOM = NEXT ROOM
        }
    }
}

