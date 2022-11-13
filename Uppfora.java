import java.util.Scanner;
import java.util.Random;

public class Uppfora {
	// Jennifer Vaughn
	// CIS 1068, Section 1
	// 9/26/22
	// Assignment 4: a game
	/* This program will allow the user to play the game
		of Uppföra against the computer. */
	
	
	/* Outline:
		Print rules.
		Ask user if they want to play.
		Checks if user's response is valid and ask to correct it if not.
		While user wants to play:
		- Ask user to enter their move
		- Check that user's chosen move is valid and ask to correct it if not
		- Generate a random move for the computer
		- Use conditionals to decide who wins and loses. If computer wins, it's a tie.
		- For every round, print user move, computer move, and the winner
		- At end of each round, ask if user still wants to play
		...If user inputs 'y', while loop should repeat.
		...If user inputs 'n', print the number of rounds, user wins, and computer wins. */
	
	
	public static Scanner CONSOLE = new Scanner(System.in);
	public static Random rand = new Random();
	

	public static void main(String[] args) {
		// Introduction:
		System.out.println("Welcome to the game of Uppfora!");
		System.out.println();
		System.out.println("For each round, you and the computer will both choose a move from the following:");
		System.out.println("Skadis, Tjusig, Klyket, Hovolm, or Pershult");
		System.out.println();
		// Rules:
		System.out.println("- Pershult beats Klyket & Skadis");
		System.out.println("- Klyket beats Tjusig & Hovolm");
		System.out.println("- Tjusig beats Pershult & Skadis");
		System.out.println("- Skadis beats Hovolm & Klyket");
		System.out.println("- Hovolom beats Pershult & Tjusig");
		System.out.println();
		//Play:
		playRound();
	}
		
	

	
	
	
	
	public static void playRound()	{
		//Ask user if they want to play
		System.out.println("Would you like to play a round? Type 'y' or 'n': ");
		String play = CONSOLE.nextLine();
		play = validResponse(play);			//Checks if user's 'y' or 'n' response is valid
		
		
			
		//Setting up int variables
		int numRounds = 0;
		int userWins = 0;
		int compWins = 0;
		
		
		
		
		//While user says they want to play:
		while(play.equals("y"))	{
			numRounds += 1;
			
			//Declaring variables
			String compChoice = "";
			String winner = "";
			
			//User enters their move
			System.out.println("Enter your move: ");
			String userChoice = CONSOLE.nextLine();
			userChoice = ValidChoice(userChoice);
			
			//Random computer move
			compChoice = compRandChoice();
				
			//Echoing user and computer moves
			System.out.println("Your move is " + userChoice);
			System.out.println("The computer's move is " + compChoice);
				
			//Execute the game with rules
			winner = Game(userChoice, compChoice);
			
			if(winner.equals("user"))	{
				userWins += 1;
			}
			if(winner.equals("computer"))	{
					compWins += 1;
				}
			
			//State the winner of the game
			System.out.println("The winner is the " + winner);
				
			//Ask user if they want to play again	
			System.out.println();
			System.out.println("Would you like to play again? Type 'y' or 'n': ");
			play = CONSOLE.nextLine();
			play = validResponse(play);
			
		}
			
		//Once the game ends:
		System.out.println("");
		System.out.println("Thanks for playing!");
		System.out.println("- Rounds played: " + numRounds);
		System.out.println("- Times you won: " + userWins);
		System.out.println("- Times the computer won: " + compWins);
	}
	
	
	
	
	
	
	
	
	
	public static String validResponse(String play)	{
		play = play.toLowerCase();
		while (!play.equals("y") && !play.equals("n")) {
			System.out.println("Invalid response. Enter 'y' or 'n': ");
			play = CONSOLE.nextLine();
			play = play.toLowerCase();
		}
		return play;
	}
	
	
	
	public static String ValidChoice(String userChoice)	{
		while(!userChoice.equalsIgnoreCase("Pershult") && !userChoice.equalsIgnoreCase("Klyket") && !userChoice.equalsIgnoreCase("Tjusig") && !userChoice.equalsIgnoreCase("Skadis") && !userChoice.equalsIgnoreCase("Hovolm"))	{
			System.out.println("Invalid response. Enter your move: ");
			userChoice = CONSOLE.nextLine();
		}
		return userChoice;
	}
	
	
	
	public static String compRandChoice()	{
		String array[] = {"Pershult","Klyket","Tjusig","Skadis","Hovolm"};
		String compChoice = array[rand.nextInt(5)];
		return compChoice;
	}
	
	
	
	
	
	
	public static String Game(String userChoice, String compChoice)	{
		String winner = "";
		
		if(userChoice.equalsIgnoreCase("Skadis"))	{
			if(compChoice.equals("Hovolm") || compChoice.equals("Klyket")) {
					winner = "user";
				}
			else	{
				winner = "computer";
			}
		}
		
		if(userChoice.equalsIgnoreCase("Pershult"))	{
			if(compChoice.equals("Klyket") || compChoice.equals("Skadis"))	{
					winner = "user";
				}
			else	{
				winner = "computer";
			}
		}
		
		if(userChoice.equalsIgnoreCase("Klyket"))	{
			if(compChoice.equals("Tjusig") || compChoice.equals("Skadis"))	{
					winner = "user";
				}
			else	{
				winner = "computer";
			}
		}
		
		if(userChoice.equalsIgnoreCase("Hovolm"))	{
			if(compChoice.equals("Pershult") || compChoice.equals("Tjusig"))	{
					winner = "user";
				}
			else	{
				winner = "computer";
			}
		}
		
		if(userChoice.equalsIgnoreCase("Tjusig"))	{
			if(compChoice.equals("Pershult") || compChoice.equals("Skadis"))	{
					winner = "user";
				}
			else	{
				winner = "computer";
			}
		}
		
		return winner;
	}
		
		
	
	
	
}
