import java.util.*;
public class Main {

	public static void main(String[] args) {
	
	WordValid wv = new WordValid("Hello");
	Player p1 = new Player("Ted", Difficulty.EASY);
	
	
	
	wv.showUnder();
	char t ='t';
	
	for (char c: wv.getUnder()) {
		System.out.print(c +" ");
	}
	int score = 0;
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
