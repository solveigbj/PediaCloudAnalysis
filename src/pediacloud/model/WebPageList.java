package pediacloud.model;

import java.util.ArrayList;
import java.util.Iterator;

public class WebPageList {
	
   ArrayList<String> pages;
   
   public WebPageList() {
	   pages = new ArrayList<String>();
   }
   
   public void add (String page) {
	   pages.add(page);
   }
   
   public int pageRank (String str) { 
		int pos = 0;
		for(Iterator<String> i = pages.iterator(); i. hasNext();) {
			String item = i.next();
			pos++;
			System.out.println("Inside of pageRank. Pos = " + pos);
			if (item.equals(str)) {
				return pos;
			} else if (str.startsWith(item)) {
				System.out.println("Inside pageRank. Almost identical. Item = " + item + " and string = " + str);
				return pos;
			}
		}
		return 0;
	   
   }
   public int size() { return pages.size(); }
   public void clear() { pages.clear(); }
}
