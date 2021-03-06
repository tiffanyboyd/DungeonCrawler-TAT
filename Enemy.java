// Enemy.java
import java.util.Scanner;
import java.util.Random;
import java.io.PrintWriter;
import ansi_terminal.*;

public class Enemy extends Character {
    private String name;
    private int damage;
    private int protection;
    private static Random rng;
    private boolean battleActive;

    public Enemy(String name, int row, int col, int hp, int damage, int protection) {
        super(row, col, '*', Color.RED, hp);
        this.name = name;
        this.damage = damage;
        this.protection = protection;
        this.battleActive = false;
        rng = new Random();
    }

    
    @Override
    public int getDamage() {
        return damage;
    }

   @Override
    public int getProtection() {
        return protection;
    }

   @Override
    public String getName() {
        return name;
    }

   public void setBattleActive() {
        battleActive = true;
    }

    // randomly move this enemy in the room
    public void walk(Room room) {
        // if a battle is active with this enemy, they DONT walk right after
        if (battleActive) {
            battleActive = false;
            return;
        }

        // loop forever until we move correctly
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
     * Saves the enemy stats and writes texts to file.
     * @param pw PrintWriter used to write text to a file.
     */
     public void save(PrintWriter pw){
	pw.println(getName());
	pw.println(getRow());
	pw.println(getCol());
	pw.println(getHealth());
	pw.println(getDamage());
	pw.println(getProtection());
    }
    

    /**
    * Reads in Enemy stats from a file
    * @param in Scanner used to read in file
    */
    public Enemy(Scanner in, String name){
      super(0,0,'*',Color.BLUE,50);
      name = name;
      System.out.println(name + ": is the name");
      row = in.nextInt();
      col = in.nextInt();
      hp = in.nextInt();
      damage = in.nextInt();
      protection = in.nextInt();
    }
    
}


