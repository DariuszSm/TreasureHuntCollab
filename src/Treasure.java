/**
 * Treasure class which represents the different treasures the hunter can find.
 * The treasures that are available are Diamond Necklace, Gold Watch, and Emerald Earrings (Treasures 1, 2,
 * and 3, respectively)
 */
public class Treasure {
    public static final String TREASURE1 = "Diamond Necklace";
    public static final String TREASURE2 = "Gold Watch";
    public static final String TREASURE3 = "Emerald Earrings";
    public static final int ALL_TREASURE_AMOUNT = 3;

    /**
     * findTreasures() method will randomly choose whether the user finds any treasure based on their luck
     * If they do find a treasure, there is a 33% chance for each unique treasure
     * @return a String that tells the user they either found a specific treasure or that they didn't find
     * any.
     */
    public static String findTreasure(int luck)
    {
        if (Math.random() > (luck/ 100.0))
        {
            return null;
        }

        int randomChance = (int) (Math.random() * 3) + 1;
        if (randomChance == 1)
        {
            return TREASURE1;
        }
        else if (randomChance == 2)
        {
            return TREASURE2;
        }
        else if (randomChance == 3)
        {
            return TREASURE3;
        }
        return null;
    }
}
