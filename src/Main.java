import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
	WordValid wv = new WordValid("Ambidexterous");
	Player p1 = new Player("Ted", Difficulty.EASY);
	
	char t = Validator.getChar(scanner, "Enter Letter: ");
	if(wv.valid(t)){
		wv.hit();
	}else {
		wv.miss();
	}
	System.out.println();
	wv.showUnder();
	System.out.println();
	System.out.println(wv.getHits());
	System.out.println(wv.getMisses());
	
	}
	
}
