package pediacloud.model;

/**
 * @author sinso
 *
 */
public class PageClickModel extends Model {

	private int clickedPage;
	private int pageRank;
	private int numberOfPages;

	public PageClickModel(String per, String time) {
		super(per, time);
	}

	public void addClickedPage() {}
	public void addPageRank() {}
	public void addNumberOfPages() {}
	
	public String toString() {
		return super.toString() + clickedPage + "; " + pageRank + "; "
				+ numberOfPages + "\n";
	}
	
}
