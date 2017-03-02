package leetCode.StringsArrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Arpita Agrawal
 *
 *         test cases: 1) array cannot be empty as per question - as per
 *         assumption 
 *         
 *         2) if less than 3 unique numbers are there just return the
 *         maximum number - first condition 
 *         
 *         3) if more than 3 numbers are there
 *         return third max - second condition 
 *         
 *         4) if duplicate numbers are there
 *         max number should be returned - taken care by the set data structure
 */
public class thirdMax {

	public static int thirdMax(int[] nums) {
		Set<Integer> setOfMinNumbers = new HashSet<Integer>();
		// will always be greater than 0
		int numArrayLen = nums.length;
		int curIndex = 0;

		while (setOfMinNumbers.size() < 3 && curIndex < numArrayLen) {
			setOfMinNumbers.add(nums[curIndex]);
			curIndex++;
		}

		if (setOfMinNumbers.size() < 3) {
			return Collections.max(setOfMinNumbers);
		} else {
			for (int i = curIndex; i < numArrayLen; i++) {
				int min = Collections.min(setOfMinNumbers);
				if (min < nums[i]) {
					setOfMinNumbers.add(nums[i]);
					if(setOfMinNumbers.size() > 3)	setOfMinNumbers.remove(min);
				}
			}
			return Collections.min(setOfMinNumbers);
		}

	}
	
	public static void main(String[] args){
		int[] numsArray = new int[]{1,2,2,5,3,5};
		System.out.print(thirdMax(numsArray));
	}

}
