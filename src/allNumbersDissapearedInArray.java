import java.util.ArrayList;
import java.util.List;

/**
 * @author Arpita Agrawal
 *
 *         Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 *         some elements appear twice and others appear once.
 * 
 *         Find all the elements of [1, n] inclusive that do not appear in this
 *         array.
 * 
 *         Could you do it without extra space and in O(n) runtime? You may
 *         assume the returned list does not count as extra space.
 * 
 *         Example:
 * 
 *         len = 8 Input: [4,3,2,7,8,2,3,1]
 * 
 *         Output: [5,6]
 *
 *
 *         Question taken from :
 *         https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/?tab=Description
 * 
 */
public class allNumbersDissapearedInArray {

	/**
	 * @param nums
	 * @return
	 * 
	 * 
	 */
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> missingIntegersList = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int curVal = Math.abs(nums[i]);
			// Mark the index with curVal -1*numVal
			if (nums[curVal - 1] > 0)
				nums[curVal - 1] = -1 * nums[curVal - 1];
		}

		for (int i = 0; i < nums.length; i++)
			if (nums[i] > -1)
				missingIntegersList.add(i + 1);
		return missingIntegersList;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 4, 4, 4 };
		System.out.println(findDisappearedNumbers(nums));
	}
}
