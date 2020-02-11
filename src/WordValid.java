
public class WordValid {
	private String word;
	private char[] letters;
	private char[] under;
	private int misses;
	private int hits;
	

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
	}

	public boolean valid(char entry) {
		boolean hit = false;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == entry) {
				under[i] = entry;
				hit = true;
			}
		}
		return hit;

	}
	
	public void hit() {
		hits +=1;
	}
	
	public void miss() {
		misses +=1;
	}

}
