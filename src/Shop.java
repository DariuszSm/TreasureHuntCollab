/**
 * The Shop class controls the cost of the items in the Treasure Hunt game.<p>
 * The Shop class also acts as a go between for the Hunter's buyItem() method.<p>
 */
import java.util.Scanner;

public class Shop
{
    // constants
    private static final int WATER_COST = 2;
    private static final int ROPE_COST = 4;
    private static final int MACHETE_COST = 6;
    private static final int HORSE_COST = 12;
    private static final int BOAT_COST = 20;
    private static final int CHEAT_COST = 1;

    // instance variables
    private double markdown;
    private Hunter customer;

    //Constructor j
    public Shop(double markdown)
    {
        this.markdown = markdown;
        customer = null;
    }

    /** method for entering the shop
     * @param hunter  the Hunter entering the shop
     * @param buyOrSell  String that determines if hunter is "B"uying or "S"elling
     */
    public void enter(Hunter hunter, String buyOrSell)
    {
        customer = hunter;

        Scanner scanner = new Scanner(System.in);
        if (buyOrSell.equals("B") || buyOrSell.equals("b"))
        {
            System.out.println("Welcome to the shop! We have the finest wares in town.");
            System.out.println("Currently we have the following items:");
            System.out.println(inventory());
            System.out.print("What're you lookin' to buy? (Type name of item or option #)");
            String item = scanner.nextLine();
            item = formatItemString(item);
            int cost = checkMarketPrice(item, true);
            if (cost == 0)
            {
                System.out.println("We ain't got none of those.");
            }
            else
            {
                System.out.print("It'll cost you " + cost + " gold. Buy it (y/n)? ");
                String option = scanner.nextLine();

                if (option.equals("y") || option.equals("Y"))
                {
                    buyItem(item);
                }
            }
        }
        else
        {
            System.out.println("What're you lookin' to sell? ");
            System.out.print("You currently have the following items: " + customer.getInventory());
            String item = scanner.nextLine();
            int cost = checkMarketPrice(item, false);
            if (cost == 0)
            {
                System.out.println("We don't want none of those.");
            }
            else
            {
                System.out.print("It'll get you " + cost + " gold. Sell it (y/n)? ");
                String option = scanner.nextLine();

                if (option.equals("y") || option.equals("Y"))
                {
                    sellItem(item);
                }
            }
        }
    }

    /** A method that returns a string showing the items available in the shop (all shops sell the same items)
     *
     * @return  the string representing the shop's items available for purchase and their prices
     */
    public String inventory()
    {
        String str = "";
        if (customer.getDifficultyLevel().equals("Cheat"))
        {
            str = "-----\nOption 1 | Water | " + CHEAT_COST + " gold\n-----\n";
            str += "Option 2 | Rope | " + CHEAT_COST + " gold\n-----\n";
            str += "Option 3 | Machete | " + CHEAT_COST + " gold\n-----\n";
            str += "Option 4 | Horse | " + CHEAT_COST + " gold\n-----\n";
            str += "Option 5 | Boat | " + CHEAT_COST + " gold\n-----\n";
        }

        else
        {
            str = "-----\nOption 1 | Water | " + WATER_COST + " gold\n-----\n";
            str += "Option 2 | Rope | " + ROPE_COST + " gold\n-----\n";
            str += "Option 3 | Machete | " + MACHETE_COST + " gold\n-----\n";
            str += "Option 4 | Horse | " + HORSE_COST + " gold\n-----\n";
            str += "Option 5 | Boat | " + BOAT_COST + " gold\n-----\n";
        }

        return str;
    }

    /**
     * Formats the string used for item comparison and adding/selling
     * @param input The input to be formatted
     * @return A formatted item name
     */
    public String formatItemString(String input) {
        if (input.equals("1")) {
            input = "Water";
        }
        else if (input.equals("2")) {
            input = "Rope";
        }
        else if (input.equals("3")) {
            input = "Machete";
        }
        else if (input.equals("4")) {
            input = "Horse";
        }
        else if (input.equals("5")) {
            input = "Boat";
        }

        // turn item name to title format
        return input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
    }

    /**
     * A method that lets the customer (a Hunter) buy an item.
     * @param item The item being bought.
     */
    public void buyItem(String item)
    {
        int costOfItem = checkMarketPrice(item, true);
        if (customer.buyItem(item, costOfItem))
        {
            System.out.println("Ye' got yerself a " + item + ". Come again soon.");
        }
        else
        {
            System.out.println("Hmm, either you don't have enough gold or you've already got one of those!");
        }
    }

    /**
     * A pathway method that lets the Hunter sell an item.
     * @param item The item being sold.
     */
    public void sellItem(String item)
    {
        int buyBackPrice = checkMarketPrice(item, false);
        if (customer.sellItem(item, buyBackPrice))
        {
            System.out.println("Pleasure doin' business with you.");
        }
        else
        {
            System.out.println("Stop stringin' me along!");
        }
    }

    /**
     * Determines and returns the cost of buying or selling an item.
     * @param item The item in question.
     * @param isBuying Whether the item is being bought or sold.
     * @return The cost of buying or selling the item based on the isBuying parameter.
     */
    public int checkMarketPrice(String item, boolean isBuying)
    {
        if (isBuying)
        {
            return getCostOfItem(item);
        }
        else
        {
            return getBuyBackCost(item);
        }
    }

    /**
     * Checks the item entered against the costs listed in the static variables.
     *
     * @param item The item being checked for cost.
     * @return The cost of the item or 0 if the item is not found.
     */
    public int getCostOfItem(String item)
    {
        if (customer.getDifficultyLevel().equals("Cheat"))
        {
            return CHEAT_COST;
        }
        else if (item.equalsIgnoreCase("Water") || item.equals("1"))
        {
            return WATER_COST;
        }
        else if (item.equalsIgnoreCase("Rope") || item.equals("2"))
        {
            return ROPE_COST;
        }
        else if (item.equalsIgnoreCase("Machete") || item.equals("3"))
        {
            return MACHETE_COST;
        }
        else if (item.equalsIgnoreCase("Horse") || item.equals("4"))
        {
            return HORSE_COST;
        }
        else if (item.equalsIgnoreCase("Boat") || item.equals("5"))
        {
            return BOAT_COST;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Checks the cost of an item and applies the markdown.
     *
     * @param item The item being sold.
     * @return The sell price of the item.
     */
    public int getBuyBackCost(String item)
    {
        int cost = (int)(getCostOfItem(item) * markdown);
        return cost;
    }
}