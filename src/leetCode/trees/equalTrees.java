package leetCode.trees;

/**
 * @author arpita
 *
 *
 *         Given two binary trees, write a function to check if they are equal
 *         or not.
 * 
 *         Two binary trees are considered equal if they are structurally
 *         identical and the nodes have the same value.
 *
 *  Question taken from Leetcode: https://leetcode.com/problems/same-tree
 */
public class equalTrees {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		return areNodesEqual(p, q);

	}

	public boolean areNodesEqual(TreeNode p, TreeNode q) {
		if (p == q) {
			return true;
		} else if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		} else {
			return (p.val == q.val) && (areNodesEqual(p.left, q.left) && (areNodesEqual(p.right, q.right)));
		}
	}

}
