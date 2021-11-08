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
		System.out.println("Enter the numbers : ");
		String[] buffer = br.readLine().trim().split("\\s+");
		int[] input = new int[buffer.length];
		for (int i = 0; i < buffer.length; i++)
			input[i] = Integer.parseInt(buffer[i]);
		System.out.println("Even List : ");
		printList(filterEven(input));
		System.out.println("Odd List : ");
		printList(filterOdd(input));
		System.out.println("Numbers Less than 5 List : ");
		printList(filterLessThanFive(input));
	}

	private static List<Integer> filterLessThanFive(int[] input) {
		// TODO Auto-generated method stub
		return filter(new Filtering() {
			@Override
			public int filter(int n) {
				// TODO Auto-generated method stub
				return n < 5 ? n : -1;
			}
		}, input);
	}

	private static List<Integer> filterOdd(int[] input) {
		// TODO Auto-generated method stub
		return filter(new OddFilter(), input);
	}

	private static List<Integer> filterEven(int[] input) {
		// TODO Auto-generated method stub
		return filter(new EvenFilter(), input);
	}

	private static List<Integer> filter(Filtering func, int[] input) {
		// TODO Auto-generated method stub
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			if (func.filter(input[i]) == input[i])
				result.add(input[i]);
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