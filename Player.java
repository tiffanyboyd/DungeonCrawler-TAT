// Player.java

import ansi_terminal.*;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
public class Player extends Character {
    private Inventory items;

    public Player(Position start) {
        // our starting details
        super(start.getRow(), start.getCol(), '@', Color.CYAN, 50);

        // we can carry 100 pounds of items
        items = new Inventory(100);

        // give them some basic stuff to start with
        items.addAndEquip(new Item(ItemType.Weapon, "Stun_Baton", 5, 12, 11));
        items.addAndEquip(new Item(ItemType.Armor, "Crew_Uniform", 15, 20, 3));
    }

    /**
    * Reads in Player stats saved within a file.
    * @param s Scanner used to read in from file
    */
    public Player(Scanner s){
	super(0, 0, '@', Color.CYAN, 50);
	row = s.nextInt();
	System.out.println(row);
	col = s.nextInt();
	System.out.println(col);
	hp = s.nextInt();
	items = new Inventory(100);
	//ItemType type = s.next();
	int i = 0;
	while(i<2){
		String iType = s.next();
	        ItemType type = null;
		switch(iType){
			case("Weapon"):
				type = ItemType.Weapon;
				break;
			case("Armor"):
				type = ItemType.Armor;
				break;
			case("Other"):
				type = ItemType.Other;
				break;
		}
		System.out.println(iType);
		String name = s.next();
		System.out.println(name + ": is the name");
		int weight = s.nextInt();
		int value = s.nextInt();
		int strength = s.nextInt();
		items.addAndEquip(new Item(type, name, weight, value, strength));
		i++;
	}
	String next = s.next();
	while (!next.equals(".")) {
		String iType = s.next();
		ItemType type = null;
		switch(iType){
			case("Weapon"):
				type = ItemType.Weapon;
				break;
			case("Armor"):
				type = ItemType.Armor;
				break;
			case("Other"):
				type = ItemType.Other;
				break;
		}
		String name = s.next();
		int weight = s.nextInt();
		int value = s.nextInt();
		int strength = s.nextInt();
		items.add(new Item(type, name, weight, value, strength));
		next = s.next();
	}	
    }

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

    /**
    * Saves the players location, stats, and inventory.
    * @param pw PrintWriter saves text to file
    */
    public void save(PrintWriter pw){
        ArrayList<Item> listOfItems = items.getInventoryList();
	pw.println(getRow());
	pw.println(getCol());
	pw.println(getHealth());
//	pw.println(getDamage());
//	pw.println(getProtection());
	pw.println(items.getEquippedWeapon().getType());
	pw.println(items.getEquippedWeapon().getName());
	pw.println(items.getEquippedWeapon().getWeight());
	pw.println(items.getEquippedWeapon().getValue());
	pw.println(items.getEquippedWeapon().getStrength());
	pw.println(items.getEquippedArmor().getType());
	pw.println(items.getEquippedArmor().getName());
	pw.println(items.getEquippedArmor().getWeight());
	pw.println(items.getEquippedArmor().getValue());
	pw.println(items.getEquippedArmor().getStrength());

	int i = 0;
	while(i < listOfItems.size()){
		pw.println(listOfItems.get(i).getType());
		pw.println(listOfItems.get(i).getName());
		pw.println(listOfItems.get(i).getWeight());
		pw.println(listOfItems.get(i).getValue());
		pw.println(listOfItems.get(i).getStrength());
		i++;
	}
	pw.println(".");
//	pw.close();
    }
}

