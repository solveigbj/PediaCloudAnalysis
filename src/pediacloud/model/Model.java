package pediacloud.model;

/**
 * @author sinso
 *
 */
public class Model {
	private String person;
	private String startTime;
	private String coordinates;
	private String place;
	private String clickedWord;
	protected static String SEPARATOR = "; "; 

	Model(String per, String time) {
		person = per;
		startTime = time;
	}

	public void addStartTime(String time) {
		startTime = new String("time");
	}

	public void addCoordinates(String coor) {
		coordinates = coor;
	}

	public void addPlace(String pl) {
		place = pl;
	};

	public void addClickedWord(String word) {
		clickedWord = word;
	}

	public String toString() {
		return person + "; " + startTime + SEPARATOR + coordinates + SEPARATOR
				+ place + SEPARATOR + clickedWord + SEPARATOR;
	}
}
