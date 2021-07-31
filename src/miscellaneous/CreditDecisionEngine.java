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
import java.util.HashMap;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class CreditDecisionEngine {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, BData> map = new HashMap<String, BData>();
		double avgSp = 0;
		double mod = (double) (1e9 + 7);
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(",");
			if (input.length < 8)
				continue;
			String fName = "";
			String lName = "";
			float anSp = 0;
			float totAss = 0;
			float totLia = 0;
			int homeFlag = 0;
			int bScore = 0;
			float credit = 0;
			if (!input[0].equalsIgnoreCase(""))
				fName = input[0];
			if (!input[1].equalsIgnoreCase(""))
				lName = input[1];
			if (!input[2].equalsIgnoreCase(""))
				anSp = Float.parseFloat(input[2]);
			if (!input[3].equalsIgnoreCase(""))
				totAss = Float.parseFloat(input[3]);
			if (!input[4].equalsIgnoreCase(""))
				totLia = Float.parseFloat(input[4]);
			if (!input[5].equalsIgnoreCase("") && !input[5].equalsIgnoreCase("NA"))
				homeFlag = Integer.parseInt(input[5]);
			if (!input[6].equalsIgnoreCase(""))
				bScore = Integer.parseInt(input[6]);
			if (!input[7].equalsIgnoreCase(""))
				credit = Float.parseFloat(input[7]);
			String key = fName + " " + lName;
			BData obj = new BData(fName, lName, anSp, totAss, totLia, homeFlag, bScore, credit);
			if (!fName.equalsIgnoreCase("") && !lName.equalsIgnoreCase(""))
				map.put(key, obj);
			else
				map.put(key.trim(), obj);
			avgSp += obj.anSp;
			avgSp %= mod;
		}
		avgSp /= n;
		int M = Integer.parseInt(br.readLine());
		CustData[] customers = new CustData[M];
		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(",");
			String id = input[0];
			String fName = "";
			String lName = "";
			float income = 0;
			if (!input[1].equalsIgnoreCase(""))
				fName = input[1];
			if (!input[2].equalsIgnoreCase(""))
				lName = input[2];
			if (!input[3].equalsIgnoreCase(""))
				income = Float.parseFloat(input[3]);
			customers[i] = new CustData(id, fName, lName, income);
		}
		CreditDecisionEngine obj = new CreditDecisionEngine();
		List<Pair> applicationIds = obj.select(map, customers, M, avgSp);
		Collections.sort(applicationIds, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.id.compareTo(o2.id);
			}
		});
		for (Pair p : applicationIds)
			System.out.println(p.id + "," + p.flag);
	}

	private List<Pair> select(HashMap<String, BData> map, CustData[] customers, int m, double avgSp) {
		List<Pair> res = new ArrayList<Pair>();
		System.out.println(avgSp);
		for (int i = 0; i < m; i++) {
			if (rule1(map, customers[i], avgSp) || rule2(map, customers[i], avgSp)) {
				res.add(new Pair(customers[i].id, "Yes"));
			} else {
				res.add(new Pair(customers[i].id, "No"));
			}
		}
		return res;
	}

	private boolean rule1(HashMap<String, BData> map, CustData custData, double avgSp) {
		if (custData.fName.equalsIgnoreCase("") && custData.lName.equalsIgnoreCase(""))
			return false;
		BData bdata = map.getOrDefault(custData.fName + " " + custData.lName, null);
		if (bdata == null)
			return false;
		if (bdata.totAss > bdata.totLia && bdata.bScore > 50 && (double) (bdata.anSp / custData.income) > 0.1
				&& bdata.anSp > avgSp) {
			return true;
		}
		return false;
	}

	private boolean rule2(HashMap<String, BData> map, CustData custData, double avgSp) {
		if (custData.fName.equalsIgnoreCase("") && custData.lName.equalsIgnoreCase(""))
			return false;
		BData bdata = map.getOrDefault(custData.fName + " " + custData.lName, null);
		if (bdata == null)
			return false;
		if (bdata.totAss > bdata.totLia && bdata.homeFlag == 1 && bdata.bScore > 30
				&& (double) (bdata.anSp / custData.income) > 0.1 && bdata.anSp > avgSp)
			return true;
		return false;
	}

}

class Pair {
	public String id;
	public String flag;

	public Pair(String id, String flag) {
		super();
		this.id = id;
		this.flag = flag;
	}

}

class CustData {
	public String id;
	public String fName;
	public String lName;
	public float income;

	public CustData(String id, String fName, String lName, float income) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.income = income;
	}

}

class BData {
	public String fName;
	public String lName;
	public double anSp;
	public float totAss;
	public float totLia;
	public int homeFlag;
	public int bScore;
	public float credit;

	public BData(String fName, String lName, float anSp, float totAss, float totLia, int homeFlag, int bScore,
			float credit) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.anSp = anSp;
		this.totAss = totAss;
		this.totLia = totLia;
		this.homeFlag = homeFlag;
		this.bScore = bScore;
		this.credit = credit;
	}

}
