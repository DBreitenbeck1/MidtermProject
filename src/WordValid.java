import java.util.Scanner;

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
		for (char c : under) {
			System.out.print(c + " ");
		}
		System.out.println();
	}

	public boolean lose() {
		if (chances == 0) {
			return true;
		}
		return false;
	}

	public boolean win() {
		for (char c : under) {
			if (c == '_') {
				return false;
			}
		}
		return true;
	}

	public boolean valid(char entry) {
		boolean hit = false;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == entry) {
				under[i] = entry;
				hit = true;
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

	public void setDifficulty() {
		Scanner scnr = new Scanner(System.in);

		String difficulty = Validator.getString(scnr, "Enter difficulty: ");

		switch (difficulty.toLowerCase()) {
		case "easy":
			dif = Difficulty.EASY;
			chances = dif.getChances();
			break;
		case "medium":
			dif = Difficulty.MEDIUM;
			chances = dif.getChances();
			break;
		case "hard":
			dif = Difficulty.HARD;
			chances = dif.getChances();
			break;
		default:
			setDifficulty();
		}
	}

	public Difficulty getDif() {
		return dif;
	}

}
