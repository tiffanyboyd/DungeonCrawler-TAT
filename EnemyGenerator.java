// EnemyGenerator.java
// this class contains a static method for creating enemies randomly
import java.util.ArrayList;
import java.util.Random;
/**
 * Enemy Generator returns a random enemy from a list of 3 different options,
 * there's more of the weaker enemies and fewer of the stronger ones to give
 * the game more balance.
 */
public class EnemyGenerator {
	/**
	 * Enemy Generator creates an ArrayList and returns an enemy from it using a random int
	 */
    private static Random rng = new Random(); 

    public static Enemy generate(int row, int col) {
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        enemies.add(new Enemy("Biomorph", row, col, 20, 5, 3));
	enemies.add(new Enemy("Biomorph", row, col, 20, 5, 3));
 	enemies.add(new Enemy("Biomorph", row, col, 20, 5, 3));
 	enemies.add(new Enemy("Biomorph", row, col, 20, 5, 3));
 	enemies.add(new Enemy("Biomorph", row, col, 20, 5, 3));
 	enemies.add(new Enemy("Biomorph", row, col, 20, 5, 3));
 	enemies.add(new Enemy("Biomorph", row, col, 20, 5, 3));
 	enemies.add(new Enemy("Biomorph", row, col, 20, 5, 3));
	enemies.add(new Enemy("Biomorph", row, col, 20, 5, 3));
	enemies.add(new Enemy("Mutated_Biomorph", row, col, 30, 10, 6));
	enemies.add(new Enemy("Mutated_Biomorph", row, col, 30, 10, 6));
	enemies.add(new Enemy("Mutated_Biomorph", row, col, 30, 10, 6));
	enemies.add(new Enemy("Mutated_Biomorph", row, col, 30, 10, 6));
	enemies.add(new Enemy("Heavily_Mutated_Biomorph", row, col, 40, 15, 9));
	enemies.add(new Enemy("Heavily_Mutated_Biomorph", row, col, 40, 15, 9));

	int n = rng.nextInt(15);
	return enemies.get(n);
    }
}

