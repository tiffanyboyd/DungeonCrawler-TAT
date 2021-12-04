// Player.java

import ansi_terminal.*;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Player extends Character {
    private Inventory items;

    public Player(Position start) {
        // our starting details
        super(start.getRow(), start.getCol(), '@', Color.CYAN, 50);

        // we can carry 100 pounds of items
        items = new Inventory(100);

        // give them some basic stuff to start with
        items.addAndEquip(new Item(ItemType.Weapon, "Stun Baton", 5, 12, 11));
        items.addAndEquip(new Item(ItemType.Armor, "Crew Uniform", 15, 20, 3));
    }

//    public Player(Scanner s){
//	row = s.nextInt();
//	col = s.nextInt();
//	hp = s.nextInt();
//	equippedWeapon = s.nextInt();
	
  //  }

    @Override
    public int getDamage() {
        Item weapon = items.getEquippedWeapon();
        if (weapon != null) {
            return weapon.getStrength();
        } else {
            // if we have no weapon, our fists are pretty weak...
            return 1;
        }
    }

    @Override
    public String getName() {
        return "Player";
    }

    @Override
    public int getProtection() {
        Item armor = items.getEquippedArmor();
        if (armor != null) {
            return armor.getStrength();
        } else {
            // without armor, we have no protection
            return 0;
        }
    }

    public Inventory getInventory() {
        return items;
    }

//    public void setPosition(Position newLocation){
//	this.start = newLocation;
//    }
//    public setRow(int row){
//	this.row = row;
//    }

//    public setCol(int col){
//	this.col = col;
//    }

    public void save(PrintWriter pw){
        ArrayList listOfItems = items.getInventoryList();
	pw.println(getRow());
	pw.println(getCol());
	pw.println(getHealth());
//	pw.println(getDamage());
//	pw.println(getProtection());
	pw.println(items.getEquippedWeapon());
	pw.println(items.getEquippedArmor());
	int i = 0;
	while(i < listOfItems.size()){
		pw.println(listOfItems.get(i));
		i++;
	}
//	pw.close();
    }
}

