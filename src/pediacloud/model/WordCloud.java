package pediacloud.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class WordCloud {
	
	ArrayList<WordLine> wordCloud;
	WordLine[] array;
	public WordCloud() {
		wordCloud = new ArrayList<WordLine>();
	}

	public void add(String content)
	{
		StringTokenizer st = new StringTokenizer(content);
		String[] selected = new String[3];
		for (int i = 0; i<3; i++) {
			selected[i] = st.nextToken();
		}

		wordCloud.add(new WordLine(selected));
	}
	
	public int getWordSize(String word) {

		for (Iterator<WordLine> i = wordCloud.iterator(); i.hasNext();){
			WordLine item = i.next();
			if (item.getWord().equals(word)) {
				return item.getWordSize();
			}
		}
		return 0;
	}

	public int getColor(String word) {
		for (Iterator<WordLine> it = wordCloud.iterator(); it.hasNext();){
			WordLine item = it.next();
			if (item.getWord().equals(word)) {
				return item.getColor();
			}
		}
		return 0;
	}
	
	/**
	 * Returns 1 if no other words are found with bigger size, 
	 * or the words rank in the collection.
	 * @param word The word that has been clicked
	 * @return The word's rank in the collection.
	 */
	public int getRank (String word) {
		int wordSize = getWordSize(word);
		System.out.println("WordSize = " + wordSize);
		int count = 0;
		for(Iterator<WordLine> i = wordCloud.iterator(); i.hasNext();) {
			WordLine item = i.next();
			if (item.getWordSize()> wordSize) {
				count++;
			}
		}
		return count+1;
	}
	
	public boolean isEmpty() {
		return wordCloud.isEmpty();
	}

	public int size () {
		return wordCloud.size();
	}
	public void clear() {
		wordCloud.clear();
	}
}
