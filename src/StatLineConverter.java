/*
 * 
 * @author Amanda Campos and David Breitenbeck
 *
 */
public class StatLineConverter implements LineConverter<Player> {

	@Override
	public String toLine(Player object) {
		return String.format("%d\t%d\t%s\t%d\t%d", object.getWins(),object.getLosses(),object.getName(), object.getAvgGuess(),object.getAvgWins());
				
	}

	@Override
	public Player fromLine(String line) {
		String[] list = line.split("\t");
		int wins = Integer.parseInt(list[0]);
		int losses = Integer.parseInt(list[1]);
		String name = list[2];
		int avgGuess = Integer.parseInt(list[3]);
		int avgWins = Integer.parseInt(list[4]);
		return new Player(wins, losses, name, avgGuess, avgWins);
	}
	

}
