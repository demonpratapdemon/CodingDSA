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
 * @author PRATAP
 *
 */
public class BinarySuccessor {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a Number in Binary : ");
		String[] input = br.readLine().split("\\s+");
		List<Integer> inputVector = new ArrayList<Integer>();
		for (String s : input)
			inputVector.add(Integer.parseInt(s));
		List<Integer> nextNumber = succ_b(inputVector);
		System.out.println("Next Number in Binary is : " + nextNumber);
	}

	private static List<Integer> succ_b(List<Integer> inputVector) {
		// TODO Auto-generated method stub
		int n = inputVector.size();
		List<Integer> outputVector = new ArrayList<Integer>();
		int carry = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (inputVector.get(i) == 1 && carry == 1) {
				outputVector.add(0, 0);
				carry = 1;
			} else {
				outputVector.add(0, 1);
				carry = 0;
			}
		}
		if (carry == 1) {
			outputVector.add(0, 1);
			carry = 0;
		}
		return outputVector;
	}

}
