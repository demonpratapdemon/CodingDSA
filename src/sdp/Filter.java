/**
 * 
 */
package sdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class Filter {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		printList(filterEven(n));
		printList(filterOdd(n));
		printList(filterLessThanFive(n));
	}

	private static List<Integer> filterLessThanFive(int n) {
		// TODO Auto-generated method stub
		return filter(new Filtering() {
			@Override
			public int filter(int n) {
				// TODO Auto-generated method stub
				return n < 5 ? n : -1;
			}
		}, n);
	}

	private static List<Integer> filterOdd(int n) {
		// TODO Auto-generated method stub
		return filter(new OddFilter(), n);
	}

	private static List<Integer> filterEven(int n) {
		// TODO Auto-generated method stub
		return filter(new EvenFilter(), n);
	}

	private static List<Integer> filter(Filtering func, int n) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++) {
			if (func.filter(i) == i)
				result.add(i);
		}
		return result;
	}

	private static void printList(List<Integer> list) {
		// TODO Auto-generated method stub
		for (Integer num : list)
			System.out.print(num + " ");
		System.out.println();
	}

}

interface Filtering {
	public int filter(int n);
}

class EvenFilter implements Filtering {

	@Override
	public int filter(int n) {
		// TODO Auto-generated method stub
		if (n % 2 == 0)
			return n;
		return -1;
	}

}

class OddFilter implements Filtering {

	@Override
	public int filter(int n) {
		// TODO Auto-generated method stub
		if (n % 2 == 1)
			return n;
		return -1;
	}

}