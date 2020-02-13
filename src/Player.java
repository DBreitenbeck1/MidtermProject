import java.util.Comparator;


/*
 * 
 * @author Amanda Campos and David Breitenbeck
 *
 */

public class Player {

	private String name;
	private int wins;
	private int losses;
	private int avgGuesses;
	private int avgWins;
	static final Comparator<Player> WIN_ORDER = new Comparator<Player>() {

		@Override
		public int compare(Player player1, Player player2) {
			if (player1.getAvgWins() > player2.getAvgWins()) {
				return -1;

			} else if (player1.getAvgWins() < player2.getAvgWins()) {
				return 1;
			}
			return 0;
		}

	};

	public Player(String name) {
		this.name = name;
		this.wins = 0;
		this.losses = 0;
	}

	// The overload constructor creates objects based on the Statistics file
	public Player(int wins, int losses, String name, int avgGuess, int avgWin) {
		this.name = name;
		this.wins = wins;
		this.losses = losses;
		this.avgGuesses = avgGuess;
		this.avgWins = avgWin;

	}

	public String getName() {
		return name;
	}
	
	public int getWins() {
		return wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public int getAvgGuess() {
		return avgGuesses;
	}
	
	public int getAvgWins() {
		return avgWins;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAvgGuess(int avgGuess) {
		this.avgGuesses = avgGuess;
	}

	public void win() {
		this.wins += 1;
	}

	public void lose() {
		this.losses += 1;
	}

	// The method avgWins calculates the percentage of wins amongst all matches of a play
	public void avgWins() {
		double avg = wins / ((double) wins + (double) losses);
		avgWins = (int) (avg * 100);
	}

	public void addStat(FileHelper<Player> fileHelperStat) {
		fileHelperStat.append(this);
	}

}
