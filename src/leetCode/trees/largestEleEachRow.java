package leetCode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author arpita
 *
 *You need to find the largest value in each row of a binary tree.

	Example:
	Input: 
	
	          1
	         / \
	        3   2
	       / \   \  
	      5   3   9 
	
	Output: [1, 3, 9]
 *
 * Question taken from : https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 * Feb 13'2017
 */
public class largestEleEachRow {

	public int[] findValueMostElement(TreeNode root) {

		List<Integer> maxEleLevelWise = new ArrayList<Integer>();
		int[] maxEleArr = new int[1];
		if (root == null) {
			return maxEleArr;
		}

		Queue<TreeNode> nodeQueues = new LinkedList<TreeNode>();
		int max = Integer.MIN_VALUE;

		nodeQueues.add(root);
		int curLevelSize = 0;

		while (!nodeQueues.isEmpty()) {

			for (int i = 0; i < curLevelSize; i++) {
				TreeNode curNode = nodeQueues.remove();
				if (curNode.val > max) {
					max = curNode.val;
				}
				if (null != curNode.left)
					nodeQueues.add(curNode.left);
				if (null != curNode.right)
					nodeQueues.add(curNode.right);
			}
		}
		TreeNode node = nodeQueues.peek();
		maxEleLevelWise.add(max);
		max = Integer.MIN_VALUE;
		if (!nodeQueues.isEmpty()) {
			curLevelSize = nodeQueues.size();
		}
		return maxEleLevelWise.stream().mapToInt(Integer::intValue).toArray();
	}
}
