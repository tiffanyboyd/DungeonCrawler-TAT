// Box.java
// represents a pickup-able item
import java.io.PrintWriter;
import java.util.Scanner;
import ansi_terminal.*;
public class Box extends Entity {
    // the Item that is in the box
    private Item item;
    private int row;
    private int col;
    private String filler;

    // add a box with a given item in it
    public Box(int row, int col, Item item) {
        super(row, col, 'i', Color.MAGENTA);
        this.item = item;
    }
    
    public Box(Scanner s){
	super(0, 0, 'i', Color.MAGENTA);
	//System.out.println(filler);
	//filler = tag;
	row = s.nextInt();
	col = s.nextInt();
	ItemType type = ItemType.valueOf(s.next());
	String itemName = s.next();
	int itemWeight = s.nextInt();
	int itemValue = s.nextInt();
	int itemStrength = s.nextInt();
	item = new Item(type, itemName, itemWeight, itemValue, itemStrength);
    }
    public Item getItem() {
        return item;
    }

    /**
    * Saves the the boxes withing the room player is currently in.
    * @param pw PrintWriter used to write text to file
    */
    public void save(PrintWriter pw){
	pw.println("this_is_a_box");
	pw.println(getRow());
	pw.println(getCol());
	Item tempItem = getItem();
	pw.println(tempItem.getType());
	pw.println(tempItem.getName());
	pw.println(tempItem.getWeight());
	pw.println(tempItem.getValue());
	pw.println(tempItem.getStrength());
    }
    
    
}
