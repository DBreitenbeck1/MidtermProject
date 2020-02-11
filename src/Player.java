import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Player {
	private static FileHelper<Player> fileHelper2 = new FileHelper<>("src/stats.txt", new StatLineConverter());
	String name;
	int wins;
	int loses;
	static final Comparator<Player> WIN_ORDER = new Comparator<>() {

		@Override
		public int compare(Player player1, Player player2) {
			if (player1.getWins() > player2.getWins()) {
				return -1;
			} else if (player1.getWins() < player2.getWins()) {
				return 1;
			} else if(player1.getWins()==player2.getWins()) {
				if (player1.getLoses() > player2.getLoses()) {
					return 1;
				} else if (player1.getLoses() < player2.getLoses()) {
					return -1;
				}
			}
			return 0;
		}
		
	};

	public Player(String name) {
		this.name = name;
		this.wins = 0;
		this.loses = 0;
		// Validate difficulty entry

	}
	
	public Player(int wins, int losses, String name) {
		this.name = name;
		this.wins = wins;
		this.loses = losses;
		// Validate difficulty entry

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWins() {
		return wins;
	}

	public void win() {
		this.wins += 1;
	}

	public int getLoses() {
		return loses;
	}

	public void lose() {
		this.loses += 1;
	}
	
	public void addStat() {
		fileHelper2.append(this);
	}
	
	

}
