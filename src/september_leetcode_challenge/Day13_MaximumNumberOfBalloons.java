/**
 * 
 */
package september_leetcode_challenge;

import java.util.HashMap;

/**
 * @author PRATAP LeetCode 1189
 *
 */
public class Day13_MaximumNumberOfBalloons {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "loonbalxballpoon";
		Day13_MaximumNumberOfBalloons obj = new Day13_MaximumNumberOfBalloons();
		int ans = obj.maxNumberOfBalloons(text);
		System.out.println(ans);
	}

	public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : text.toCharArray()) {
            if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n')
                map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = 0;
        String temp = "balloon";
        while (map.size() > 0) {
            boolean flag = false;
            for (int i = 0; i < temp.length(); i++) {
                if (map.containsKey(temp.charAt(i))) {
                    map.put(temp.charAt(i), map.get(temp.charAt(i)) - 1);
                    if (map.get(temp.charAt(i)) == 0)
                        map.remove(temp.charAt(i));
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                count++;
            else
                break;
        }
		return count;
	}
}
