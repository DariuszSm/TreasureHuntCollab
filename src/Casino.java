import java.util.Scanner;

public class Casino {
    private Scanner s;
    private int wagerAmount;

    public Casino() {
        s = new Scanner(System.in);
    }

    public boolean playGame(Hunter hunter) {
        System.out.println("Welcome to the Casino!");
        System.out.print("Enter your wager!: ");
        String wagerStr = s.nextLine();
        wagerAmount = Integer.parseInt(wagerStr);

        if (wagerAmount > hunter.getGold()) {
            System.out.println("Wager too low!");
        } else {
            System.out.println("Wager set!");
        }
    }
}
