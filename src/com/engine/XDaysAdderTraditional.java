/**
 * 
 */
package com.engine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author jmaro
 *
 */
public class XDaysAdderTraditional implements IXDaysAdder {
	private int days = 0;
	private final String random_noun_url = "http://www.desiquintans.com/noungenerator?count=1";
	private final String random_noun_url_multi = "http://www.desiquintans.com/noungenerator?count=";
	private final String[] orig12Items = 
	{"partridge in a pear tree",
	 "turtle doves",
	 "french hens",
	 "calling birds",
	 "gold rings",
	 "geese a-laying",
	 "swans a-swimming",
	 "maids a-milking",
	 "ladies dancing",
	 "lords a-leaping",
	 "pipers piping",
	 "drummers drumming"
	};
	private ArrayList<String> itemText =
			new ArrayList<String>(Arrays.asList(orig12Items));
	

	/* (non-Javadoc)
	 * @see com.engine.IXDaysAdder#getTotalItems(int)
	 */
	@Override
	public int getTotalItems(int days) {
		int result = days;
		this.days = days;
		if (days > 1) {
			result = 0;
			for (int i = 1; i <= days; i++) {
				result += i;
			}
		}
		return result;
	}

	@Override
	public void printItems(PrintStream ps) {
		String outputList = "No days were supplied.";
		String currentDay = null;
		if (days > 0) {
			if (days > 12) {
				addToItemList(days - 12); // add enough items after the 12 given
			}
			outputList = ""; // clear the output list
			for (int i = 0; i < days; i++) {
				int currDay = i + 1;
				currentDay = "Day: " + currDay +
						     "\tItems: " + currDay + " " +
							 itemText.get(i) + "\n";
				outputList = outputList.concat(currentDay);
			}
		} 
		ps.print(outputList);
	}
	
	public void addToItemList(int amountToAdd) {
		itemText.addAll(getRandomNouns(amountToAdd));
	}
	
	private List<String> getRandomNouns(int nounCount) {
		List<String> result = new ArrayList<String>();
		int remaining = nounCount;
		String url;
		while (remaining / 10 > 0) {
			url = random_noun_url_multi + "10";
			String[] nouns = randomNounGet(url);
			for (int i = 0; i < 10; i++) {
				String newItem = nouns[i].toLowerCase() + "s";
				result.add(newItem);
			}
			remaining -= 10;
		}
		url = random_noun_url_multi + remaining;
		try {
			String[] nouns = randomNounGet(url);
			for (int i = 0; i < remaining; i++) {
				String newItem = nouns[i].toLowerCase() + "s";
				result.add(newItem);
			}
		} catch (Exception e) {
			System.out.println("ERROR: Could not reach the random noun website: " + random_noun_url);
			System.out.println("Error message: " + e.getMessage());
		}
		return result;
	}
	
	protected String getRandomNoun() {
		String result = "Panther";
		try {
			Document doc = Jsoup.connect(random_noun_url).get();
			Element content = doc.getElementById("ContentContainer");
			Elements greenBoxes = content.getElementsByClass("greenBox");
			Element li = greenBoxes.get(0).getElementsByTag("ol").
					get(0).getElementsByTag("li").get(0);
			result = li.text();
		} catch (Exception e) {
			System.out.println("ERROR: Could not reach the random noun website: " + random_noun_url);
			System.out.println("Error message: " + e.getMessage());
		}
		System.out.println("Result: " + result);
		return result;
	}
	
	private String[] randomNounGet(String url) {
		String[] result = null;
		try {
			Document doc = Jsoup.connect(url).get();
			Element ol = doc.getElementById("ContentContainer").getElementsByClass("greenBox").
					get(0).getElementsByTag("ol").get(0);
			result = ol.text().trim().split(" ");
		} catch (Exception e) {
			System.out.println("ERROR: Could not reach the random noun website: " + random_noun_url);
			System.out.println("Error message: " + e.getMessage());
		}
		return result;
	}

}
