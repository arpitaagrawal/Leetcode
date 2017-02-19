package leetCode.trees;

import java.util.TreeSet;

/**
 * @author arpita
 *
 *
 *         Given an array of integers, find out whether there are two distinct
 *         indices i and j in the array such that the absolute difference
 *         between nums[i] and nums[j] is at most t and the absolute difference
 *         between i and j is at most k.
 * 
 * 
 */
public class treeSet {

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		boolean containDuplicates = false;
		TreeSet<Long> treeSet = new TreeSet<Long>();

		if (nums == null || nums.length < 2 || k <= 0 || t < 0) {
			return false;
		}

		for (int i = 0; i < nums.length; i++) {
			Long ceilNum = treeSet.ceiling(Long.valueOf(nums[i] - t));
			Long floorNum = treeSet.floor(Long.valueOf(nums[i] + t));

			System.out.println(ceilNum);
			System.out.println(floorNum);
			if (((ceilNum != null) && (nums[i] >= ceilNum)) || (floorNum != null) && (nums[i] <= floorNum)) {
				return true;
			}
			treeSet.add(Long.valueOf(nums[i]));
			if(i >= k)
				treeSet.remove(Long.valueOf(nums[i-k]));
		}
		return containDuplicates;
	}

	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[] {-2147483648,-2147483647}, 3, 3));
	}
}
