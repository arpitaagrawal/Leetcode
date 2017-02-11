package leetCode.trees;


/**
 * @author Arpita Agrawal
 *
 *Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.

 *
 *Question taken from leetcode: https://leetcode.com/problems/validate-binary-search-tree/
 *Feb 11 2017
 */
public class validBinarySearchTree {

	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	
	public static boolean isValidBST(TreeNode root) {

		boolean isValid = false;
		isValid = isValidBSTRec(root, Long.MAX_VALUE, Long.MIN_VALUE);
		return isValid;

	}

	public static boolean isValidBSTRec(TreeNode root, long maxVal, long minVal) {
		
		if(root == null)
			return true;
		else{
			if(root.val >= maxVal || root.val <= minVal)
				return false;
			return isValidBSTRec(root.left, root.val, minVal) && isValidBSTRec(root.right, maxVal, root.val);
		}
	}

}
