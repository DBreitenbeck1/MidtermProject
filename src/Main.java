import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

	private static FileHelper<String> fileHelper = new FileHelper<>("src/wordseasy.txt", new WordLineConverter());


	public static void main(String[] args) {
	
//		Path path1 = Paths.get("src/wordseasy.txt");
//		if (Files.notExists(path1)) {
//			try {
//				Files.createFile(path1);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

		Path path2 = Paths.get("src/stats.txt");
		if (Files.notExists(path2)) {
			try {
				Files.createFile(path2);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		Scanner scanner = new Scanner(System.in);
		

		Player player1 = new Player("James");
		
	
		
	do {
		ArrayList<Character> guessed = new ArrayList<>();
		String word = randWord(fileHelper);
		WordValid wv = new WordValid(word);
		wv.setDifficulty();
		
		do {
			playGame(player1, wv, guessed);
		} while (!wv.win() && !wv.lose());

		if (wv.win()) {
			System.out.println("You won!");
			player1.win();
		} else if (wv.lose()) {	
			System.out.println("You lost");
			player1.lose();
			System.out.println(word);
		}
	}while(cont());
	player1.addStat();
	
	System.out.println("Good game");
	
	}

	public static void playGame(Player player, WordValid word, ArrayList<Character> list) {
		
		Scanner scan = new Scanner(System.in);
		word.showUnder();
		System.out.println(word.getChances());
		char letter = Validator.getChar(scan, "Guess a letter: ");
		if (word.valid(letter)) {
			System.out.println("Hit!");
		} else {
			System.out.println("Miss!");
			list.add(letter);
			
			// System.out.println(word.getMisses());
		}
		System.out.println(list);

	}
	
	public static String randWord(FileHelper filehelper) {
		List<String> words = filehelper.readAll();
		int rand = (int)(Math.random()*words.size());
		String word = words.get(rand);
		return word;
		
	}
	
	public static boolean cont() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		String cont = Validator.getStringMatchingRegex(scan, "Do you want to go again?[y/n]", "[y,n]"); 
		if (cont.equals("y")) {
			return true;
		}else {
			return false;
		}		
		
	}

}
