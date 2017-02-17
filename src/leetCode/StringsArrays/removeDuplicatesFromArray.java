package leetCode.StringsArrays;

/**
 * @author arpita agrawal
 *
 *
 *         Given a sorted array, remove the duplicates in place such that each
 *         element appear only once and return the new length.
 * 
 *         Do not allocate extra space for another array, you must do this in
 *         place with constant memory.
 * 
 *         For example, Given input array nums = [1,1,2],
 * 
 *         Your function should return length = 2, with the first two elements
 *         of nums being 1 and 2 respectively. It doesn't matter what you leave
 *         beyond the new length.
 * 
 *         Subscribe to see which companies asked this question.
 * 
 * 
 *         Question taken from leetcode
 *         :https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class removeDuplicatesFromArray {

	public int removeDuplicates(int[] nums) {

		int curUniqueId = 1;
		for (int i = 1; i < nums.length; i++) {

			// Shift elements to the left only when you find a non repetitive
			// element, else i++
			// curUniqueId maintains the index to which the next unique element
			// can be shifted which increments only when you find the non unique
			// element
			if (nums[i] != nums[i - 1]) {
				nums[curUniqueId++] = nums[i];
			}
		}
		return curUniqueId;
	}

}
