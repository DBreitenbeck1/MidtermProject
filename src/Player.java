import java.util.Scanner;

public class Player {
	String name; 
	
	int wins;
	int loses;
	
	
	
	public Player (String name) {
		this.name = name;
		this.wins=0;
		this.loses=0;
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
