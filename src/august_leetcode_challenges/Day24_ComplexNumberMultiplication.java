/**
 * 
 */
package august_leetcode_challenges;

/**
 * @author PRATAP
 *
 */
public class Day24_ComplexNumberMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String num1 = "1+1i", num2 = "1+1i";
		String num1 = "1+-1i", num2 = "1+-1i";
		Day24_ComplexNumberMultiplication obj = new Day24_ComplexNumberMultiplication();
		String ans = obj.complexNumberMultiply(num1, num2);
		System.out.println(ans);
	}

	public String complexNumberMultiply(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		String[] input1 = num1.split("\\+");
		String[] input2 = num2.split("\\+");
		int real = 0, complex = 0;
		for (int i = 0; i < input1.length; i++) {
			for (int j = 0; j < input2.length; j++) {
				if (!input1[i].contains("i") && !input2[j].contains("i")) {
					real += Integer.parseInt(input1[i]) * Integer.parseInt(input2[i]);
				} else if (!input1[i].contains("i") && input2[j].contains("i")) {
					int a = Integer.parseInt(input1[i]);
					int b = Integer.parseInt(input2[j].substring(0, input2[j].length() - 1));
					complex += a * b;
				} else if (input1[i].contains("i") && !input2[j].contains("i")) {
					int a = Integer.parseInt(input1[i].substring(0, input1[i].length() - 1));
					int b = Integer.parseInt(input2[j]);
					complex += a * b;
				} else {
					int a = Integer.parseInt(input1[i].substring(0, input1[i].length() - 1));
					int b = Integer.parseInt(input2[j].substring(0, input2[j].length() - 1));
					real += -(a * b);
				}
			}
		}
		sb.append(real).append("+").append(complex).append("i");
		return sb.toString();
	}
}
