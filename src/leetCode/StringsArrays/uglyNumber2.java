package leetCode.StringsArrays;

/**
 * @author arpita
 *
 *
 *         Write a program to find the n-th ugly number.
 * 
 *         Ugly numbers are positive numbers whose prime factors only include 2,
 *         3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of
 *         the first 10 ugly numbers.
 * 
 *         Note that 1 is typically treated as an ugly number, and n does not
 *         exceed 1690.
 *         
 *			Approach: start from 1, and keep incrementing till u find n ugly numbers
 *			for each number, divide it by 2 till % !=0 and then divde by 3, 5 in similarr manner
 *			if n > 1 gud
 *			use the old function to check if each number us ugly or not, break when u find top n uglies         
 */

public class uglyNumber2 {
	
	public static int nthUglyNumber(int n) {
		
		int currentNum =2;
		int uglyNumberCount =1;
		
		if(n==1) return 1;
		if(n<=0) return 0;
		
		while(true){
			if(isUgly(currentNum)){
				uglyNumberCount ++;
				if(uglyNumberCount == n)	break;
			}
			currentNum ++;
		}
		return currentNum;
	}
	
	public static boolean isUgly(int currentNum){
		
			int[] primeSet = new int[]{2,3,5};
			if(currentNum <= 0)	return false;
		    if(currentNum == 1)	return true;
			for(int i: primeSet){
				while(currentNum % i == 0)	currentNum /= i;
			}
			if(currentNum == 1)	return true;
			else return false;
	}
}
