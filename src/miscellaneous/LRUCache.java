/**
 * 
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author PRATAP LeetCode 146
 *
 */
public class LRUCache {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] commands = br.readLine().split(",");
		LRUCache1 obj = null;
		for (int i = 0; i < commands.length; i++) {
			if (i == 0) {
				obj = new LRUCache1(Integer.parseInt(br.readLine()));
			} else {
				if (commands[i].equalsIgnoreCase("put")) {
					String[] buff = br.readLine().split("\\s+");
					obj.put(Integer.parseInt(buff[0]), Integer.parseInt(buff[1]));
				} else if (commands[i].equalsIgnoreCase("get")) {
					System.out.println(obj.get(Integer.parseInt(br.readLine())));
				}
			}
		}
	}

}

class LRUCache1 {

	HashMap<Integer, DLL> map;
	int size;
	DLL front;
	DLL rear;

	public LRUCache1(int capacity) {
		map = new HashMap<Integer, DLL>();
		size = capacity;
		front = rear = null;
	}

	public int get(int key) {
		int val = -1;
		if (map.containsKey(key)) {
			DLL node = map.get(key);
			if (node == front) {
				val = front.val;
			} else if (node == rear) {
				val = rear.val;
				map.remove(node.key);
				rear.next.prev = null;
				rear = rear.next;
				DLL newNode = new DLL(key, val);
				map.put(key, newNode);
				front.next = newNode;
				newNode.prev = front;
				front = newNode;
			} else {
				val = node.val;
				map.remove(node.key);
				node.prev.next = node.next;
				node.next.prev = node.prev;
				DLL newNode = new DLL(key, val);
				map.put(key, newNode);
				front.next = newNode;
				newNode.prev = front;
				front = newNode;
			}
		}
		return val;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			DLL node = map.get(key);
			if (node.next == null) {
				// front
				node.val = value;
			} else if (node.prev == null) {
				// rear
				node.next.prev = null; // node == rear
				rear = rear.next;
				node = null;
				map.remove(key);
				DLL newNode = new DLL(key, value);
				map.put(key, newNode);
				newNode.prev = front;
				front.next = newNode;
				front = newNode;
			} else {
				// middle
				node.prev.next = node.next;
				node.next.prev = node.prev;
				node = null;
				map.remove(key);
				DLL newNode = new DLL(key, value);
				map.put(key, newNode);
				newNode.prev = front;
				front.next = newNode;
				front = newNode;
			}
		} else {
			if (size <= 0) {
				map.remove(rear.key);
				rear = rear.next;
				if (rear != null)
					rear.prev = null;
				DLL newNode = new DLL(key, value);
				map.put(key, newNode);
				newNode.prev = front;
				front.next = newNode;
				front = newNode;
			} else {
				size--;
				DLL newNode = new DLL(key, value);
				map.put(key, newNode);
				if (front == null) {
					front = rear = newNode;
				} else {
					front.next = newNode;
					newNode.prev = front;
					front = newNode;
				}
			}
		}
	}
}

class DLL {
	public int key;
	public int val;
	public DLL next;
	public DLL prev;

	public DLL(int key, int val) {
		super();
		this.key = key;
		this.val = val;
		this.next = null;
		this.prev = null;
	}

}
