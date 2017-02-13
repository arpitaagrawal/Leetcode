package leetCode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class symmetricTree {

	public static boolean isSymmetric(TreeNode root) {
		return isMirrorImage( root);
	}
	
	public static boolean isMirrorImage(TreeNode root){
		
		boolean isMirror = true;
		
		if(root == null){
			return true;
		}
		
		Queue<TreeNode> nodesQueue = new LinkedList<TreeNode>();
		nodesQueue.add(root);
		int level_size = 1;
		
		while(!nodesQueue.isEmpty()){
			List<Integer> sb = new ArrayList<Integer>();
			for(int i=0; i<level_size; i++){
				TreeNode node = nodesQueue.remove();
				if(node.left == null){
					sb.add(-1);
				}else{
					nodesQueue.add(node.left);
					sb.add(node.left.val);
				}
				
				if(node.right == null){
					sb.add(-1);
				}else{
					nodesQueue.add(node.right);
					sb.add(node.right.val);
				}
			}
			level_size = nodesQueue.size();
			if(!isPalindrome(sb)){
				isMirror = false;
				break;
			}
		}
		System.out.println(isMirror);
		return isMirror;
	}

	private static boolean isPalindrome(List<Integer> intArr) {
		boolean isPal = true;
		for(int i=0,j=intArr.size()-1; i<intArr.size()-1; i++, j--){
			if(intArr.get(i) != intArr.get(j)){
				isPal = false;
				break;
			}
		}
		return isPal;
	}
}
