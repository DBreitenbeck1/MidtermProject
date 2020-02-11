import java.util.*;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
	boolean play = true;
		WordValid wv = new WordValid("hello");

		Player player1 = new Player("James");
		wv.setDifficulty();
		
		
		
		
		do {
			playGame(player1, wv);
			
		} while (!wv.win());
	

		

	}
	
	public static void playGame(Player player, WordValid word) {
		Scanner scan = new Scanner(System.in);
		word.showUnder();
		char letter = Validator.getChar(scan, "Guess a letter: ");
		if (word.valid(letter)) {
			System.out.println("Hit!");
		} else {
			System.out.println("Miss!");
			word.miss();
		}
		word.showUnder();
		
		
	}

	

}
