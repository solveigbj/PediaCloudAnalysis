package pediacloud.model;

public class WordLine implements Comparable<WordLine>{

	String word;
	int wordSize;
	int color;
	int x;
	int y;

	
	public WordLine (String[] content) {
		word = content[0];
		wordSize = new Integer(content[1]).intValue();
		color = new Integer(content[2]).intValue();
		x = new Integer(content[3]).intValue();
		y = new Integer(content[4]).intValue();
	}
	
	public String getWord() { return word; }

	public int getWordSize() {
		return wordSize;
	}
	
	public int getColor() {
		return color;
	}
	public int getY() {
		return y;
	}
	
	/**
	 * @param wl
	 * @return A value less than 0 if the argument has a wordSize greater than this wordSize, 
	 * 			and a value greater than 0 if the argument has a wordSize equal to or smaller than this string.
	 */
	public int compareTo(WordLine wl) {
		final int BEFORE = -1;
		final int EQUAL = 0;
		final int AFTER = 1;
		
		int otherSize = wl.wordSize;

		if (wordSize == otherSize) return EQUAL;
		else if (wordSize > otherSize) return BEFORE;
		else return AFTER;
	}
/*	public String toString() { 
		return word + " " + wordSize + "\n"; 
	}*/
}
