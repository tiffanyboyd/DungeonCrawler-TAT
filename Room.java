// Room.java
// provides code for the drawing of a room
// also provides starting locations for the player, boxes, teleporters and enemies
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import ansi_terminal.*;


/**
* Room provides code for the drawing of a room
* Also provides starting location for the player, boxes, teleporters, and enemies.
*/
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
    /**
    * Takes in a scanner assigned to a file and reads it into an Array the rest of the game can work with,
    * also gets its rows and cols
    * @param s Scanner to take in file
    * @param roomNumber the roomNumber  assigned to a room
    */
    public Room(Scanner s, int roomNumber) {
      roomNumber = s.nextInt();
      rows = s.nextInt();
      cols = s.nextInt();
      s.nextLine();
       desc ="";
       grid = new String[rows];
       int row = 0;
	while(row < rows){
         grid[row]= s.nextLine();
	 row++;

       }
	System.out.println(grid);
     }
     public Room(Scanner s){
	roomNumber = s.nextInt();
	rows = s.nextInt();
	System.out.println(rows);
	cols = s.nextInt();
	System.out.println(cols);
	s.nextLine();
	grid = new String[rows];
	int row = 0;
	while(row < rows){
	   grid[row]= s.nextLine();
	   row++;
	}
	 System.out.println(grid.toString());
     }
    // returns the player's strting location in this room
    /**
    * Returns the Player's starting location in this room
    */
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
    /**
    * Returns the players starting row location in this room in the form of an integer
    */
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
    /**
    * Returns the player's starting column location in this room in the form of an integer
    */
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
    /**
    * Returns a set of item boxes for this map
    */
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
    /**
    *Returns a set of teleporters for this map, depends on room geometry
    */
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
    /**
    *Returns a set of enemies from this map, similarly to the boxes
    */
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
    
    public ArrayList<Boss> getBosses() {
        ArrayList<Boss> bosses = new ArrayList<Boss>();
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (grid[row].charAt(col) == '%') {
                    bosses.add(new Boss("Biomorph-Lord",row, col, 100, 9, 9));
                }
            }
        }

        return bosses;
    }
    
    /**
    * Returns the row location of the room
    */
    public int getRows() {
        return rows;
    }

    /**
    * Returns the column location of the room
    */
    public int getCols() {
        return cols;
    }

    /**
    * Returns the room number
    */
    public int getRoomNumber() {
	return roomNumber;
    }
    
    public void setRoomNumber(int newNum){
	roomNumber = newNum;
    }
    // draws the map to the screen
    /**
    * Draws the map to the screen
    */
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
    /**
    * Returns if a given cell in the map is walkable or not
    */
    public boolean canGo(int row, int col) {
        return grid[row].charAt(col) != '#';
    }
    
    /**
    * Saves the room in a text file
    * @param pw used to print text to a file.
    */
    public void save(PrintWriter pw){
	 pw.println(roomNumber);
	 pw.println(rows);
	 pw.println(cols);
	 for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char cell = grid[row].charAt(col);
                if (cell == '#') {
                    // a unicode block symbol
                    pw.print('\u2588');
                } else {
                    // whatever else, just draw a blank (we DONT draw starting items from map)
                    pw.print(' ');
                }
            }

	    pw.println();
        }
    }
}

