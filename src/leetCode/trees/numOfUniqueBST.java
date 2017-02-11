package leetCode.trees;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author arpita Feb 11, 2014. Question taken from leetcode:
 *         https://leetcode.com/problems/unique-binary-search-trees/?tab=Description
 *
 *         Given n, how many structurally unique BST's (binary search trees)
 *         that store values 1...n?
 * 
 *         For example, Given n = 3, there are a total of 5 unique BST's.
 * 
 *		   1         1     3      3      2 
 *		    \       /     /      / \      \
 *		     3     2     1      1   3      2
 *		    /     /       \                 \
 *		   2     1         2                 3
 *
 *
 **/

public class numOfUniqueBST {

	/**
	 * @param n : number of nodes in tree. if n=3, an array is created with [1,2,3] for which
	 * number of unique trees have to be found. 
	 * @return
	 */
	public int numTrees(int n) {
		int totalCount = 0;
		if (n != 0) {
			int[] dp = new int[n];
			Arrays.fill(dp, -1);
			int[] numArr = IntStream.range(1, n + 1).toArray();
			totalCount = generateUniqueBST(numArr, 0, n - 1, dp);
		}
		return totalCount;
	}

	/**
	 * @param n_arr
	 * @param SI : start index of the array, from where the tree has to be created
	 * @param EI : end index of the array, till where the tree has to be created
	 * @param dp : maintains the count of unique subtrees calculated for given number of nodes.
	 * @return
	 */
	public static int generateUniqueBST(int[] n_arr, int SI, int EI, int[] dp) {
		int totalCount = 0;
		if (SI == EI) {
			dp[0] = 1;
			totalCount = 1;
		} else if (SI > EI) {
			totalCount = 1;
		} else {

			// If the number of unique sub trees for the given number of nodes
			// has already been calculated, then just use that
			// else calculate, by, finding number of subtrees in left and right
			// respectively. Then taking cross product of the two.
			if (dp[EI - SI] < 0) {
				for (int curIndex = SI; curIndex <= EI; curIndex++) {

					int leftSubTressCount = generateUniqueBST(n_arr, SI, curIndex - 1, dp);
					int rightSubTressCount = generateUniqueBST(n_arr, curIndex + 1, EI, dp);
					totalCount += leftSubTressCount * rightSubTressCount;
				}
				dp[EI - SI] = totalCount;
			} else
				totalCount += dp[EI - SI];
		}
		return totalCount;
	}

}
