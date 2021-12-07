import ansi_terminal.*;
import java.io.PrintWriter;
import java.util.Scanner;

/**
* Teleporter class
*/
public class Teleporter extends Entity{

  /**
  * Constructs a teleporter and holds location
  * @param row the row to set the teleporter
  * @param col the column to set the teleporter
  */
  public Teleporter(int row, int col) {
	super(row, col, '^', Color.CYAN);
  }
     
     /**
     * Saves the Teleporter location within a file
     * @param pw PrintWriter saves the text to a file
     */
     public void save(PrintWriter pw){
	pw.println(getRow());
	pw.println(getCol());
    }

    /**
    *Reads in teleporters from a file
    * @param in Scanner used to read in files
    */

    public Teleporter(Scanner in){
      super(0, 0, '^', Color.CYAN);
      row = in.nextInt();
      col = in.nextInt();
    }

 

}
