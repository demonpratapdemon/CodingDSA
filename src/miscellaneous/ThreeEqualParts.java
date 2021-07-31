/**
 * 
 */
package miscellaneous;

/**
 * @author PRATAP
 *
 */
public class ThreeEqualParts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 1, 1, 0, 0, 1 };
//		int[] arr = { 0, 0, 0, 0 };
//		int[] arr = { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1 };
		int[] arr = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0,
				0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0 };
		ThreeEqualParts obj = new ThreeEqualParts();
		int[] ans = obj.threeEqualParts(arr);
//		System.out.println(Integer.parseInt("00000010101110101110000100000000000000000", 2));
		if (ans != null)
			System.out.println(ans[0] + " " + ans[1]);
	}

	public int[] threeEqualParts(int[] arr) {
		int ones = 0;
		for (int i : arr) {
			if (i == 1)
				ones++;
		}
		if (ones % 3 > 0) {
			return new int[] { -1, -1 };
		} else if (ones == 0) {
			return new int[] { 0, arr.length - 1 };
		}
		int n = arr.length;
		int one = ones / 3, two = ones / 3, three = ones / 3;
		int first = -1, second = -1, third = -1;
		int i = 0;
		while (one > 0 && i < n) {
			if (first == -1 && arr[i] == 1) {
				first = i;
				one--;
			} else if (arr[i] == 1)
				one--;
			i++;
		}
		while (two > 0 && i < n) {
			if (second == -1 && arr[i] == 1) {
				second = i;
				two--;
			} else if (arr[i] == 1)
				two--;
			i++;
		}
		while (three > 0 && i < n) {
			if (third == -1 && arr[i] == 1) {
				third = i;
				three--;
			} else if (arr[i] == 1)
				three--;
			i++;
		}
		int a = first + 1, b = second + 1, c = third + 1;
		int[] ans = new int[2];
		boolean flag = false;
		while ((c < n) && (a < second && b < third)) {
			if (arr[a] == arr[b] && arr[b] == arr[c]) {
				a++;
				b++;
				c++;
			} else {
				flag = true;
				break;
			}
		}
		if (flag)
			return new int[] { -1, -1 };
		ans[0] = a - 1;
		ans[1] = b;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		for (i = 0; i < ans[0] + 1; i++) {
			if (sb1.length() == 0 && arr[i] == 0)
				continue;
			sb1.append(arr[i]);
		}
		for (i = ans[0] + 1; i < ans[1]; i++) {
			if (sb2.length() == 0 && arr[i] == 0)
				continue;
			sb2.append(arr[i]);
		}
		for (i = ans[1]; i < n; i++) {
			if (sb3.length() == 0 && arr[i] == 0)
				continue;
			sb3.append(arr[i]);
		}
		if (sb1.toString().equalsIgnoreCase(sb2.toString()) && sb1.toString().equalsIgnoreCase(sb3.toString())) {
			return ans;
		} else
			return new int[] { -1, -1 };
	}
}
