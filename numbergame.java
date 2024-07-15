import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int attemptsLimit = 10;
        System.out.println("Enter the number of rounds:");
        int rounds = sc.nextInt();
        int totalScore = 0;

        System.out.println("Welcome to Number Game!");
        System.out.println("You have " + rounds + " rounds to play.");
        System.out.println("You will get points based on the number of attempts.");

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(max -1 + 1) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nRound " + round + " starts!");
            System.out.println("Guess the number between 1 and 100");

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("You've guessed the number.");
                    guessed = true;
                    totalScore += (attemptsLimit - attempts + 1); 
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("The number is higher than your guess" );
                } else {
                    System.out.println("The number is lower than your guess");
                }
            }

            if (!guessed) {
                System.out.println("Sorry! You've used all attempts. The number was " + numberToGuess);
            }

            System.out.println("You scored " + (guessed ? (attemptsLimit - attempts + 1) : 0) + " points in this round.");
        }

        System.out.println("\nGame Over! Your total score is: " + totalScore);
        
}
}