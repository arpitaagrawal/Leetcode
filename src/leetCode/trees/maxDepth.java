package leetCode.trees;

/**
 * @author arpita agrawal
 * 
 *         Given a binary tree, find its maximum depth.
 * 
 *         The maximum depth is the number of nodes along the longest path from
 *         the root node down to the farthest leaf node.
 *
 */
public class maxDepth {
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		else {
			return 1 + Math.max(recursiveMaxDepth(root.left), recursiveMaxDepth(root.right));
		}
	}

	public int recursiveMaxDepth(TreeNode root) {
		if (root == null)
			return 0;
		else {
			return 1 + Math.max(recursiveMaxDepth(root.left), recursiveMaxDepth(root.right));
		}
	}

}
