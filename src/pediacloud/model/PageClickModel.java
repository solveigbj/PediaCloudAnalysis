package pediacloud.model;

import java.util.Date;

public class PageClickModel extends Model {

	private int clickedPage;
	private int pageRank;
	private int numberOfPages;
	
	PageClickModel (String per) {
		super(per);
	}
	
	public String toString () {
		return super.toString() + clickedPage + ", " + pageRank + ", " + numberOfPages; 
	}
}
