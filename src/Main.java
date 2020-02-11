import java.util.*;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		WordValid wv = new WordValid("hello");

		Player player1 = new Player("James");
		wv.setDifficulty();
		
		
		playGame(player1, wv);
		wv.getChances();
		
		

		

	}
	
	public static void playGame(Player player, WordValid word) {
		word.showUnder();
		char letter = Validator.getChar(scanner, "Guess a letter: ");
		word.valid(letter);
		
	}

	

}
