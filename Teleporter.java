import ansi_terminal.*;
import java.io.PrintWriter;
public class Teleporter extends Entity{

  public Teleporter(int row, int col) {
	super(row, col, '^', Color.CYAN);
  }
     public void save(PrintWriter pw){
	pw.println(getRow());
	pw.println(getCol());
    }

}
