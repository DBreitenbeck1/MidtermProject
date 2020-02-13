/*
 * 
 * @author Amanda Campos and David Breitenbeck
 *
 */

public class Art {

	public static void hang(WordValid w) {
		switch (w.getDif()) {
		case EASY: {
			hangE(w);
			break;
		}
		case MEDIUM: {
			hangM(w);
			break;
		}
		case HARD: {
			hangH(w);
			break;
		}
		}

	}

	public static void hangE(WordValid w) {
		int c = w.getChances();
		switch (c) {
		case 8: {
			one();
			break;
		}
		case 7: {
			two();
			break;
		}
		case 6: {
			three();
			break;
		}
		case 5: {
			four();
			break;
		}
		case 4: {
			five();
			break;
		}
		case 3: {
			six();
			break;
		}
		case 2: {
			seven();
			break;
		}
		case 1: {
			eight();
			break;
		}
		case 0: {
			nine();
			break;
		}
		default: {
			break;
		}
		}
	}

	public static void hangM(WordValid w) {
		int c = w.getChances();
		switch (c) {
		case 5: {
			one();
			break;
		}
		case 4: {
			two();
			break;
		}
		case 3: {
			four();
			break;
		}
		case 2: {
			five();
			break;
		}
		case 1: {
			seven();
			break;
		}
		case 0: {
			nine();
			break;
		}
		default: {
			break;
		}
		}

	}

	public static void hangH(WordValid w) {
		int c = w.getChances();
		switch (c) {
		case 2: {
			five();
			break;
		}
		case 1: {
			seven();
			break;
		}
		case 0: {
			nine();
			break;
		}
		default: {
			break;
		}
		}
	}

	public static void one() {

		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
	}

	public static void two() {

		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));

	}

	public static void three() {

		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
	}

	public static void four() {
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
	}

	public static void five() {
		System.out.printf("\t     ");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]\n");
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
	}

	public static void six() {
		System.out.printf("\t");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]\n");
		System.out.println(String.format("\t\t%s", "\\[]"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
	}

	public static void seven() {
		System.out.printf("\t");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]\n");
		System.out.println(String.format("\t%s\t%s", " |", "\\[]"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
	}

	public static void eight() {
		System.out.printf("\t");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]\n");
		System.out.println(String.format("\t%s\t%s", " |", "\\[]"));
		System.out.println(String.format("\t%s\t%s", "\\o/", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
	}

	public static void nine() {

		System.out.printf("\t");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]");
		System.out.print("[]\n");
		System.out.println(String.format("\t%s\t%s", " |", "\\[]"));
		System.out.println(String.format("\t%s\t%s", "\\o/", " []"));
		System.out.println(String.format("\t%s\t%s", " |", " []"));
		System.out.println(String.format("\t%s\t%s", "/ \\", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));
		System.out.println(String.format("\t\t%s", " []"));

	}

}
