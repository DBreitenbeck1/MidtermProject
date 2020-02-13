import java.util.*;

/*
 * 
 * @author Amanda Campos and David Breitenbeck
 *
 */

public class Main {

	// Creating FileHelpers instances for each text file that is going to utilized
	// and accessed throughout
	// the entire Main class.

	private static FileHelper<Player> fileHelperStat = new FileHelper<>("src/stats.txt", new StatLineConverter());
	private static FileHelper<String> fileHelperEasyMediumW = new FileHelper<>("src/easymediumwords.txt", new WordLineConverter());
	private static FileHelper<String> fileHelperHardW = new FileHelper<>("src/hardwords.txt", new WordLineConverter());

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// The following ArrayList keeps track of how many guesses the player needed to
		// correctly discover the word

		List<Integer> totalGuesses = new ArrayList<>();

		// The String is necessary to instantiate a WordValid object
		String word = "";
		
		int numberPlays = 0;

		Player player = createPlayer();

		do {

			// This List keeps track of the letters that have already been tried and were
			// not a match
			ArrayList<Character> guessed = new ArrayList<>();
			WordValid wv = new WordValid();

			// If the difficulty is set to Easy or Medium, the program uses the
			// wordseasy.txt
			// to randomly select a word. If the difficulty is set to Hard, the program uses
			// hardwords.txt
			// to randomly select a word.
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
				System.out.print("Word you missed: ");
				wv.showLetters();
			}
			numberPlays++;
		} while (cont());

		int avgG = averageChances(totalGuesses, numberPlays);
		player.setAvgGuess(avgG);
		player.avgWins();

		// The statistics of the match are added to stats.txt
		player.addStat(fileHelperStat);

		// FileHelper<Player> fileHelper2 = new FileHelper<>("src/stats.txt", new
		// StatLineConverter());
		displayStat(fileHelperStat);

		System.out.print("Good game!");
		scanner.close();

	}

	public static void playGame(Player player, WordValid word, ArrayList<Character> list) {

		System.out.print("\nWord: ");

		// The game displays each letter of the word in undescores
		word.showUnder();

		// The number of remaining chances is displayed
		System.out.println("Remaining guesses: " + word.getChances());
		System.out.println("Letters you tried missed: " + list);

		char letter = Validator.getChar(scanner, "\nGuess a letter: ");
		if (word.valid(letter)) {
			System.out.println("Hit!");
		} else {
			System.out.println("Miss!");

			// The letter is added to a list that keeps track of incorrect guesses
			list.add(letter);

			// An art is display representing how many chances are left
			Art.hang(word);
		}

	}

	public static String randWord(FileHelper<String> filehelper) {

		// A list of all the words in the selected text files is initialized, and
		// a word is randomly selected from the List

		List<String> words = filehelper.readAll();
		int rand = (int) (Math.random() * words.size());
		return words.get(rand);

	}

	public static boolean cont() {

		// This method returns the user's choince on continuing or quitting the game
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

	public static void displayStat(FileHelper<Player> fileHelper) { // location of filehelper tho
		List<Player> players = fileHelper.readAll();

		// The Collection.sort method sorts a list of Players based on Wins Percentage

		Collections.sort(players, Player.WIN_ORDER);

		// The Top 5 Players available on stats.txt is displayed

		System.out.printf("\n%30s\n", "Top 5");
		System.out.printf("%30s\n", "#####");

		System.out.printf("%5s %10s %15s %15s %15s\n", "Wins", "Losses", "Avg Guesses", "Win Percent", "User");
		System.out.printf("%5s %10s %15s %15s %15s\n", "----", "------", "-----------", "-----------", "----");
		if (players.size() > 5) {
			for (Player player : players.subList(0, 5)) {
				System.out.printf("%5d %10d %15d %15d %15s\n", player.getWins(), player.getLosses(),
						player.getAvgGuess(), player.getAvgWins(), player.getName());
			}
			// The "else" command is necessary in case there's less than 5 players on the
			// file
		} else {
			for (Player player : players) {
				System.out.printf("%5d %10d %15d %15d %15s\n", player.getWins(), player.getLosses(),
						player.getAvgGuess(), player.getAvgWins(), player.getName());
			}
		}

		System.out.println();
	}

	public static int averageChances(List<Integer> totalGuesses, int totalPlays) {

		// The method returns the average number of chances necessary for a player to
		// win a match

		int sum = 0;
		for (Integer guess : totalGuesses) {
			sum += guess;
		}
		int avg = sum / totalPlays;
		return avg;

	}

}
