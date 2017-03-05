package leetCode.StringsArrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arpita
 *
 *
 *         Given a column title as appear in an Excel sheet, return its
 *         corresponding column number.
 * 
 *         For example:
 * 
 *         A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 * 
 */
public class excelColNumber {

	public static int titleToNumber(String s) {

		// find the length of the string
		// add all possible lengths
		// for len 4 ---> len-1=3 --> 26cube + 26square + 26 --> gp sum?
		// 26(1-pow(r,n))/(1-26)
		// AAB --> 2 combination of 3 letter words
		// ABA --> since its B --> 26* 1 + 1
		// BBA --> since it B in frst place as well --> (26)(26)*1 + 26*1 + pow(26,0)*1
		// CBA --> since it c in frst place as well --> (26)(26)*2 + 26*1 + 1
		// CDA --> since it c in frst place as well --> (26)(26)*2 + 26*3 + 1
		// CDY --> since it c in frst place as well --> (26)(26)*2 + 26*3 + 25
		
		
		// BAsed on the length : start from 0 the index multiply pow(26, len-i) * (count-1)
		
		int length = s.length();
		int indexOfCurLenString = 0;
		for(int i=0; i<length; i++){
			indexOfCurLenString +=Math.pow(26, length-i-1) * (s.charAt(i)-65);
		}
		indexOfCurLenString += 1;
		
		int n= length -1;
		if(n >0){
			int allPossibleLengthCombos = calculateGP(26,26, n);
			indexOfCurLenString += allPossibleLengthCombos;
		}
		return indexOfCurLenString;
	}
	
	public static void main(String[] args){
		 titleToNumber("CFDGSXM");
		 //calculateGP(26,26,6);
	}
	
	public static int calculateGP(int ft, int cr, int n){

		int sum =0;
		int curNum=1;
		for(int i=0; i<n; i++){
			curNum *= 26;
			sum += curNum;
		}
		System.out.println(sum);
		return sum;
	}
}
