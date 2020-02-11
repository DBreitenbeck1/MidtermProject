
public class Player {
	String name; 
	
	int wins;
	int loses;
	Difficulty dif;
	
	
	public Player (String name, Difficulty dif) {
		this.name = name;
		this.wins=0;
		this.loses=0;
		this.dif = dif;
		//Validate difficulty entry
		
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
		this.wins +=1;
	}
	public int getLoses() {
		return loses;
	}
	public void setLoses(int loses) {
		this.loses = loses;
	}
	
	
	
}
