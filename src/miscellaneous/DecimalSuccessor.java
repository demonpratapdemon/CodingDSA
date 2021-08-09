/**
 * 
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class DecimalSuccessor {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a Number in Binary : ");
		Integer input = Integer.parseInt(br.readLine());
		int output = succ_d(input);
		System.out.println("Next Number is : " + output);
	}

	private static int succ_d(int input) {
		// TODO Auto-generated method stub
		return input + 1;
	}

}
