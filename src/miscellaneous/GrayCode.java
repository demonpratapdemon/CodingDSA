/**
 * 
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP LeetCode 89
 *
 */
public class GrayCode {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> ans = grayCode(n);
		System.out.println(ans);
	}

	public static List<Integer> grayCode(int n) {
		List<String> list = solve(n);
		List<Integer> res = new ArrayList<Integer>();
		for (String str : list)
			res.add(Integer.parseInt(str, 2));
		return res;
	}

	private static List<String> solve(int n) {
		// TODO Auto-generated method stub
		if (n == 1) {
			List<String> baseRes = new ArrayList<String>();
			baseRes.add("0");
			baseRes.add("1");
			return baseRes;
		}
		List<String> prevRes = solve(n - 1);
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < prevRes.size(); i++) {
			res.add("0" + prevRes.get(i));
		}
		for (int i = prevRes.size() - 1; i >= 0; i--) {
			res.add("1" + prevRes.get(i));
		}
		return res;
	}

}
