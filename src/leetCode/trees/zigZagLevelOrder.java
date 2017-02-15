package leetCode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author arpita
 *
 *	Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 *	(ie, from left to right, then right to left for the next level and alternate between).

	For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]

 *
 *
 *	Question taken from leetcode : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class zigZagLevelOrder {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> zigZagOrderList = new ArrayList<List<Integer>>();
		if (root == null) {
			return zigZagOrderList;
		}

		Stack<TreeNode> currentNodeStack = new Stack<TreeNode>();
		Stack<TreeNode> childNodeStack = new Stack<TreeNode>();
		List<Integer> curLevelList = new ArrayList<Integer>();
		boolean leftToRight = true;
		currentNodeStack.push(root);
		while (!currentNodeStack.isEmpty()) {
			TreeNode curNode = currentNodeStack.pop();
			curLevelList.add(curNode.val);
			if (leftToRight) {
				if (curNode.left != null)
					childNodeStack.add(curNode.left);
				if (curNode.right != null)
					childNodeStack.add(curNode.right);
			} else {
				if (curNode.right != null)
					childNodeStack.add(curNode.right);
				if (curNode.left != null)
					childNodeStack.add(curNode.left);
			}
			if (currentNodeStack.isEmpty()) {
				zigZagOrderList.add(curLevelList);
				curLevelList = new ArrayList<Integer>();
				currentNodeStack.addAll(childNodeStack);
				childNodeStack.clear();
				if (leftToRight)
					leftToRight = false;
				else
					leftToRight = true;
			}
		}

		return zigZagOrderList;
	}
}
