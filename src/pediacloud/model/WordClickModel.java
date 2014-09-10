package pediacloud.model;

import java.awt.Color;

/**
 * @author sinso
 *
 */

public class WordClickModel extends Model {

	private int wordSize;
	private String wordColor;
	private int wordRank;
	private int numberOfWords;

	WordClickModel(String per) {
		super(per);
	}
	
	public void addWordSize (int size) {
		wordSize = size;
	}

	/**
	 * @param c
	 * @return
	 */
	private String getColorName(Color c) {
		String[] colors = {"RED","GREEN","BLUE","MAGENTA","CYAN","YELLOW","BLACK"};
		//if (c==null) return defaultName;
		String name = "Black";
		if (name!=null && name.length()>0) {
			if (c.equals(Color.red)) name = colors[0];
			else if (c.equals(Color.green)) name = colors[1];
			else if (c.equals(Color.blue)) name = colors[2];
			else if (c.equals(Color.magenta)) name = colors[3];
			else if (c.equals(Color.cyan)) name = colors[4];
			else if (c.equals(Color.yellow)) name = colors[5];
			else if (c.equals(Color.black)) name = colors[7];
		}
		return name;
	}
	
	public void addWordColor(int color) {
		Color Color = new Color(color);
		wordColor = getColorName(Color);
	}
	public void addWordRank(int rank) {
		wordRank = rank;
	}
	public void addNumberOfWords(int words) {
		numberOfWords = words;
	}
	public String toString() {

		return super.toString() + wordSize + ", " + wordColor + ", " + wordRank
				+ ", " + numberOfWords;
	}

}
