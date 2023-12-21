import java.util.Scanner;

public class Casino {
    private Scanner s;
    private int wagerAmount;


    public Casino() {
        s = new Scanner(System.in);
    }

    /**
     * playGame method that first decides whether the Hunter will be able to gamble depending on their wager amount
     * and current gold.
     * If they can gamble, the method will simulate a game of Lucky Dice and return gold based on how close their guess is
     * to the actual roll.
     * @param hunter instance, represents the player
     * @return boolean that represents whether the game was played
     */
    public boolean playGame(Hunter hunter) {
        System.out.println("Welcome to the Casino!");
        System.out.print("Enter your wager!: ");
        String wagerStr = s.nextLine();
        wagerAmount = Integer.parseInt(wagerStr);

        if (wagerAmount > hunter.getGold()) {
            System.out.println("Wager too high! You don't have enough gold to bet this amount.");
            return false;
        }
        else {
            int winnings = 0;
            hunter.changeGold(wagerAmount * -1);
            System.out.println("Wager set!");
            System.out.println("We're going to be playing Lucky Dice! We are going to roll 2 dice, and you have to guess the roll!");
            System.out.println("What is your guess?: ");
            String guessStr = s.nextLine();
            int guess = Integer.parseInt(guessStr);
            int dice1 = (int) (Math.random()*6 + 1);
            int dice2 = (int) (Math.random()*6 + 1);
            int rollSum = dice1 + dice2;

            System.out.println("The amount rolled is " + rollSum + "!");
            if (guess == rollSum)
            {
                System.out.println("You won! You gain double your wager gold!");
                winnings = wagerAmount * 2;
            }
            else if ((guess - 2 == rollSum) || (guess + 2 == rollSum) || (guess - 1 == rollSum) || (guess + 1 == rollSum))
            {
                System.out.println("You kind of won! Here's your wager back.");
                winnings = wagerAmount;
            }
            else
            {
                System.out.println("You lost your wagered gold!");
            }
            hunter.changeGold(winnings);
            hunter.changeCasinoNetGain(winnings - wagerAmount);
            return true;
        }
    }
}
