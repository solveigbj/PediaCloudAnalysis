package pediacloud.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class WordCloud {
	
	ArrayList<WordLine> wordCloud;
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
	
	public boolean findWord(String word) {
		for ( Iterator<WordLine> i = wordCloud.iterator(); i.hasNext();) {
			WordLine item = i.next();
			if (item.getWord().equals(word)) {
				return true;
			}
		}
		return false;
	}
	public int position (String word) {
		int pos = 0;
		for(Iterator<WordLine> i = wordCloud.iterator(); i. hasNext();) {
			WordLine item = i.next();
			pos++;
			if (item.getWord().equals(word))
				return pos;
		}
		return pos;
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
