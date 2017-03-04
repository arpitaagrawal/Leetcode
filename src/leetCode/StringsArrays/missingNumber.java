package leetCode.StringsArrays;

/**
 * @author arpita
 *
 *
 *         Given an array containing n distinct numbers taken from 0, 1, 2, ...,
 *         n, find the one that is missing from the array.
 * 
 *         For example, Given nums = [0, 1, 3] return 2.
 * 
 *         Note: Your algorithm should run in linear runtime complexity. Could
 *         you implement it using only constant extra space complexity?
 * 
 *         // if nums[i] = 2, just put nums[2] = -nums[2], i.e replacing 2 with
 *         nums[i] --> nums[nums[i]] = -nums[nums[i]] // if nums[i] > length -1
 *         , then ignore
 * 
 * 
 */
public class missingNumber {

	public static int missingNum(int[] nums) {
		int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}
		return xor ^ i;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1 };
		System.out.println(missingNum(nums));
	}
}
