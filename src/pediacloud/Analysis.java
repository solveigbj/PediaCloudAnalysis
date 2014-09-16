package pediacloud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import pediacloud.model.WordClickModel;
import pediacloud.model.WordCloud;

/**
 * Does the main analysis of the input file and generates two files for the
 * WordClick and PageClick data respectively.
 * 
 * @author sinso
 *
 */
public class Analysis {
	String path = "data\\";
	String wordClickFileName = "output\\WordClicks.cvs";
	String pageClickFileName = "output\\PageClicks.cvs";
	String userName;
	String timeStamp;
	String coor;
	String place;
	private FileWriter wordClickWriter;
	private FileWriter pageClickWriter;

	public void run(String fileName) throws IOException {
		String inputFile = path + fileName;
		userName = fileName.replace(".txt", "");
		FileReader inputStream = null;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(inputFile));
			wordClickWriter = new FileWriter(wordClickFileName);
			pageClickWriter = new FileWriter(pageClickFileName);

			analyze(br);

		} finally {
			if (inputStream != null) {
				inputStream.close();
				br.close();
			}
			if (wordClickWriter != null) {
				wordClickWriter.flush();
				wordClickWriter.close();
			}
			if (pageClickWriter != null) {
				pageClickWriter.flush();
				pageClickWriter.close();
			}
		}
		System.out.println("The program has finished normally");
	}

	/**
	 * @param br
	 * @throws IOException
	 */
	private void analyze(BufferedReader br) throws IOException {
		StringTokenizer st;
		String line;
		String token;
		WordClickModel wcm = null;
		WordCloud wc = new WordCloud();
		// read through the file line by line
		line = br.readLine(); // Read first line
		while (line != null) {
			st = new StringTokenizer(line, ":");
			token = st.nextToken();
			if (token.equals("STARTED")) { // always the first line
				// found line with start time
				timeStamp = line.replace("STARTED: ", "");

			} else if (token.equals("COOR")) {
				coor = line.replace("COOR: ", "").trim();
			} else if (token.equals("PLACE")) {
				place = line.replace("PLACE: ", "");
			} else if (token.equals("WORDCLOUDLIST")) {
				//System.out.println("Have found a WordCloudList!");
				wcm = new WordClickModel(userName, timeStamp);
				wcm.addCoordinates(coor);
				wcm.addPlace(place);
				// Emtpy wordCloud list
				wc.clear();
			} else if (token.equals("\tWORD")) {
				// Add remainder to the word cloud
				wc.add(line.replace("\tWORD: ", ""));
			} else if (line.startsWith("CLICKED WORD")) {
				// Finish creating the wcm. Can now write it to file
				String clickedWord = line.replace("CLICKED WORD: ", "");
				wcm.addClickedWord(clickedWord);

				// finish up generating the wcm - needs the WordCloud
				wcm.addNumberOfWords(wc.size());  // Add size of wordCloud
				wcm.addWordSize(wc.getSize(clickedWord));
				wcm.addWordColor(wc.getColor(clickedWord));
				wcm.addWordRank(wc.position(clickedWord)); // Add clicked word's rank
				
				// Write to file
				wordClickWriter.append(wcm.toString());

			} else if (line.startsWith("WEBPAGELIST")) {
				System.out.println("WEBPAGELIST found");

			} else if (line.startsWith("SELECT")) {
				System.out.println("SELECT found");

			} else if (line.startsWith("REDRAW")) {
				System.out.println("REDRAW found");
			} else if (line.startsWith("FOCUS")) {
				System.out.println("FOCUS found");

			} else if (line.startsWith("ENDED")) {
				System.out.println("ENDED found");
			}
			if (br != null) {
				line = br.readLine();
			}
		}
	}

	public static void main(String args[]) {
		Analysis an = new Analysis();
		try {
			an.run("Richa.txt");
		} catch (IOException e) {
		}
	}
}