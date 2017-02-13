package leetCode.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author arpita
 *
 *
 *
 *Given a binary tree, find the leftmost value in the last row of the tree.

		Example 1:
		Input:
		
		    2
		   / \
		  1   3
		
		Output:
		1
		Example 2: 
		Input:
		
		        1
		       / \
		      2   3
		     /   / \
		    4   5   6
		       /
		      7
		
		Output:
		7
		Note: You may assume the tree (i.e., the given root node) is not NULL.


 *
 * Question taken from leetcode : https://leetcode.com/problems/find-bottom-left-tree-value/?tab=Description
 * * Feb 13'2017
 */
public class leftmostElement {
	public int findLeftMostNode(TreeNode root) {
        Queue<TreeNode> nodesQueue = new LinkedList<TreeNode>();
        nodesQueue.add(root);
        int levelSize = 1;
        int bottomLeftValue = root.val;
        while(!nodesQueue.isEmpty()){
            for(int i=0; i<levelSize; i++){
                TreeNode node = nodesQueue.remove();
                if(node.left != null) nodesQueue.add(node.left);
                if(node.right != null) nodesQueue.add(node.right);
            }
            
            if(!nodesQueue.isEmpty()){
                levelSize = nodesQueue.size();
                bottomLeftValue = nodesQueue.peek().val;
            }
        }
        return bottomLeftValue;
    }
}
