
public class StatLineConverter implements LineConverter<Player> {

	@Override
	public String toLine(Player object) {
		return String.format("%d\t%d\t%s", object.getWins(),object.getLoses(),object.getName());
				
	}

	@Override
	public Player fromLine(String line) {
		String[] list = line.split("\t");
		int wins = Integer.parseInt(list[0]);
		int losses = Integer.parseInt(list[1]);
		String name = list[2];
		return new Player(wins, losses, name);
	}
	

}
