// ItemGenerator.java
// this class contains a static method for creating items randomly

import java.util.Random;
import java.util.ArrayList;
public class ItemGenerator {
    private static Random rng = new Random();
    public static Item generate() {
	ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(ItemType.Weapon, "Flamethrower", 2, 30,25));
        items.add(new Item(ItemType.Armor, "Crew Uniform", 1, 25, 10));
        items.add(new Item(ItemType.Other, "Medipack", 1, 4, 13));
        items.add(new Item(ItemType.Weapon, "Stun Baton", 4, 69, 10));
        items.add(new Item(ItemType.Armor, "Normal Suit", 1, 20, 14));
        items.add(new Item(ItemType.Other, "Dehydrated Rations", 2, 40, 0));
        items.add(new Item(ItemType.Weapon, "Metal Pipe", 2, 40, 7));
        items.add(new Item(ItemType.Weapon, "OmniWrench", 2, 20, 11));
        items.add(new Item(ItemType.Other, "Astronaught Ice Cream", 3, 3, 15));
        items.add(new Item(ItemType.Armor, "Hostile Enviornment Suit", 1, 50, 17));
        items.add(new Item(ItemType.Weapon, "Net Launcher", 1, 15, 20));
        items.add(new Item(ItemType.Armor, "Industrial Exosuit", 1, 60, 20));
        items.add(new Item(ItemType.Weapon, "Fire Extinguisher", 1, 25, 12));
        items.add(new Item(ItemType.Other, "Motion Sensor", 0, 10, 100));
        items.add(new Item(ItemType.Other, "Hover Light", 4, 30, 40));

        int n = rng.nextInt(15);
        return items.get(n);
    }
}

