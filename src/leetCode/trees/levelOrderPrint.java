package leetCode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Arpita Agrawal
 *
 *
 *         Given a binary tree, return the level order traversal of its nodes'
 *         values. (i.e. , from left to right, level by level).
 * 
 *         For example: Given binary tree [3,9,20,null,null,15,7]
 * 
 *         [ [3], [9,20], [15,7] ]
 *
 *
 *         Question taken from leetcode:
 *         https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 *
 *         Approach : Take two queues : one for keeping the nodes in current
 *         level Second Queue: to add the children of the nodes being visited in
 *         the current level As you process each node in current level, keep add
 *         their children to Q2 and add the current node val to list. Once the
 *         current node list is empty, start dequeing the child node list, in
 *         fifo order repeat the process.
 * 
 */
public class levelOrderPrint {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
		if(root == null){
			return levelOrderList;
		}

		Queue<TreeNode> currentNodeQueues = new LinkedList<TreeNode>();
		Queue<TreeNode> childNodeQueues = new LinkedList<TreeNode>();
		List<Integer> curLevelList = new ArrayList<Integer>();

		currentNodeQueues.add(root);
		while (!currentNodeQueues.isEmpty()) {
			TreeNode curNode = currentNodeQueues.remove();
			curLevelList.add(curNode.val);
			if (null != curNode.left) {
				childNodeQueues.add(curNode.left);
			}
			if (null != curNode.right) {
				childNodeQueues.add(curNode.right);
			}
			if (currentNodeQueues.isEmpty()) {
				levelOrderList.add(curLevelList);
				curLevelList = new ArrayList<Integer>();
				currentNodeQueues.addAll(childNodeQueues);
				childNodeQueues.clear();
			}
		}
		return levelOrderList;
	}

}
