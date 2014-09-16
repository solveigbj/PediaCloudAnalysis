package pediacloud.model;

/**
 * @author sinso
 *
 */
public class PageClickModel extends Model {

	private String clickedPage;
	private int pageRank;
	private int numberOfPages;

	public PageClickModel(String per, String time) {
		super(per, time);
	}

	public void addClickedPage(String page) {
		clickedPage = page;
	}
	public void addPageRank(int i) { pageRank = i;}
	public void addNumberOfPages(int i) { numberOfPages = i;}
	
	public String toString() {
		return super.toString() + clickedPage + "; " + pageRank + "; "
				+ numberOfPages + "\n";
	}
	
}
