package leetCode.StringsArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author arpita
 *
 *
 *         Given an array of integers with possible duplicates, randomly output
 *         the index of a given target number. You can assume that the given
 *         target number must exist in the array.
 * 
 *         Note: The array size can be very large. Solution that uses too much
 *         extra space will not pass the judge.
 *         
 *         Question taken from : https://leetcode.com/problems/random-pick-index/
 */
public class RandomPickIndex {

	Map<Integer, List<Integer>> num_index_map = new HashMap<Integer, List<Integer>>();

	public RandomPickIndex(int[] nums) {

		for (int index = 0; index < nums.length; index++) {
			List<Integer> indicesList = num_index_map.get(nums[index]);
			if (indicesList == null) {
				indicesList = new ArrayList<Integer>();
			}
			indicesList.add(index);
			num_index_map.put(nums[index], indicesList);
		}
	}

	// for each index to have equal probability, i have to know the indices of
	// all the occurances of target integer
	// i will have to maintain the indices somewhere, where the target was found
	// and randomly pick one
	// i might take up a lot of storage if each element is a duplicate - worse
	// case( N space, O(n) iteration)

	// or else, i should search for the element in a random order. is that
	// possible?
	// how will i track what all indices have we seen then? i might keep coming
	// back to the same set of indices again and again. I need a way to keep a
	// track of visited indices, that will again require O(n) space
	public int pick(int target) {

		// Assumption this element is defenitely present in the array
		List<Integer> indicesList = num_index_map.get(target);
		Random random = new Random();
		int randomIndex = random.nextInt(indicesList.size());
		return indicesList.get(randomIndex);

	}

}
