// EnemyGenerator.java
// this class contains a static method for creating enemies randomly
import java.util.ArrayList;
import java.util.Random;

public class EnemyGenerator {

    private static Random rng = new Random(); 

    public static Enemy generate(int row, int col) {
	ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        enemies.add(Enemy("Alien", row, col, 20, 5, 3));
	enemies.add(Enemy("Big Alien", row, col, 50, 10, 6));
	enemies.add(Enemy("Really Big Alien", row, col, 80, 20, 10);

	int n = rng.nextInt(3);
	return enemies.get(n);
    }
}

