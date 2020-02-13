import java.util.Scanner;

/*
 * 
 * @author Amanda Campos and David Breitenbeck
 *
 */

public class WordValid {
	
	private String word;
	private char[] letters;
	private char[] under;
	private int misses;
	private int hits;
	private Difficulty dif;
	private int chances;

	public WordValid() {
	}

	public WordValid(String word) {
		this.word = word;
	}
	
	
	public void setWord(String w) {
		/*
		 *  This method creates two Arrays:
		 *  The 'letters' array splits the word into an array of
		 *  individual letters.
		 *  The 'under' array creates a corresponding array of underscores
		 *  to mark the unguessed letters. 
		 */

		this.word=w;
		letters = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			letters[i] = word.charAt(i);
		}

		under = new char[word.length()];
		for (int i = 0; i < word.length(); i++) {
			under[i] = '_';
		}
	}
	public String getWord() {
		return word;
	}

	public int getHits() {
		return hits;
	}

	public int getMisses() {
		return misses;
	}

	public char[] getUnder() {
		return under;
	}

	public char[] getLetters() {
		return letters;
	}

	public void showUnder() {
		// This method displays the array of underscores
		
		for (char c : under) {
			System.out.print(c + " ");
		}
		System.out.println("\n");
	}
	
	public void showLetters() {
		// This method displays the 'letters' array
		
		for (char c : letters) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	public boolean lose() {
		/*
		 * If the player runs out of chances, the match is lost
		 */
		if (chances <= 0) {
			return true;
		}
		return false;
	}

	public boolean win() {
		// If all the underscores have been replaced by letters, 
		// the player has won the match		
		for (char c : under) {
			if (c == '_') {
				return false;
			}
		}
		return true;
	}

	public boolean valid(char entry) {
		/*
		 * This method validates whether 
		 *  the word contains the chosen letter
		 *  and, if so, replaces the corresponding underscore with
		 *  the correct letter 
		 *   
		 */
		
		boolean hit = false;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == entry) {
				under[i] = entry;
				hit = true;
				hit();
			}
		}
		if (!hit) {
			miss();
		}
		return hit;

	}

	public void hit() {
		hits += 1;
	}

	public void miss() {
		misses += 1;
		chances-=1;
	}

	public int getChances() {
		return chances;
	}

	public Difficulty setDifficulty() {
		Scanner scnr = new Scanner(System.in);

		String difficulty = Validator.getString(scnr, "Enter difficulty [easy/medium/hard]: ");
		//The Difficulty setting determines how many chances the player
		//will get
		switch (difficulty.toLowerCase()) {
		case "easy":
			dif = Difficulty.EASY;
			chances = dif.getChances();
			return dif;		
		case "medium":
			dif = Difficulty.MEDIUM;
			chances = dif.getChances();
			return dif;
		case "hard":
			dif = Difficulty.HARD;
			chances = dif.getChances();
			return dif;
		default:
			return setDifficulty();
		}
	}

	public Difficulty getDif() {
		return dif;
	}
	
	public int guesses() {
		return hits + misses;
	}

}
