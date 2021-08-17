/**
 * 
 */
package strings;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 290
 *
 */
public class WordPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abab", s = "dog dog dog dog";
		WordPattern obj = new WordPattern();
		boolean ans = obj.wordPattern(pattern, s);
		System.out.println(ans);
	}

	public boolean wordPattern(String pattern, String s) {
		HashMap<Character, String> mapCtoS = new HashMap<Character, String>();
		HashMap<String, Character> mapStoC = new HashMap<String, Character>();
		String[] words = s.split("\\s+");
		if (pattern.length() > words.length || words.length > pattern.length())
			return false;
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (mapCtoS.containsKey(pattern.charAt(i)) && !mapCtoS.get(pattern.charAt(i)).equalsIgnoreCase(word))
				return false;
			if (mapStoC.containsKey(word) && mapStoC.get(word) != pattern.charAt(i))
				return false;
			mapCtoS.put(pattern.charAt(i), words[i]);
			mapStoC.put(words[i], pattern.charAt(i));
		}
		return true;
	}
}
