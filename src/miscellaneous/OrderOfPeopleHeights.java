/**
 * 
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author PRATAP LeetCode 406
 *
 */
public class OrderOfPeopleHeights {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> height = new ArrayList<Integer>(N);
			ArrayList<Integer> infront = new ArrayList<Integer>(N);
			String[] heights = br.readLine().split("\\s+");
			String[] infronts = br.readLine().split("\\s+");
			for (int i = 0; i < N; i++) {
				height.add(Integer.parseInt(heights[i]));
				infront.add(Integer.parseInt(infronts[i]));
			}
			ArrayList<Integer> order = findOrder(height, infront);
			System.out.println(order);
		}
	}

	public static ArrayList<Integer> findOrder(ArrayList<Integer> height, ArrayList<Integer> infront) {
		// Write your code here...
		int n = height.size();
		List<Person> persons = new ArrayList<>(n);
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			persons.add(new Person(height.get(i), infront.get(i)));
			result.add(0);
			res[i] = -1;
		}
		Collections.sort(persons, new PersonComp());
		
		for (int i = 0; i < n; i++) {
			Person curr = persons.get(i);
			int count = curr.infront;
			for (int j = 0; j < n; j++) {
				if (res[j] == -1 && count == 0) {
					res[j] = curr.ht;
					result.set(j, curr.ht);
					break;
				} else if (res[j] == -1 || res[j] > curr.ht) {
					count--;
				}
			}
		}
		return result;
	}
	
//	LeetCode
	public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
		List<Person> persons = new ArrayList<>(n);
		int[][] result = new int[n][2];
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			persons.add(new Person(people[i][0], people[i][1]));
			res[i] = -1;
		}
		Collections.sort(persons, new PersonComp());
		
		for (int i = 0; i < n; i++) {
			Person curr = persons.get(i);
			int count = curr.infront;
			for (int j = 0; j < n; j++) {
				if (res[j] == -1 && count == 0) {
					res[j] = curr.ht;
					result[j][0] = curr.ht;
                    result[j][1] = curr.infront;
					break;
				} else if (res[j] == -1 || res[j] >= curr.ht) {
					count--;
				}
			}
		}
		return result;
    }
}

class PersonComp implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		int c = Integer.compare(o1.ht, o2.ht);
		if (c == 0)
			c = Integer.compare(o1.ht, o2.ht);
		return c;
	}
}

class Person {
	public int ht;
	public int infront;

	public Person(int ht, int infront) {
		super();
		this.ht = ht;
		this.infront = infront;
	}

}