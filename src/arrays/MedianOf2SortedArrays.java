/**
 * 
 */
package arrays;

/**
 * @author PRATAP
 *
 */
public class MedianOf2SortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 2, 4 };
		int[] nums2 = { 1, 3 };
		double median = findMedianSortedArrays(nums1, nums2);
		System.out.println("Median = " + median);
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return findMedianSortedArrays(nums2, nums1);
		}
		int low = 0;
		int high = nums1.length;
		int n1 = nums1.length;
		int n2 = nums2.length;
		double median = 0;
		while (low <= high) {
			int cut1 = low + (high - low) / 2;
			int cut2 = (n1 + n2 + 1) / 2 - cut1;

			int n1L = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
			int n1R = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
			int n2L = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
			int n2R = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

			if (n1L > n2R) {
				high = cut1 - 1;
			} else if (n2L > n1R) {
				low = cut1 + 1;
			} else {
				median = (n1 + n2) % 2 == 0 ? (Math.max(n1L, n2L) + Math.min(n1R, n2R)) / 2.0 : Math.max(n1L, n2L);
				return median;
			}
		}
		return median;
	}

}
