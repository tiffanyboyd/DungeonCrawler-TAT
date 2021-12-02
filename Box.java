// Box.java
// represents a pickup-able item

import ansi_terminal.*;
import java.io.PrintWriter;

public class Box extends Entity {
    // the Item that is in the box
    private Item item;

    // add a box with a given item in it
    public Box(int row, int col, Item item) {
        super(row, col, 'i', Color.MAGENTA);
        this.item = item;
    }

    public Item getItem() {
        return item;
    }
     public void save(PrintWriter pw){
	pw.println(getRow());
	pw.println(getCol());
	pw.println(getItem());
    }

}


