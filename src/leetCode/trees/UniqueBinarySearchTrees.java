package leetCode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Arpita Agrawal
 * 
 * Feb 10 2017, Question taken from leetcode: https://leetcode.com/problems/unique-binary-search-trees-ii/
 * 
 *Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.
	
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
 *  
 * 
 */
public class UniqueBinarySearchTrees {
	

	public static List<TreeNode> generateTrees(int n) {

		List<TreeNode> unique_bst_list = new ArrayList<TreeNode>();
		if(n != 0){
			int[] num_arr = IntStream.range(1, n+1).toArray();
			unique_bst_list = generateUniqueBST(num_arr, 0, n-1);
		}
		return unique_bst_list;
	}

	public static List<TreeNode> generateUniqueBST(int[] n_arr, int SI, int EI) {
		
		List<TreeNode> uniqueBstList = new ArrayList<TreeNode>();
		if(SI == EI){
			uniqueBstList.add(createTreeNode(n_arr[SI]));
		}else if(SI> EI){
			uniqueBstList.add(null);
		}else{
			
			for(int curHead=SI; curHead<=EI; curHead++){
				// Create all combinations of left subtrees
				List<TreeNode> leftSubTreesList = generateUniqueBST(n_arr, SI, curHead-1);
				
				// Create all combinations of right subtrees
				List<TreeNode> rightSubTreesList = generateUniqueBST(n_arr, curHead+1, EI);
				
				// Take cross product of left subtrees and right subtrees and make a list of complete trees
				for(TreeNode leftSubTree : leftSubTreesList){
					for(TreeNode rightSubTree : rightSubTreesList){
						TreeNode curHeadNode = createTreeNode(n_arr[curHead]);
						curHeadNode.left = leftSubTree;
						curHeadNode.right = rightSubTree;
						uniqueBstList.add(curHeadNode);
					}
				}
			}
		}
		return uniqueBstList;
	}


	private static TreeNode createTreeNode(int val) {
		TreeNode node = new TreeNode(val);
		node.left = null;
		node.right = null;
		return node;
	}
	
	public static void main(String[] args) {
		TreeNode node = createTreeNode(2);
		System.out.println(node.val);
		generateTrees(3);
	}

}

class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }

}