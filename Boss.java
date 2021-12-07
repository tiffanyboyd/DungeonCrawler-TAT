// Boss.java
/**
* The Boss class includes information regarding a boss object.
*/

import java.util.Random;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import ansi_terminal.*;

public class Boss extends Character {
    private String name;
    private int damage;
    private int protection;
    private static Random rng;
    private boolean bossBattleActive;
    private ArrayList<Integer> damageTypes;

   /**
   * Constructs a Boss enemy object. 
   * @param row sets the row location
   * @param col sets the colomn location
   * @param hp sets the health
   * @param damage  sets the damage enemy can do
   * @param protection sets the protection 
   */
   public Boss(String name, int row, int col, int hp, int damage, int protection) {
        super(row, col, '%', Color.RED, hp);
        this.name = name;
        this.damage = damage;
        this.protection = protection;
        this.bossBattleActive = false;
        rng = new Random();
	damageTypes = new ArrayList<Integer>();
	damageTypes.add(12);
	damageTypes.add(10);
	damageTypes.add(15);
    }
    
    /**
    * Reads in a Boss object from a file 
    * @param s Scanner used to read in file
    */
    public Boss(Scanner s, String tempName){
	super(0, 0, '%', Color.RED, 50);
	name = tempName;
	row = s.nextInt();
	col = s.nextInt();
	hp = s.nextInt();
	damage = s.nextInt();
	protection = s.nextInt();
	rng = new Random();
	damageTypes = new ArrayList<Integer>();
	damageTypes.add(12);
	damageTypes.add(10);
	damageTypes.add(15);
    }

    @Override
    public int getDamage() {
	int n = rng.nextInt(3);
        return damageTypes.get(n);
    }

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
    * Returns true if the Boss is in combat.
    */
    public void setBossBattleActive() {
        bossBattleActive = true;
    }

    // randomly move this enemy in the room
    /**
    * Randomly moves the Boss enemy within the room.
    * @param room the room the Boss is in
    */
    public void walk(Room room) {
        // if a battle is active with this enemy, they DONT walk right after
        if (bossBattleActive) {
            bossBattleActive = false;
            return;
        }

         while (true) {
            int choice = rng.nextInt(4);
            switch (choice) {
                case 0:
                    if (move(0, 1, room)) return;
                    break;
                case 1:
                    if (move(0, -1, room)) return;
                    break;
                case 2:
                    if (move(1, 0, room)) return;
                    break;
                case 3:
                    if (move(-1, 0, room)) return;
                    break;
            }
        }
     }

     /**
     * Saves the Boos enemy within a file.
     * @param pw PrintWrtier saves the texts to file
     */
     public void save(PrintWriter pw){
	pw.println(getName());
	pw.println(getRow());
	pw.println(getCol());
	pw.println(getHealth());
	pw.println(getDamage());
	pw.println(getProtection());
    }

    
}
