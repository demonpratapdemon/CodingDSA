/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP
 *
 */
public class DeleteCharactersToMakeFancyString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabaaaa";
		DeleteCharactersToMakeFancyString obj = new DeleteCharactersToMakeFancyString();
		String ans = obj.makeFancyString(s);
		System.out.println(ans);
	}

	public String makeFancyString(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == 0) {
				sb.append(s.charAt(i));
				count++;
			} else {
				if (s.charAt(i) == sb.charAt(sb.length() - 1) && count != 2) {
					sb.append(s.charAt(i));
					count++;
				} else if (s.charAt(i) != sb.charAt(sb.length() - 1)) {
					sb.append(s.charAt(i));
					count = 1;
				}
			}
		}
		return sb.toString();
	}
}
