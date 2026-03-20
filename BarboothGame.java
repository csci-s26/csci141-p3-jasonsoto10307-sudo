import java.util.Random;
import java.util.Scanner;

public class BarboothGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("-- Barbooth dice-rolling game with two players --");
        System.out.println();

   
        String player1 = "";
        String player2 = "";
        
        System.out.print("Player 1,please enter your name: ");
        player1 = input.nextLine();
        
        System.out.print("Player 2,please enter your name: ");
        player2= input.nextLine();
        
        String shooter = "";
        String fader = "";
        
        int roll1 = 0;
        int roll2 = 0;
        
    while (roll1 == roll2) {
    	System.out.print(player1 + ", please enter 'r' to roll: ");
    	input.nextLine();
    	roll1 = rollDie(rand);
    	System.out.println(player1 + ": " + roll1);

    	System.out.print(player2 + ", please enter 'r' to roll: ");
    	input.nextLine();
    	roll2 = rollDie(rand);
    	System.out.println(player2 + ": " + roll2);
    }

    if (roll1 > roll2) {
    shooter = player1;
    fader = player2;
    } else {
    shooter = player2;
    fader = player1;
    
    }
   

       
    	System.out.print(shooter + " starts first. Please enter 'r' to roll: ");
        input.nextLine();
    	int die1 = 0;
        int die2 = 0;
        System.out.print(shooter + ": " + die1 + " - " + die2);

       
        if (isWinningRoll(die1, die2)) {
            System.out.println(shooter + " wins!");
        }
        else if (isLosingRoll(die1, die2)) {
            System.out.println(fader + " wins!");
        }
        else {
            System.out.print(fader + ", please enter 'r' to roll: ");
            input.nextLine();

            int f1 = rollDie(rand);
            int f2 = rollDie(rand);

            System.out.println(fader + ": " + f1 + " - " + f2);

            if (isWinningRoll(f1, f2)) {
                System.out.println(fader + " wins!");
            }
            else if (isLosingRoll(f1, f2)) {
                System.out.println(shooter + " wins!");
            }
            else {
                System.out.println("Tie!");
        }
        }
            
            
            input.close();
        }

    public static int rollDie(Random rand) {
        return rand.nextInt(6) + 1; 
    }

    public static boolean isWinningRoll(int die1, int die2) {
        return (die1 == 3 && die2 == 3) ||
        	   (die1 == 5 && die2 == 5) ||
               (die1 == 6 && die2 == 6) ||
               (die1 == 6 && die2 == 5) ||
               (die1 == 5 && die2 == 6);
    }

    public static boolean isLosingRoll(int die1, int die2) {
        return  (die1 == 1 && die2 == 1) ||
                (die1 == 2 && die2 == 2) ||
                (die1 == 4 && die2 == 4) ||
                (die1 == 1 && die2 == 2) ||
                (die1 == 2 && die2 == 1);
    }
}
