/**
 * 
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class Covid19FinancialHelp {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int best = Integer.parseInt(br.readLine());
		Customer[] bestCust = new Customer[best];
		for (int i = 0; i < best; i++) {
			String[] input = br.readLine().split("\\s+");
			String id = input[0];
			float income = Float.parseFloat(input[1]);
			float spend = Float.parseFloat(input[2]);
			bestCust[i] = new Customer(id, income, spend);
		}
		int M = Integer.parseInt(br.readLine());
		Customer[] customer = new Customer[M];
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split("\\s+");
			if (input.length < 3)
				continue;
			String id = input[0];
			float income = Float.parseFloat(input[1]);
			float spend = Float.parseFloat(input[2]);
			customer[i] = new Customer(id, income, spend);
		}
		Covid19FinancialHelp obj = new Covid19FinancialHelp();
		List<String> custIds = obj.select(bestCust, customer, M);
		Collections.sort(custIds);
		for (String s : custIds)
			System.out.println(s);
	}

	public int id = -1;

	private List<String> select(Customer[] bestCust, Customer[] customer, int m) {
		float[] D = new float[bestCust.length];
		int n = bestCust.length;
		List<String> custIds = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			float d = calculateEuDist(bestCust, customer, i, "BEST");
			D[i] = d;
		}
		for (int i = 0; i < m; i++) {
			if (customer[i] == null)
				continue;
			id = -1;
			float d1 = calculateEuDist(bestCust, customer, i, "NORMAL");

			if (id != -1 && d1 / D[id] < 1) {
				custIds.add(customer[i].id);
			}
		}
		return custIds;
	}

	private float calculateEuDist(Customer[] bestCust, Customer[] customer, int i, String check) {
		float inc = 0;
		float spend = 0;
		if (check.equalsIgnoreCase("BEST")) {
			inc = bestCust[i].income;
			spend = bestCust[i].anSp;
		} else {
			inc = customer[i].income;
			spend = customer[i].anSp;
		}
		float d = Float.MAX_VALUE;
		for (int j = 0; j < bestCust.length; j++) {
			if (i == j && check.equals("BEST"))
				continue;
			else {
				float currInc = bestCust[j].income;
				float currSpn = bestCust[j].anSp;
				float currD = ((inc - currInc) * (inc - currInc)) + ((spend - currSpn) * (spend - currSpn));
				currD = (float) Math.sqrt(currD);
				if (currD < d) {
					d = currD;
					id = j;
				}
			}
		}
		return d;
	}

}

class Customer {
	public String id;
	public float income;
	public float anSp;

	public Customer(String id, float income, float anSp) {
		super();
		this.id = id;
		this.income = income;
		this.anSp = anSp;
	}

}
