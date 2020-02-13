import java.util.*;

/*
 * 
 * @author Amanda Campos and David Breitenbeck
 *
 */

public class Main {

	// Creates FileHelper instances for each text file that is going to be
	// accessed in the Main class.

	private static FileHelper<Player> fileHelperStat = new FileHelper<>("src/stats.txt", new StatLineConverter());
	private static FileHelper<String> fileHelperEasyMediumW = new FileHelper<>("src/easymediumwords.txt", new WordLineConverter());
	private static FileHelper<String> fileHelperHardW = new FileHelper<>("src/hardwords.txt", new WordLineConverter());

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// The 'totalGuesses' ArrayList keeps track of the number of
		// guesses the player needed to find the correct word

		List<Integer> totalGuesses = new ArrayList<>();

		// The String 'word' is necessary to instantiate a WordValid object
		String word = "";
		
		int numberPlays = 0;

		Player player = createPlayer();

		do {

			// The 'guessed' ArrayList keeps track of 
			//the letters that have already been tried and were not a match
			ArrayList<Character> guessed = new ArrayList<>();
			WordValid wv = new WordValid();

			/*
			 *  If the difficulty is set to Easy or Medium, the program selects a 
			 *  random word from the easymediumwords.txt file. 
			 *  If Hard, it selects from the hardwords.txt file.
			 */
			switch (wv.setDifficulty()) {
			case EASY:
				word = randWord(fileHelperEasyMediumW);
				break;
			case MEDIUM:
				word = randWord(fileHelperEasyMediumW);
				break;
			case HARD:
				word = randWord(fileHelperHardW);
				break;
			}

			// The chosen word is set to the WordValid object
			wv.setWord(word);

			// The match continues until the player wins or loses a match
			do {
				playGame(player, wv, guessed);
			} while (!wv.win() && !wv.lose());

			if (wv.win()) {
				System.out.println("You won!!!!");
				totalGuesses.add(wv.guesses());
				player.win();
				System.out.print("Correct word: ");
				wv.showLetters();
			} else if (wv.lose()) {
				System.out.println("You lost!");
				player.lose();
				System.out.print("Correct word: ");
				wv.showLetters();
			}
			numberPlays++;
		} while (cont());

		int avgG = averageChances(totalGuesses, numberPlays);
		player.setAvgGuess(avgG);
		player.avgWins();

		// The statistics of the match are added to stats.txt
		player.addStat(fileHelperStat);

		displayStat(fileHelperStat);

		System.out.print("Good game!");
		scanner.close();

	}

	public static void playGame(Player player, WordValid word, ArrayList<Character> list) {

		System.out.print("\nWord: ");

		// The game displays an underscore for each letter in the word
		word.showUnder();

		// The number of remaining chances is displayed
		System.out.println("Remaining Guesses: " + word.getChances());
		System.out.println("Already Guessed: " + list);

		//The guess is received and checked by the word valid class
		char letter = Validator.getChar(scanner, "\nGuess a letter: ");
		if (word.valid(letter)) {
			System.out.println("Hit!");
		} else {
			System.out.println("Miss!");

			// The letter is added to the 'guessed' ArrayList
			list.add(letter);

			// The progressive 'hangman' artwork is displayed,
			// representing how many chances the player has left
			Art.hang(word);
		}

	}

	public static String randWord(FileHelper<String> filehelper) {

		// A list of all the words in the selected text files is initialized, and
		// a random word is selected

		List<String> words = filehelper.readAll();
		int rand = (int) (Math.random() * words.size());
		return words.get(rand);

	}

	public static boolean cont() {

		// This method asks if the user would like to
		// to play again and returns his choice.
		System.out.println();

		String cont = Validator.getStringMatchingRegex(scanner, "Do you want to play again?[y/n] ", "[y,n]");

		if (cont.toLowerCase().equals("y")) {
			return true;
		}
		return false;

	}

	public static Player createPlayer() {
		Scanner scanner = new Scanner(System.in);
		String username = Validator.getString(scanner, "Enter username: ");
		return new Player(username);
	}

	public static void displayStat(FileHelper<Player> fileHelper) { 
		List<Player> players = fileHelper.readAll();

		// The Collection.sort method sorts a list of Players based on Wins Percentage

		Collections.sort(players, Player.WIN_ORDER);

		// The Top 5 Players available on stats.txt are displayed

		System.out.printf("\n%30s\n", "Top 5");
		System.out.printf("%30s\n", "#####");

		System.out.printf("%5s %10s %15s %15s %15s\n", "Wins", "Losses", "Avg Guesses", "Win Percent", "User");
		System.out.printf("%5s %10s %15s %15s %15s\n", "----", "------", "-----------", "-----------", "----");
		if (players.size() > 5) {
			for (Player player : players.subList(0, 5)) {
				System.out.printf("%5d %10d %15d %15d %15s\n", player.getWins(), player.getLosses(),
						player.getAvgGuess(), player.getAvgWins(), player.getName());
			}
			// This 'if' Statement checks if there are more than five players and, if so,
			// only displays the top five
		} else {
			for (Player player : players) {
				System.out.printf("%5d %10d %15d %15d %15s\n", player.getWins(), player.getLosses(),
						player.getAvgGuess(), player.getAvgWins(), player.getName());
			}
		}

		System.out.println();
	}

	public static int averageChances(List<Integer> totalGuesses, int totalPlays) {

		// This method returns the average number of chances necessary for a player to
		// win a match

		int sum = 0;
		for (Integer guess : totalGuesses) {
			sum += guess;
		}
		int avg = sum / totalPlays;
		return avg;

	}

}
