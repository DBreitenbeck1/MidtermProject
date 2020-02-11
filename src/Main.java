import java.util.*;

public class Main {

	private static FileHelper<String> fileHelper = new FileHelper<>("src/wordseasy.txt", new WordLineConverter());
	
	public static void main(String[] args) {
	
	//fileHelper.rewrite(objects);
	 Scanner scanner = new Scanner(System.in);
		WordValid wv = new WordValid("hello");

		Player player1 = new Player("James");
		wv.setDifficulty();
		
			
		
		do {
			playGame(player1, wv);
		} while (!wv.win() && !wv.lose());
	
		if(wv.win()) {
			System.out.println("You won!");
		}else if (wv.lose()) {
			System.out.println("You lost");
		}

		

	}
	
	public static void playGame(Player player, WordValid word) {
		Scanner scan = new Scanner(System.in);
		word.showUnder();
		System.out.println(word.getChances());
		char letter = Validator.getChar(scan, "Guess a letter: ");
		if (word.valid(letter)) {
			System.out.println("Hit!");
		} else {
			System.out.println("Miss!");
			//System.out.println(word.getMisses());
		}
				
	}

	

}
