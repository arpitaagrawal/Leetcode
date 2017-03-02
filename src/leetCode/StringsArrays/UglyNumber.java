package leetCode.StringsArrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author arpita
 *
 *
 *         Write a program to check whether a given number is an ugly number.
 * 
 *         Ugly numbers are positive numbers whose prime factors only include 2,
 *         3, 5. For example, 6, 8 are ugly while 14 is not ugly since it
 *         includes another prime factor 7.
 * 
 *         Note that 1 is typically treated as an ugly number.
 * 
 *         x--> Number: is ugly if it has prime factors : 2,3,5 as the only
 *         prime factors find factors of that number: specifically prime factors
 *         only check if there is any other number apart from 2,3,5
 * 
 */
public class UglyNumber {

	// Possible SOlution

	// if number = 0/1 return true --> check for zero
	// start with i=2,
	// keep dividing by 2 till the modulo > 0
	// increment the next number : 3
	// keep dividing till the modulo is >0
	// no need to divide by 4: because its not a prime number
	// else, i can just try dividing if my modulo comes grater than 0 that means
	// we cant divide
	// composite number cant be there because o have already divide n by all the
	// prime numbers less that cur number by max possible iterations

	public static boolean isUgly(int num) {

		boolean isUgly = true;
		Set<Integer> primeNumberSets = new HashSet<Integer>();
		int curNum = 2;
		
		if(num <= 0)	return false;
		while(num != 1){
			//keep dividing
			if(num % curNum == 0){
				num = num/curNum;
				primeNumberSets.add(curNum);
			}else	curNum++;
		}
		
		primeNumberSets = removeUglyPrimeNumbers(primeNumberSets);
		if(primeNumberSets.size() > 0){
			isUgly = false;
		}
		
		return isUgly;
	}

	public static Set<Integer> removeUglyPrimeNumbers(Set<Integer> primeNumberSets){
		primeNumberSets.remove(2);
		primeNumberSets.remove(3);
		primeNumberSets.remove(5);
		return primeNumberSets;
	}
	
	public static void main(String[] args){
		System.out.println(isUgly(905391974));
	}
}
