/**
 * 
 */
package entities;

/**
 * @author PRATAP
 *
 */
public class Job {

	public int id;
	public int deadline;
	public int profit;

	public Job(int id, int deadline, int profit) {
		super();
		this.id = id;
		this.profit = profit;
		this.deadline = deadline;
	}

}
