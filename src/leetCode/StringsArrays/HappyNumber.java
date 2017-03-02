package leetCode.StringsArrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author arpita Write an algorithm to determine if a number is "happy".
 * 
 *         A happy number is a number defined by the following process: Starting
 *         with any positive integer, replace the number by the sum of the
 *         squares of its digits, and repeat the process until the number equals
 *         1 (where it will stay), or it loops endlessly in a cycle which does
 *         not include 1. Those numbers for which this process ends in 1 are
 *         happy numbers.
 * 
 *         Example: 19 is a happy number
 * 			replace 2s in the second digit with square
 *         12 + 92 = 82
		   82 + 22 = 68
		   62 + 82 = 100
		   12 + 02 + 02 = 1

 *
 *		
 */
public class HappyNumber {

	/**
	 * @param n
	 * @return
	 * 
	 * possible algorithm
	 * int can have max 10 digits in a number
	 * max number of possible permutations : 10 pow 10
	 * 
	 * 
	 */
	public static boolean isHappy(int n) {

		Set<Integer> uniqueNumbersSet = new HashSet<Integer>();
		while(n!=1 && (!uniqueNumbersSet.contains(n)) ){
			uniqueNumbersSet.add(n);
			int sum =0;
			while(n != 0){
				sum  += Math.pow((n%10),2);
				n /= 10;
			}
			n = sum;
		}
		if(n == 1)	return true;
		else return false;
	}
	
	public static void main(String[] args){
		System.out.println(isHappy(101));
	}
}
