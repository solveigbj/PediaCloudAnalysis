package pediacloud.model;

/**
 * @author sinso
 *
 */
public class PageClickModel extends Model {

	private int clickedPage;
	private int pageRank;
	private int numberOfPages;

	PageClickModel(String per) {
		super(per);
	}

	public void addClickedPage() {}
	public void addPageRank() {}
	public void addNumberOfPages() {}
	
	public String toString() {
		return super.toString() + clickedPage + ", " + pageRank + ", "
				+ numberOfPages;
	}
	
}
