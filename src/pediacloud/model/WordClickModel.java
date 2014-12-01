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
	private int y;
	private int max_y;

	public WordClickModel(String per, String time) {
		super(per, time);
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

		String name = "Black";
		if (name!=null && name.length()>0) {
			if (c.equals(Color.red)) name = colors[0];
			else if (c.equals(Color.green)) name = colors[1];
			else if (c.equals(Color.blue)) name = colors[2];
			else if (c.equals(Color.magenta)) name = colors[3];
			else if (c.equals(Color.cyan)) name = colors[4];
			else if (c.equals(Color.yellow)) name = colors[5];
			else if (c.equals(Color.black)) name = colors[6];
		}
		return name;
	}
	
	public void addWordColor(int col) {
		Color color = new Color(col);
		wordColor = getColorName(color);
	}
	public void addWordRank(int rank) {
		wordRank = rank;
	}
	public void addNumberOfWords(int words) {
		numberOfWords = words;
	}
	public void addY(int y) {
		this.y = y;
	}
	public void addMaxY (int maxY) {
		max_y = maxY;
	}

	public String toString() {

		return super.toString() + wordSize + SEPARATOR + wordColor + SEPARATOR + wordRank
				+ SEPARATOR + numberOfWords + SEPARATOR + y + SEPARATOR + max_y +  "\n";
	}

}
