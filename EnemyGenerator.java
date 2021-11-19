// EnemyGenerator.java
// this class contains a static method for creating enemies randomly
import java.util.ArrayList;
import java.util.Random;

public class EnemyGenerator {

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
	enemies.add(new Enemy("Mutated Biomorph", row, col, 50, 10, 6));
	enemies.add(new Enemy("Mutated Biomorph", row, col, 50, 10, 6));
	enemies.add(new Enemy("Mutated Biomorph", row, col, 50, 10, 6));
	enemies.add(new Enemy("Mutated Biomorph", row, col, 50, 10, 6));
	enemies.add(new Enemy("Heavily Mutated Biomorph", row, col, 80, 20, 10));
	enemies.add(new Enemy("Heavily Mutated Biomorph", row, col, 80, 20, 10));

	int n = rng.nextInt(15);
	return enemies.get(n);
    }
}

