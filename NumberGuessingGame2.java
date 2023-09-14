import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;

        int maxAttempts = 10;
        int rounds = 1;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game...!");
        boolean playAgain = true;

        while (playAgain) {

            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("\nRound " + rounds  + " - Guess the number between " + minRange + " and " + maxRange);

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;


                if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    guessedCorrectly = true;
                    break;
                }
            }


            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber);
            }

            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            if (playAgainChoice.equals("no")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame over! You played " + rounds + " rounds and your total score is " + score);
    
    }
}
