/**
 * 
 */
package sdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public abstract class StandardDeviation {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of students : ");
		int n = Integer.parseInt(br.readLine());
		double[] marks = new double[n];
		System.out.println("Enter the marks : ");
		String[] enteredMarks = br.readLine().trim().split("\\s+");
		for (int i = 0; i < n; i++)
			marks[i] = Double.parseDouble(enteredMarks[i]);
		StandardDeviation sd1 = new MySD();
		System.out.println("My Standard Deviation = " + sd1.findSD(marks));
		StandardDeviation sd2 = new YourSD();
		System.out.println("Your Standard Deviation = " + sd2.findSD(marks));
	}

	public final double findSD(double[] marks) {
		double avg = findAvg(marks);
		double[] diffs = findDiffs(marks, avg);
		double[] sqDiffs = findSqDiffs(diffs);
		double sumSqDiffs = findSumSqDiffs(sqDiffs);
		return Math.sqrt(sumSqDiffs / marks.length);
	}

	protected abstract double findSumSqDiffs(double[] sqDiffs);

	protected abstract double[] findSqDiffs(double[] diffs);

	protected abstract double[] findDiffs(double[] marks, double avg);

	protected abstract double findAvg(double[] marks);
}

class MySD extends StandardDeviation {

	@Override
	protected double findSumSqDiffs(double[] sqDiffs) {
		// TODO Auto-generated method stub
		double sum = 0.0;
		for (double sqDiff : sqDiffs)
			sum += sqDiff;
		return sum;
	}

	@Override
	protected double[] findSqDiffs(double[] diffs) {
		// TODO Auto-generated method stub
		double[] sqDiffs = new double[diffs.length];
		for (int i = 0; i < diffs.length; i++) {
			sqDiffs[i] = Math.pow(diffs[i], 2);
		}
		return sqDiffs;
	}

	@Override
	protected double[] findDiffs(double[] marks, double avg) {
		// TODO Auto-generated method stub
		double[] diffs = new double[marks.length];
		for (int i = 0; i < marks.length; i++) {
			diffs[i] = marks[i] - avg;
		}
		return diffs;
	}

	@Override
	protected double findAvg(double[] marks) {
		// TODO Auto-generated method stub
		double sum = 0.0;
		for (double mark : marks)
			sum += mark;
		return sum / marks.length;
	}

}

class YourSD extends StandardDeviation {

	@Override
	protected double findSumSqDiffs(double[] sqDiffs) {
		// TODO Auto-generated method stub
		double sum = 0;
		for (int i = 0; i < sqDiffs.length; i++) {
			sum += sqDiffs[i];
		}
		return sum;
	}

	@Override
	protected double[] findSqDiffs(double[] diffs) {
		// TODO Auto-generated method stub
		for (int i = 0; i < diffs.length; i++) {
			diffs[i] = diffs[i] * diffs[i];
		}
		return diffs;
	}

	@Override
	protected double[] findDiffs(double[] marks, double avg) {
		// TODO Auto-generated method stub
		int n = marks.length;
		double[] diffs = new double[n];
		for (int i = 0; i < n; i++) {
			double mark = marks[i];
			diffs[i] = mark - avg;
		}
		return diffs;
	}

	@Override
	protected double findAvg(double[] marks) {
		// TODO Auto-generated method stub
		System.out.println("Enter block size : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int blockSize = 0;
		try {
			blockSize = Integer.parseInt(br.readLine());

			int len = marks.length;
			int blocks = len / blockSize;
			List<Double> avgs = new ArrayList<Double>();
			int j = 0;
			for (int i = 0; i < blocks; i++) {
				double sum = 0;
				for (j = i * blockSize; j < i * blockSize + blockSize; j++) {
					sum += marks[j];
				}
				avgs.add(sum / blockSize);
			}
			if (j <= marks.length - 1) {
				double sum = 0;
				int count = marks.length - j;
				while (j < marks.length) {
					sum += marks[j];
					j++;
				}
				avgs.add(sum / count);
			}
			double sum = 0;
			for (double avg : avgs)
				sum += avg;
			return sum / avgs.size();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
	}

}