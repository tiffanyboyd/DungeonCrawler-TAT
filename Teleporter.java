import ansi_terminal.*;
  import java.io.PrintWriter;
  import java.util.Scanner;
 
 
  public class Teleporter extends Entity{
	private int row;
	private int col; 
	private String filler;
    /**
    * Constructs a teleporter and holds location.
    * @param row the row to set the teleporter
    * @param col the column to set the teleporter
    */
    public Teleporter(int row, int col) {
          super(row, col, '^', Color.CYAN);
    }
 
       /**
       * Saves the Teleporter location within a file.
       * @param pw PrintWriter saves the text to a file.
       */
       public void save(PrintWriter pw){
	  pw.println("This is a teleporter");
          pw.println(getRow());
          pw.println(getCol());
      }
 
      /**
      *Reads in teleporters from a file.
      * @param in Scanner used to read in files.
      */
      public Teleporter(Scanner in, String tag){
        super(0, 0, '^', Color.CYAN);
	filler = tag;
        row = in.nextInt();
        col = in.nextInt();
      }
 }


