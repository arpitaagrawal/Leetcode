package leetCode.trees;

/**
 * @author Arpita Agrawal
 *
 *
 *Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

		For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
		
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
		But the following [1,2,2,null,3,null,3] is not:
		    1
		   / \
		  2   2
		   \   \
		   3    3 
 *
 *Question taken from leetcode : https://leetcode.com/problems/symmetric-tree/
 */
public class symmetricTreeRecursive {

	public boolean isSymmetric(TreeNode root) {
		return root == null || isMirrorImage(root.left, root.right);
	}

	private boolean isMirrorImage(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == right;
		}
		if (left.val != right.val)
			return false;

		return isMirrorImage(left.left, right.right) && isMirrorImage(left.right, right.left);

	}

}
