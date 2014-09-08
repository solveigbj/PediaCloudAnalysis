package pediacloud.model;

import java.util.Date;

class Model {
	private String person;
	private Date startTime; 
	private String coordinates;
	private String place;
	private String clickedWord;

	Model (String per) {
		person = per;
	}
	
	public void addStartTime (Date time) { startTime = time;  }
	public void addCoordinates (String coor) { coordinates = coor; }
	public void addPlace (String pl) { place = pl; };
	public void addClickedWord (String word) { clickedWord = word; }
	
	
	public String toString () {  
		return person + ", " + startTime.toString() + ", " + coordinates + ", " + place + ", " + clickedWord + ", ";
	}
}
