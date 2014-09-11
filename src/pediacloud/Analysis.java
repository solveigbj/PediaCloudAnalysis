package pediacloud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import pediacloud.model.WordClickModel;
import pediacloud.model.WordCloud;
import pediacloud.model.WordLine;

/**
 * Does the main analysis of the input file and generates two files for the
 * WordClick and PageClick data respectively.
 * 
 * @author sinso
 *
 */
public class Analysis {
	String path = "D:\\DropBox\\PediaCloud\\Userdata\\";
	String wordClickFileName = "WordClicks.cvs";
	String pageClickFileName = "PageClicks.cvs";
	String userName;
	String timeStamp;
	String coor;
	String place;
	private FileWriter outWordStream;
	private FileWriter outPageStream;

	public void run(String fileName) throws IOException {
		String inputFile = path + fileName;
		userName = fileName.replace(".txt", "");
		FileReader inputStream = null;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(inputFile));
			outWordStream = new FileWriter(wordClickFileName);
			outPageStream = new FileWriter(pageClickFileName);
			analyze(br);

		} finally {
			if (inputStream != null) {
				inputStream.close();
				br.close();
			}
			if (outWordStream != null) {
				outWordStream.close();
			}
			if (outPageStream != null) {
				outPageStream.close();
			}
		}
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
		line = br.readLine();
		// Check the file
		while (line != null) {
			st = new StringTokenizer(line, ":");
			token = st.nextToken();
			if (token.equals("STARTED")) {
				// found line with start time
				timeStamp = line.replace("STARTED: ", "");
				/* 
				 * If this line is encountered and we have a full WordCloud list, we do not need it, and can get rid of it.
				 */
				if (!wc.isEmpty()) wc.clear();
				
			} else if (token.equals("COOR")) {
				coor = line.replace("COOR: ", "").trim();
				//System.out.println("Coor: " + coor);
			} else if (token.equals("PLACE")) {
				place = line.replace("PLACE: ", "");
			} else if (token.equals("WORDCLOUDLIST")) {
				//System.out.println("Have found a WordCloudList!");
				wcm = new WordClickModel(userName, timeStamp);
				wcm.addCoordinates(coor);
				wcm.addPlace(place);
				System.out.println("WCM: " + wcm);
				line = br.readLine();
				wc = new WordCloud();
				while (line.startsWith("\tWORD:")) {
					wc.add(line.replace("\tWORD: ", ""));
					// we should parse the remainder of the line
					String temp = line.replace("\tWORD: ", "");
					wc.add(temp);
					StringTokenizer sto = new StringTokenizer(temp);
					System.out.println("The remaining string is: " + temp);
					//wcm.addClickedWord(sto.nextToken());
					//wcm.addWordSize(new Integer(sto.nextToken()));
					line = br.readLine();
				}
				System.out.println("WCM after finishing the words: " + wcm);
				
				if (line.startsWith("CLICKED WORD")) {
					System.out.println("Have found a clicked word.");
					// Finish creating the wcm
					String clickedWord = line.replace("CLICKED WORD: ", "");
					System.out.println("The clicked word is: " + clickedWord);
					wcm.addClickedWord(clickedWord);
					System.out.println(wcm);
					
					// finish up generating the wcm - needs the WordCloud
					System.out.println("The size of the Word Cloud is: " + wc.size());
					wcm.addNumberOfWords(wc.size());
					int i = wc.position(clickedWord);
					if (i == 0) {
						System.out.println("Not found");
					}
					else if (i > 0) {
						wcm.addWordRank(i);
					}
					System.out.println("WCM after adding rank "+wcm);
					line = br.readLine();
					while (line.startsWith("\tPAGE:")){
					
					}
				}
				
			}
			line = br.readLine();
		}
		System.out.println("Reached eof");
	}

	public static void main(String args[]) {
		Analysis an = new Analysis();
		try {
			an.run("Richa.txt");
		} catch (IOException e) {
		}
	}
}