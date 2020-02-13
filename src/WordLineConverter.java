/*
 * 
 * @author Amanda Campos and David Breitenbeck
 *
 */
public class WordLineConverter implements LineConverter<String> {


	@Override
	public String toLine(String object) {
		return String.format("%s", object);
	}

	@Override
	public String fromLine(String line) {
		return line;
	}

}
