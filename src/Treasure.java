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
     * findTreasures() method will randomize a number 1-4 in order to randomly choose which treasure the
     * user finds or if the user doesn't find any treasure. Each option has a 25% chance.
     * @return a String that tells the user they either found a specific treasure or that they didn't find
     * any.
     */
    public static String findTreasure()
    {
        int randomChance = (int) (Math.random() * 4) + 1;
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
        else
        {
            return null;
        }
    }
}
