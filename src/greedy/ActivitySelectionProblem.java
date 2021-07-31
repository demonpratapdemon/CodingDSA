/**
 * 
 */
package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class ActivitySelectionProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int S[] = { 75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924 };
		int F[] = { 112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };
		int meetings = maxMeetings(S, F, S.length);
		System.out.println(meetings);
	}

	public static int maxMeetings(int start[], int end[], int n) {
		// add your code here
		List<MeetingPair> list = new ArrayList<MeetingPair>();
		for (int i = 0; i < n; i++) {
			list.add(new MeetingPair(start[i], end[i], i));
		}
		Collections.sort(list, new Comparator<MeetingPair>() {

			@Override
			public int compare(MeetingPair o1, MeetingPair o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.finish, o2.finish);
			}

		});
		int count = 0;
		MeetingPair prev = null;
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				count++;
				prev = list.get(i);
			} else {
				MeetingPair curr = list.get(i);
				if (curr.start > prev.finish) {
					count++;
					prev = curr;
				}
			}
		}
		return count;
	}
}

class MeetingPair {
	public int start;
	public int finish;
	public int index;

	public MeetingPair(int start, int finish, int index) {
		super();
		this.start = start;
		this.finish = finish;
		this.index = index;
	}

}