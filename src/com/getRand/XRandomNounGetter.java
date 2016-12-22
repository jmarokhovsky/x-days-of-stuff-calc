package com.getRand;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class XRandomNounGetter {
	private static final String RANDOM_NOUN_URL_MULTI = "http://www.desiquintans.com/noungenerator?count=";
	
	public static List<String> getRandomNouns(int nounCount) {
		List<String> result = new ArrayList<String>();
		int remaining = nounCount;
		String url;
		while (remaining / 10 > 0) {
			url = RANDOM_NOUN_URL_MULTI + "10";
			String[] nouns = randomNounGet(url);
			for (int i = 0; i < 10; i++) {
//				String newItem = nouns[i].toLowerCase() + "s";
				String newItem = prepString(nouns[i]);
				result.add(newItem);
			}
			remaining -= 10;
		}
		if (remaining > 0) {
			url = RANDOM_NOUN_URL_MULTI + remaining;
			String[] nouns = randomNounGet(url);
			for (int i = 0; i < remaining; i++) {
				String newItem = prepString(nouns[i]);
				result.add(newItem);
			}
		}
		return result;
	}
	
	private static String prepString(String in) {
		char lastLetter = in.charAt(in.length() - 1);
		String pluralSuff = "s";
		switch (lastLetter) {
			case 's':
			case 'x':
				pluralSuff = "es";
				break;
			case 'h':
				if (in.charAt(in.length() - 2) != 't') {
					pluralSuff = "es";
				}
				break;
			case 'y':
				in = in.substring(0, in.length() - 1) + "ie";
				break;
		}
//		if (lastLetter == 's') {
//			pluralSuff = "es";
//		}
//		if (lastLetter == 'h') {
//			if (in.charAt(in.length() - 2) != 't') {
//				pluralSuff = "es";
//			}
//		}
//		if (lastLetter == 'y') {
//			in = in.substring(0, in.length() - 1) + "ie";
//		}
		return in.toLowerCase() + pluralSuff;
	}
	
	private static String[] randomNounGet(String url) {
		String[] result = null;
		try {
			Document doc = Jsoup.connect(url).get();
			Element ol = doc.getElementById("ContentContainer").getElementsByClass("greenBox").
					get(0).getElementsByTag("ol").get(0);
			result = ol.text().trim().split(" ");
		} catch (Exception e) {
			System.out.println("ERROR: Could not reach the random noun website: " + url);
			System.out.println("Error message: " + e.getMessage());
		}
		return result;
	}

}
