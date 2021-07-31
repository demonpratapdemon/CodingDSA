/**
 * 
 */
package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author PRATAP
 *
 */
public class MajorityElementII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,3};
		List<Integer> ans = majorityElement(nums);
		System.out.println(ans);
	}

	@SuppressWarnings("unchecked")
	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums.length <= 0)
			return res;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int k = nums.length / 3;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int count = map.get(nums[i]);
				count++;
				map.put(nums[i], count);
			} else {
				map.put(nums[i], 1);
			}
		}
		Iterator<?> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) itr.next();
			if (pair.getValue() > k) {
				res.add(pair.getKey());
			}
		}
		System.out.println(res.size());
		return res;
	}

}
