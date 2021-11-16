// Room.java
// provides code for the drawing of a room
// also provides starting locations for the player, boxes, and enemies
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import ansi_terminal.*;

public class Room {
    // the grid holds the room geometry
    private String[] grid;
    private String desc;
    // the size of the room
    private int rows;
    private int cols;
    
    public void loadRoom(int roomNum){
	Scanner in = new Scanner(System.in);
	switch(roomNum){
	     case 1:
		try{
		   File f = new File("Room1.txt");
		   in = new scanner(f);
		}catch (FileNotFoundException e){
			System.out.print("Something went wrong :(");
			System.exit(-1);
		}
		break;
	     case 2:
		try{
		   File f = new File("Room2.txt");
		   in = new scanner(f);
		}catch (FileNotFoundException e){
			System.out.print("Something went wrong :(");
			System.exit(-1);
		}
		break;
	     case 3:
		try{
		   File f = new File("Room3.txt");
		   in = new scanner(f);
		}catch (FileNotFoundException e){
			System.out.print("Something went wrong :,(");
			System.exit(-1);
		}
		break;
	}
	room = new Room(in);
    }
    public Room(Scanner s) {
        // this initializes the room to one specific space
        rows = s.nextInt();
        cols = s.nextInt();

        // the actual room geometry
        // the i cells refer to where an item should be placed at
       desc =""; 
       String next = s.nextLine();
       while (!next.equals(".")){
         grid  = desc + next + "\n";
         next = s.nextLine();
       }
        /*    new String[] {
            "##################                ######################    ",
            "##              ##                ##      i           ##    ",
            "##  @           ###########       ##        *         ##    ",
            "##                       ##       ##                  ##    ",
            "##              #######  ##       ##################  ##    ",
            "##              ##   ##  ##                       ##  ##    ",
            "##################   ##  ##################       ##  ##    ",
            "                     ##                  ##       ##  ##    ",
            "                     ##   *  i           ##       ##  ##    ",
            "                     ##                  ##       ##  ##    ",
            "                     ##############  ######       ##  ##    ",
            "                                 ##  ##           ##  ##    ",
            "                                 ##  ##           ##  ##    ",
            "                       ############  ###############  ######",
            "                       ##                                 ##",
            "                       ##                                 ##",
            "    #####################                  *              ##",
            "    ##                                                    ##",
            "    ##  #################                                 ##",
            "    ##  ##             ##                                 ##",
            "    ##  ##             #################  ##################",
            "    ##  ##                            ##  ##                ",
            "    ##  ##                            ##  ##                ",
            "    ##  ##                       #######  #######           ",
            "    ##  ##                       ##            ##           ",
            "######  ####                     ##  i  *      ##           ",
            "##        ##                     ##            ##           ",
            "## i  *   ##                     ################           ",
            "##        ##                                                ",
            "############                                                "
        };
    }
*/
//    void persist(printWriter pw){
//        pw.println(rows);
//        pw.println(cols);
//        pw.println(desc);
//        pw.println(".");
     }
    // returns the player's strting location in this room
    public Position getPlayerStart() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row].charAt(col) == '@') {
                    return new Position(row, col);
                }
            }
        }

        return null;
    }

    // returns a set of item boxes for this map, this is here because it depends on
    // the room geometry for where the boxes make sense to be
    public ArrayList<Box> getBoxes() {
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row].charAt(col) == 'i') {
                    boxes.add(new Box(row, col, ItemGenerator.generate()));
                }
            }
        }

        return boxes;
    }

    //THIS IS NEW CODE IF EVERYTHING BREAKS ITS BECAUSE OF THIS
    //Should return a set of teleporters for this map, depends on room geometry
    public Arraylist<Teleporter> getTeleporters() {
	ArrayList<Teleporter> teles = new ArrayList<Teleporter>();
	for (int row = 0; row < rows; row++) {
	    for(int col = 0; col < cols; col++) {
		if (grid[row].charAt(col) == '^') {
		   teles.add(new Teleporter(row, col));
		}
	    }
	}
	
	return teles;
    }

    // returns a set of enemies from this map, similarly to the boxes above
    public ArrayList<Enemy> getEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row].charAt(col) == '*') {
                    enemies.add(EnemyGenerator.generate(row, col));
                }
            }
        }

        return enemies;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    // draws the map to the screen
    public void draw() {
        Terminal.clear();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char cell = grid[row].charAt(col);
                if (cell == '#') {
                    // a unicode block symbol
                    System.out.print('\u2588');
                } else {
                    // whatever else, just draw a blank (we DONT draw starting items from map)
                    System.out.print(' ');
                }
            }

            System.out.print("\n\r");
        }
    }

    // returns if a given cell in the map is walkable or not
    public boolean canGo(int row, int col) {
        return grid[row].charAt(col) != '#';
    }
}



