package leetCode.StringsArrays;

/**
 * @author arpita
 *
 *         Implement next permutation, which rearranges numbers into the
 *         lexicographically next greater permutation of numbers.
 * 
 *         If such arrangement is not possible, it must rearrange it as the
 *         lowest possible order (ie, sorted in ascending order).
 * 
 *         The replacement must be in-place, do not allocate extra memory.
 * 
 *         Here are some examples. Inputs are in the left-hand column and its
 *         corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2
 *         3,2,1 → 1,2,3 1,1,5 → 1,5,1
 *
 *	Question taken from leetcode: https://leetcode.com/problems/next-permutation/?tab=Description
 * 	
 */
public class nextPermutation {

	public void nextPermut(int[] nums) {
		if (nums == null || nums.length < 2)
			return;

		int arrLen = nums.length;
		// Find the location of swap
		int swapIndex = -1;
		for (int curInd = arrLen - 2; curInd >= 0; curInd--) {
			if (nums[curInd] < nums[curInd + 1]) {
				swapIndex = curInd;
				break;
			}
		}

		// If a swap index exist, then swap and reverse the second half of the
		// list of integers
		// else, reverse the entire list of descending integers
		if (swapIndex > -1) {
			int minIndex = -1;
			for (int curInd = arrLen - 1; curInd > swapIndex; curInd--) {
				if (nums[curInd] > nums[swapIndex]) {
					minIndex = curInd;
					break;
				}
			}
			nums = swap(nums, swapIndex, minIndex);
			nums = reverse(nums, swapIndex + 1, arrLen);
		} else
			nums = reverse(nums, 0, arrLen);

	}

	public int[] reverse(int[] nums, int SI, int EI) {
		int mid = (EI - SI) / 2;
		for (int ind = 0; ind < mid; ind++) {
			swap(nums, SI + ind, EI - ind - 1);
		}
		return nums;
	}

	public int[] swap(int[] nums, int ind1, int ind2) {

		int temp = nums[ind1];
		nums[ind1] = nums[ind2];
		nums[ind2] = temp;
		return nums;
	}

}
