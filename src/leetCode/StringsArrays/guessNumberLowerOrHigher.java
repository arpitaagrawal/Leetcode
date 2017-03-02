package leetCode.StringsArrays;

/**
 * @author Arpita Agrawal
 *
 *         We are playing the Guess Game. The game is as follows:
 * 
 *         I pick a number from 1 to n. You have to guess which number I picked.
 * 
 *         Every time you guess wrong, I'll tell you whether the number is
 *         higher or lower.
 * 
 *         You call a pre-defined API guess(int num) which returns 3 possible
 *         results (-1, 1, or 0):
 * 
 *         -1 : My number is lower 1 : My number is higher 0 : Congrats! You got
 *         it!
 * 
 *         Example: n = 10, I pick 6.
 * 
 *         Return 6.
 *         
 *         Question taken from leetcode: https://leetcode.com/problems/guess-number-higher-or-lower/?tab=Description
 *
 */


public class guessNumberLowerOrHigher {

	static int trueNum = 1;
	public static int guessNumber(int n) {

		boolean isfound = false;
		int startIndex = 1;
		int endIndex = n+1;
		int mid = 0;
		while(!isfound){
			mid = startIndex + ((endIndex - startIndex)/2);
			if(guess(mid) == 0)	isfound = true;
			if(guess(mid) < 0)	endIndex = mid; 
			if(guess(mid) > 0) startIndex= mid;
		}
		return mid;
	}
	
	public static int guess(int num){
		
		if(num == trueNum){
			return 0;
		}else if(num> trueNum){
			return 1;
		}else{
			return -1;
		}
	}
	
	public static void main(String[] args){
		
		System.out.println(guessNumber(2));
	}
}
