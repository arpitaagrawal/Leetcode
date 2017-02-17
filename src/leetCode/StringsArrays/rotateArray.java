package leetCode.StringsArrays;

/**
 * @author arpita
 *
 *
 *         Rotate an array of n elements to the right by k steps.
 * 
 *         For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is
 *         rotated to [5,6,7,1,2,3,4].
 * 
 *         Question taken from leetcode:
 *         https://leetcode.com/problems/rotate-array/
 */
public class rotateArray {

	public void rotate(int[] nums, int k) {

		int arrLength = nums.length;
		while (k > arrLength)
			k = k - arrLength;

		if ((k == nums.length) || k < 1 || nums == null || (nums.length == 1))
			return;

		int lastIndex = nums.length - 1;
		int startIndex = k - 1;
		while (startIndex >= 0) {
			int temp = nums[startIndex];
			nums[startIndex] = nums[lastIndex];
			nums[lastIndex] = temp;
			lastIndex--;
			startIndex--;
		}
	}

}
