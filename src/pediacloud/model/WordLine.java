package pediacloud.model;

import java.awt.Color;

public class WordLine {

	String word;
	int wordSize;
	String color;

	
	public WordLine (String[] content) {
		word = content[0];
		wordSize = new Integer(content[1]);
		//int colCode = new Integer(content[2]);
		//color = getColorName(new Color(colCode));
		color = content[2];
	}
	
	public String getWord() { return word; }
	public int wordSize () { return new Integer(wordSize);}

	public int getWordSize() {
		return wordSize;
	}
	

	public String getColor() {
		return color;
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

}
