/**
 * 
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class AskABC {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException, ParseException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		HashMap<String, ArrayList<Data>> map = new HashMap<String, ArrayList<Data>>();
		for (int i = 0; i < m; i++) {
			String[] input = br.readLine().split(",");
			String id = input[0];
			String url = input[1];
			Date startTime = formatter.parse(input[2]);
			Date endTime = formatter.parse(input[3]);
			if (map.getOrDefault(id, null) == null) {
				ArrayList<Data> list = new ArrayList<Data>();
				list.add(new Data(id, url, startTime, endTime));
				map.put(id, list);
			} else {
				map.get(id).add(new Data(id, url, startTime, endTime));
			}
		}
		int n = Integer.parseInt(br.readLine());
		Chat[] chats = new Chat[n];
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(",");
			String id = input[0];
			Date click = formatter.parse(input[1]);
			chats[i] = new Chat(id, click);
		}
		AskABC obj = new AskABC();
		List<Result> res = obj.select(map, chats, n);
		for (Result r : res) {
			System.out.println(r.id + "," + r.intents);
		}
	}

	public String[] intents = { "offers", "rewards", "dispute", "flights", "referral", "payment", "hotels", "statement",
			"change_pin", "transaction" };

	private List<Result> select(HashMap<String, ArrayList<Data>> map, Chat[] chats, int n) {
		int len = intents.length;
		List<Result> res = new ArrayList<Result>();
		for (int i = 0; i < n; i++) {
			int[] duration = new int[len];
			int[] freq = new int[len];
			int[] recent = new int[len];
			ArrayList<Data> datas = map.get(chats[i].id);
			for (Data d : datas) {
				int idx = getIndex(d.url);
				if (idx == -1)
					continue;
				freq[idx] += 1;
				duration[idx] = (int) ((d.end.getTime() - d.start.getTime()) / 1000 % 60);
				recent[idx] = (int) ((d.start.getTime() - chats[i].click.getTime()) / 1000 % 60);
			}
			List<CObj> list = new ArrayList<CObj>();
			for (int j = 0; j < len; j++) {
				if (duration[j] != 0 || freq[j] != 0 || recent[j] != 0) {
					list.add(new CObj(duration[j], freq[j], recent[j], intents[j]));
				}
			}
			Collections.sort(list, new Comparator<CObj>() {

				@Override
				public int compare(CObj o1, CObj o2) {
					int c = Integer.compare(o2.duration, o1.duration);
					if (c == 0) {
						c = Integer.compare(o2.freq, o1.freq);
					}
					if (c == 0) {
						c = Integer.compare(o2.rec, o1.rec);
					}
					return c;
				}
			});
			int k = 1;
			String intentions = "";
			while (k <= 3) {
				intentions += list.get(k - 1).intent + ",";
				k++;
			}
			res.add(new Result(chats[i].id, intentions.substring(0, intentions.length() - 1)));
		}
		return res;
	}

	private int getIndex(String url) {
		// TODO Auto-generated method stub
		for (int i = 0; i < intents.length; i++) {
			if (url.contains(intents[i])) {
				return i;
			}
		}
		return -1;
	}

}

class Result {
	public String id;
	public String intents;

	public Result(String id, String intents) {
		super();
		this.id = id;
		this.intents = intents;
	}

}

class CObj {
	public int duration;
	public int freq;
	public int rec;
	public String intent;

	public CObj(int duration, int freq, int rec, String intent) {
		super();
		this.duration = duration;
		this.freq = freq;
		this.rec = rec;
		this.intent = intent;
	}

}

class Chat {
	public String id;
	public Date click;

	public Chat(String id, Date click) {
		super();
		this.id = id;
		this.click = click;
	}

}

class Data {
	public String id;
	public String url;
	public Date start;
	public Date end;

	public Data(String id, String url, Date start, Date end) {
		super();
		this.id = id;
		this.url = url;
		this.start = start;
		this.end = end;
	}

}
