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
	String wordClickFileName = "output\\WordClicks.cvs";
	String pageClickFileName = "output\\PageClicks.cvs";
	String userName;
	String timeStamp;
	String coor;
	String place;
	String clickedWord;
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
		PageClickModel pcm = null;
		WordCloud wc = new WordCloud();
		WebPageList wpl = new WebPageList();
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
				//System.out.println("Found a WordCloudList!");
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
				clickedWord = line.replace("CLICKED WORD: ", "");
				wcm.addClickedWord(clickedWord);

				// finish up generating the wcm - needs the WordCloud
				wcm.addNumberOfWords(wc.size());  // Add size of wordCloud
				wcm.addWordSize(wc.getSize(clickedWord));
				wcm.addWordColor(wc.getColor(clickedWord));
				wcm.addWordRank(wc.position(clickedWord)); // Add clicked word's rank
				
			} else if (line.startsWith("WEBPAGELIST")) {
				// Skal lage en PageClick entry
				wpl.clear();  // må tømme web page list for tidligere innhold.
				pcm = new PageClickModel(userName, timeStamp);
				pcm.addCoordinates(coor);
				pcm.addPlace(place);
				pcm.addClickedWord(clickedWord);
				pageClickWriter.append(pcm.toString());
				
				System.out.println("PageClickModel: " + pcm);

			} else if (line.startsWith("\tPAGE")) {
				wpl.add(line.replace("\tPAGE:", ""));
			}
			else if (line.startsWith("SELECT")) {
				String page = line.replace("SELECT:", "");
				System.out.println("Page is: " + page);
				pcm.addClickedPage(page);
				pcm.addPageRank(wpl.pageRank(page));
				pcm.addNumberOfPages(wpl.size());
				System.out.println("PageClickModel: " + pcm);
				
				// Write to file
				wordClickWriter.append(pcm.toString());
				
			} else if (line.startsWith("REDRAW")) {
				// TODO: Burde vi endret place til denne verdien?
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
			File folder = new File("data");
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				File file = listOfFiles[i];
				if (file.isFile() ) {
					an.run(file.getName());
				}
			}

			//an.run("Richa.txt");
		} catch (IOException e) {
		}
	}
}