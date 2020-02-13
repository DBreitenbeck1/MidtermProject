/*
 * 
 * @author Amanda Campos and David Breitenbeck
 *
 */
public enum Difficulty {
	EASY(9),MEDIUM(6),HARD(3);
	
	int chances; 
	
	private Difficulty(int c) {
		this.chances=c;
	}
	
	public int getChances() {
		return chances;
	}
	

}
