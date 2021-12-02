// Room.java
// provides code for the drawing of a room
// also provides starting locations for the player, boxes, teleporters and enemies
import java.io.FileInputStream;
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
    private int baseCase;
    private int roomNumber;
    //this constructor takes in a scanner assigned to a file and reads it into an Array the rest of the game can work with, also gets its rows and cols
    public Room(Scanner s, int roomNumber) {
      this.roomNumber = roomNumber;
      rows = s.nextInt();
      cols = s.nextInt();
       //int size = rows * cols; 
       //String next = s.nextLine();
       grid = new String[rows];
       int row = 0;
      // while (!next.equals(".")){
	while(row < rows){
         grid[row]= s.nextLine();
	 //rows++;
	 //cols++;
	 row++;
	 //System.out.println(grid[row]);
	//grid.add(desc + next + "\n");
        // next = s.nextLine();
       }
	System.out.println(grid);
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
        for (int row = 1; row < rows; row++) {
            for (int col = 1;  col < cols; col++) {
                if (grid[row].charAt(col) == '@') {
                    return new Position(row, col);
                }
            }
        }
        System.out.println("null :(");
        return null;
    }
    // returns the players starting location in this room in the form of an int
    public int getPlayerStartRow() {
        for (int row = 1; row < rows; row++) {
            for (int col = 1;  col < cols; col++) {
                if (grid[row].charAt(col) == '@') {
                    return row;
                }
            }
        }
        return 0;
    }
    // returns the players starting location in this room in the form of an int
    public int getPlayerStartCol() {
        for (int row = 1; row < rows; row++) {
            for (int col = 1;  col < cols; col++) {
                if (grid[row].charAt(col) == '@') {
                    return col;
                }
            }
        }
        return 0;
    }

    // returns a set of item boxes for this map, this is here because it depends on
    // the room geometry for where the boxes make sense to be
    public ArrayList<Box> getBoxes() {
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (grid[row].charAt(col) == 'i') {
                    boxes.add(new Box(row, col, ItemGenerator.generate()));
                }
            }
        }

        return boxes;
    }

    //Returns a set of teleporters for this map, depends on room geometry
    public ArrayList<Teleporter> getTeleporters() {
	ArrayList<Teleporter> teles = new ArrayList<Teleporter>();
	for (int row = 1; row < rows; row++) {
	    for(int col = 1; col < cols; col++) {
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
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
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

    public int getRoomNumber() {
	return roomNumber;
    }

    // draws the map to the screen
    public void draw() {
        Terminal.clear();
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
		//System.out.print("checking row: " + row + "and col: " + col + " now \n\r");
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

