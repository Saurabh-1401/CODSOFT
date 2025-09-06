import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int score = 0;
        final int Max_Attempts = 5;
        final int Lower_Bound = 1;
        final int Upper_Bound = 100;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int target = random.nextInt(Upper_Bound - Lower_Bound + 1) + Lower_Bound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n I've picked a number between " + Lower_Bound + " and " + Upper_Bound + ".");
            System.out.println("You have " + Max_Attempts + " attempts. Good luck!");

            while (attempts < Max_Attempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == target) {
                    System.out.println(" Correct! You've guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score += (Max_Attempts - attempts + 1) * 10;
                    break;
                } else if (guess < target) {
                    System.out.println("⬆Too low!");
                } else {
                    System.out.println("⬇Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts! The correct number was: " + target);
            }

            roundsPlayed++;

            System.out.print("\n Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("\n Game Over! You played " + roundsPlayed + " round(s).");
        System.out.println("Final Score: " + score);
        System.out.println("Thanks for playing.");

        scanner.close();
    }
}
