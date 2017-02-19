package leetCode.StringsArrays;

public class duplicatesInArray {

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		for (int gap = 1; gap <= k; gap++) {
			for (int index = 0; index <= nums.length - 1 - gap; index++) {
				long diff1 = Math.abs(Long.valueOf(nums[index]) - Long.valueOf(nums[index+gap]));;
				if (diff1 <= t) {
					return true;
				}
			}
		}

		return false;
	}
	
	public static void main(String[] args){
		int[] arr= new int[]{1,3,1};
		System.out.println(containsNearbyAlmostDuplicate(arr, 2,1));
	}
}
