package leetCode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author arpita
 *	Date : 10th Feb 2017
 *	Increasing brain power by solving trees! :D
 *	
 */
public class inOrderTraversal {

	/**
	 * @param root:
	 *            Given binary tree [1,null,2,3],
	 * @return [1,3,2].
	 * 
	 *         Done using recursive methodology
	 * 
	 */
	public List<Integer> inorderTraversalRecursive(TreeNode root) {

		List<Integer> inorderList = new ArrayList<Integer>();
		inorderList = getInorderTraversalList(root, inorderList);
		return inorderList;
	}

	public List<Integer> getInorderTraversalList(TreeNode root, List<Integer> inorderList) {
		if (root == null) {
			return inorderList;
		}
		inorderList = getInorderTraversalList(root.left, inorderList);
		inorderList.add(root.val);
		inorderList = getInorderTraversalList(root.left, inorderList);
		return inorderList;
	}

	/**
	 * @param root:
	 *            Given binary tree [1,null,2,3],
	 * @return [1,3,2].
	 * 
	 *         Done using iterative methodology
	 * 
	 */
	public List<Integer> inorderTraversalIterative(TreeNode root) {

		List<Integer> inorderList = new ArrayList<Integer>();
		inorderList = getInOrderList(root, inorderList);
		return inorderList;
	}

	public List<Integer> getInOrderList(TreeNode root, List<Integer> inorderList) {
		Stack<TreeNode> inOrderFifo = new Stack<TreeNode>();
		if (root == null) {
			return inorderList;
		} else {
			TreeNode node = root.left;
			inOrderFifo.push(root);
			while (inOrderFifo.size() > 0 || node != null) {
				if (node == null) {
					// If current node is null, we have reached at the end of
					// the branch, pop the first element from queue
					node = inOrderFifo.pop();
					// Print the head node and go to the right
					inorderList.add(node.val);
					// Add the right node to queue, which can then be processed
					// for left nodes as well
					node = node.right;
				} else {
					inOrderFifo.push(node);
					node = node.left;
				}
			}
		}

		return inorderList;
	}

}
