package pediacloud;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import pediacloud.model.PageClickModel;
import pediacloud.model.WebPageList;
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
	String wordClickFileName = "output\\WordClicks.csv";
	String pageClickFileName = "output\\PageClicks.csv";
	String userName;
	String timeStamp;
	String coor;
	String place;
	String clickedWord;
	String y;
	int max_y;
	private FileWriter wordClickWriter;
	private FileWriter pageClickWriter;

	public void run(String fileName) throws IOException {
		String inputFile = path + fileName;
		userName = fileName.replace(".txt", "");
		FileReader inputStream = null;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(inputFile));
			// Open output files in append mode
			wordClickWriter = new FileWriter(wordClickFileName,true);

			pageClickWriter = new FileWriter(pageClickFileName, true);

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
	}

	/**
	 * @param br - bufferedReader
	 * @throws IOException
	 */
	private void analyze(BufferedReader br) throws IOException {
		StringTokenizer st;
		String line;
		String token;
		WordClickModel wcm = null;
		PageClickModel pcm = null;
		WordCloud wc = new WordCloud();
		WebPageList wpl = new WebPageList();
		// read through the file line by line
		line = br.readLine(); // Read first line
		while (line != null) {
			st = new StringTokenizer(line, ":");
			token = st.nextToken();
			if (token.equals("STARTED")) { // always the first line
				timeStamp = line.replace("STARTED: ", ""); // keep the timestamp

			} else if (token.equals("COOR")) {
				coor = line.replace("COOR: ", "").trim();
			} else if (token.equals("PLACE")) {
				place = line.replace("PLACE: ", "");
			} else if (token.equals("WORDCLOUDLIST")) {
				max_y = 0;
				wcm = new WordClickModel(userName, timeStamp);
				wcm.addCoordinates(coor);
				wcm.addPlace(place);
				wc.clear(); //When a new word cloud list starts, we get rid of previous content
			} else if (token.equals("\tWORD")) {
				// Add remainder to the word cloud
				wc.add(line.replace("\tWORD: ", ""));  // add word info to WordCloudList
			} else if (line.startsWith("CLICKED WORD")) {
				clickedWord = line.replace("CLICKED WORD: ", "");
				wcm.addClickedWord(clickedWord);

				// finish up generating the wcm - needs the WordCloud
				wcm.addNumberOfWords(wc.size());  // Add size of wordCloud
				wcm.addWordSize(wc.getWordSize(clickedWord));
				wcm.addWordColor(wc.getColor(clickedWord));
				wcm.addWordRank(wc.getRank(clickedWord)); // Add clicked word's rank
				wcm.addY(wc.getSelectedY(clickedWord));
				wcm.addMaxY(wc.getMaxY());
				wordClickWriter.append(wcm.toString());
				
			} else if (line.startsWith("WEBPAGELIST")) {
				// Skal lage en PageClick entry
				wpl.clear();  // må tømme web page list for tidligere innhold.
				pcm = new PageClickModel(userName, timeStamp);
				pcm.addCoordinates(coor);
				pcm.addPlace(place);
				pcm.addClickedWord(clickedWord);
				
			} else if (line.startsWith("\tPAGE")) {
				wpl.add(line.replace("\tPAGE:", ""));
			}
			else if (line.startsWith("SELECT")) {
				String page = line.replace("SELECT:", "");
				pcm.addClickedPage(page);
				pcm.addPageRank(wpl.pageRank(page));
				pcm.addNumberOfPages(wpl.size());
				
				// Write to file
				pageClickWriter.append(pcm.toString());
				
			} 
			// The remaining information is not used (Yet)
			else if (line.startsWith("REDRAW")) {
				max_y = 0;
				// TODO: Burde vi endret place til denne verdien?
			} else if (line.startsWith("FOCUS")) {

			} else if (line.startsWith("ENDED")) {
			}
			if (br != null) {
				line = br.readLine();
			}
		}
	}

	public static void main(String args[]) {
		Analysis an = new Analysis();
		try {
			File folder = new File("data");
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				File file = listOfFiles[i];
				if (file.isFile() ) {
					an.run(file.getName());
				}
			}
		} catch (IOException e) {
		}
	}
}