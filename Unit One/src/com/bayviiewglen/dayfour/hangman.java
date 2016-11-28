package com.bayviiewglen.dayfour;
import java.util.Scanner;

public class hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean finishedGame = false; 
		Scanner scanner = new Scanner (System.in);
		String okCharacters = "ABCDEFGHIJKLMNOPQRSTVUWXYZ0123456789";
		final String okCharactersSpace = "A B C D E F G H I J K L M N O P Q R S T V U W X Y Z 0 1 2 3 4 5 6 7 8 9 ";
		final int maxGuesses = 7;
		int currentRound = 0;
		int playerOneScore = 0;
		int playerTwoScore = 0;
		String guessedLetters = "";
		String quizzer;
		String guesser;
		String guess;
		boolean gameOver = false;
		int guessesMade = 0;


		

		
		
		// player
		
		System.out.println("Please enter player one's name: ");
			String playerOneName = scanner.nextLine();
		System.out.println("Please enter player two's name: ");
			String playerTwoName = scanner.nextLine();
		
		boolean isRoundOver = false;
		while (!isRoundOver) { // playing a round

			if (currentRound % 2 != 0) {
						quizzer = playerOneName;
						guesser = playerTwoName;

			} else {
						guesser = playerOneName;
						quizzer = playerTwoName;
					}
		//First word
			
		System.out.print(quizzer + ", can you write a word or phrase that you want " + guesser +" to guess: ");
			String phrase = "";
				boolean possible = true;
				while (possible) {
			phrase = scanner.nextLine().toUpperCase();
			possible = false;
					for (int i = 0; i < phrase.length(); i++) {
							if (okCharacters.indexOf(phrase.charAt(i)) == -1) {
								System.out.print("Error " + quizzer + " you must enter an alphanumeric word or phrase to be guessed: ");
			phrase = scanner.nextLine().toUpperCase();
			possible = true;

					}	
						
				}
				
			for (int i = 0; i < 40; i++) {
					System.out.println("");
				}
			String wordChosen = "";
			for (int i = 0; i < phrase.length(); i++) {
						if (phrase.charAt(i) == ' ')
								wordChosen += "/ "; //formatting
						else
							wordChosen += "_ "; //formatting (spaces for letters)
				}
				System.out.println(wordChosen);

				// Guessing begins

				while (guessesMade <= maxGuesses && !isRoundOver) { //rules

					
					System.out.print(guesser + ", you have used " + guessesMade	+ " guesses, would you like to solve or guess a character? Press 1 to solve and press 2 to guess a character: ");
					String choice = scanner.nextLine();

					
			//if you enter number one
					if (choice.equals("1")) {
						System.out.print(guesser + ", your possible guesses are: " + okCharacters
								+ " please guess the solution: ");
						possible = true;
						while (possible) {
							guess = scanner.nextLine().toUpperCase(); //making everything in upper case
							possible = false;
							for (int i = 0; i < phrase.length(); i++) {
								if (okCharactersSpace.indexOf(phrase.charAt(i)) == -1) {
									System.out.print("ERROR, you need enter an alphanumeric (letter of number) message to be guessed: "); //if not an ok letter or number
									guess = scanner.nextLine().toUpperCase();
									possible = true;

								}
							}
					if (guess.equals(phrase)) {
							System.out.println("You're right!");
								//making score
					if (playerOneName == guesser) {
								playerOneScore += maxGuesses - guessesMade;
					} else {
								playerTwoScore += maxGuesses - guessesMade; 
					}
						currentRound++;
						isRoundOver = true;
					}
						if (!guess.equals(phrase)) {
								System.out.println("Wrong guess, sorry!");
								guessesMade++;
						}
						if (guessesMade == maxGuesses) {
								//if lost
						System.out.println("Sorry " + guesser + ", you have lost this round");
						currentRound++;
						isRoundOver = true;

							}

							}

					//	if you enter number two 

						}
			if (choice.equals("2")) {

				System.out.print(guesser + ", your available guesses are: ");
				for (int i = 0; i < okCharacters.length(); i++) {
						System.out.print(okCharacters.charAt(i) + "");
					}
			System.out.print(" " + guesser + ", please enter a character: ");
			possible = true;
		while (possible) {
	guess = scanner.nextLine().toUpperCase();
		possible = false;
					
			if (guess.length() >= 2) {
						System.out.print("ERROR, please enter one character: ");
				guess = scanner.nextLine().toUpperCase();
							possible = true;
				}
			else if(okCharacters.indexOf(guess)==-1){
						System.out.print("ERROR, please enter an alphanumeric character to be guessed: ");
				guess = scanner.nextLine().toUpperCase();
							possible = true;
									}
				else	 {
							possible = false;
						okCharacters= okCharacters.substring(0,okCharacters.indexOf(guess)) + "_"+ okCharacters.substring(okCharacters.indexOf(guess) + 1);
								}
			if (phrase.indexOf(guess) != -1) {
						System.out.println("The character " + guess + " is within the word/phrase.");
								String open = "";
				for (int f = 0; f < phrase.length(); f++) {	
					if (phrase.charAt(f) == guess.charAt(0)){		
								open += guess.charAt(0) + " ";				
							}else{
											open += wordChosen.charAt(f*2) + " ";}
									} 
					wordChosen = open;
								for (int a = 0; a < wordChosen.length(); a++) {
									System.out.print(wordChosen.charAt(a));
								}
								guessesMade++;
				} else {
								System.out.println("The character you entered is not in the word/phrase. ");
				for (int a = 0; a < wordChosen.length(); a++) {
									System.out.print(wordChosen.charAt(a));
					}
				guessesMade++;
				}
							System.out.println();
					if (wordChosen.indexOf("_") == -1) {
						System.out.println("Congrats you have won!");
									isRoundOver = true;
									if (currentRound % 2 != 0) {
										playerTwoScore += maxGuesses - guessesMade;
					}else{
						playerOneScore += maxGuesses - guessesMade;
					}currentRound ++;

	

			
			 // end of game
            gameOver = (currentRound > 5 && playerOneScore != playerTwoScore); //making sure they are not tied 
        

            	if (playerOneScore > playerTwoScore) {
            			System.out.println("Congrats " + playerOneName + ", you have won with the score of " + playerOneScore);
            			} else if (playerTwoScore > playerOneScore) {
            					System.out.println("Congrats" + playerTwoName + ", you have won with the score of " + playerTwoScore);

            			}
					}
			//game is over
	
		}
			}
					}
				}
				}
		}

	}







