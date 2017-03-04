package leetCode.StringsArrays;

import java.util.HashMap;
import java.util.Map;

public class singleNumber {

	/**
	 * @param nums
	 * @return
	 * 
	 * 
	 * 		Given an array of integers, every element appears twice except
	 *         for one. Find that single one.
	 * 
	 *         Note: Your algorithm should have a linear runtime complexity.
	 *         Could you implement it without using extra memory?
	 * 
	 * 
	 */
	public static int singleNumberMissing(int[] nums) {
		Integer numFound = null;
		Map<Integer, Integer> numCountMap = new HashMap<Integer, Integer>();
		// Make a map of numbers with their count
		for (int num : nums) {
			int count = numCountMap.get(num) == null ? 1 : 2;
			numCountMap.put(num, count);
		}
		// Traverse through the map, and see if count ==1
		for (Integer key : numCountMap.keySet()) {
			if (numCountMap.get(key) == 1) {
				numFound = key;
				break;
			}
		}
		return numFound;
	}
	
	
	public static int elegantXORSolution(int[] nums){
		int xorFlag =0;
		for(int num: nums){
			xorFlag ^= num;
		}
		return xorFlag;
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{4,2,4,5,2};
		System.out.println(elegantXORSolution(nums));
	}
}
