package pediacloud.model;

public class WordLine {

	String word;
	int wordSize;
	int color;

	
	public WordLine (String[] content) {
		word = content[0];
		wordSize = new Integer(content[1]);
		color = new Integer(content[2]).intValue();
	}
	
	public String getWord() { return word; }
	public int wordSize () { return new Integer(wordSize);}

	public int getWordSize() {
		return wordSize;
	}
	

	public int getColor() {
		return color;
	}
}
