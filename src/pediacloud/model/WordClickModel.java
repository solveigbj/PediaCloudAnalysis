package pediacloud.model;

import java.util.Date;

public class WordClickModel extends Model {

	private String wordSize;
	private String wordColor;
	private int wordRank;
	private int numberOfWords;
	
	WordClickModel (String per) {
		super(per);
	}
	

	public String toString () {
		
		return super.toString() + wordSize + ", " + wordColor + ", " + wordRank + ", " + numberOfWords;
	}

}
