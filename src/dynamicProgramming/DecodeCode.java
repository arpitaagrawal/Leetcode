package dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arpita Agrawal
 *
 *         A message containing letters from A-Z is being encoded to numbers
 *         using the following mapping:
 * 
 *         'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing
 *         digits, determine the total number of ways to decode it.
 * 
 *         For example, Given encoded message "12", it could be decoded as "AB"
 *         (1 2) or "L" (12).
 * 
 *         The number of ways decoding "12" is 2.
 *
 * 
 * 
 */
public class DecodeCode {

	/**
	 * @param s
	 * @return
	 * 
	 * 		Base Case: If end of list, return possible ways = 1 Case 2: If no
	 *         element left return 1; Case 3: Just check if current element
	 *         alone + next group possible Check if (i,i+1) together form a
	 *         valid element, and multiply it with number of ways [i+2, N]
	 */

	static int numDecodings(String s) {
		
		if(s.isEmpty()){
			return 0;
		}
		int[] dp = new int[s.length()];
		Arrays.fill(dp, -1);
		return recursiveNumDecoding(s, 0, dp);
	}

	/**
	 * @param s
	 * @param index
	 * @return
	 * 
	 * length: 7
	 * 
	 * number:	1	2	2	1	2	1	8
	 * index :  0	1	2	3	4	5	6
	 * 
	 */


    
    
    public int numDecodingsApproach2(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        
        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else {
                memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1]; 
                System.out.println(memo[i]);
            }
        
        return memo[0];
    }


	static // base case if end of list, return 1, else if empty return 0
	//

	// dp is the array which maintains the number of decoding possible from
	// index i and onwards.
	int recursiveNumDecoding(String s, int index, int[] dp) {

		if (index > s.length() - 1)
			return 1;
		else if (index == s.length() - 1) {
			int oneDigitCode = Integer.parseInt(s.substring(index, index + 1));
			if (oneDigitCode > 0) {
				dp[index] = 1;
				return dp[index];
			} else
				return 0;
		} else {

			int oneDigitCode = Integer.parseInt(s.substring(index, index + 1));
			// Possible ways = Case 1: this number will appear alone
			/// Case 2: This number will appear in combonation with the second
			// number.
			int posssibleWays = 0;

			if (oneDigitCode > 0) {
				if (dp[index + 1] != -1) {
					posssibleWays += dp[index + 1];
				} else
					posssibleWays += recursiveNumDecoding(s, index + 1, dp);
			}
			if (index < (s.length() - 1)) {
				int twoDigitCode = Integer.parseInt(s.substring(index, index + 2));
				if (twoDigitCode < 27 && twoDigitCode > 0) {
					/// if value availalble in DP array use that else call the
					/// recursive function for that index;
					if (index + 2 < s.length()) {
						if (dp[index + 2] != -1) {
							posssibleWays += 1 * dp[index + 2];
						} else
							posssibleWays += 1 * recursiveNumDecoding(s, index + 2, dp);
					} else
						posssibleWays += 1;
				}
			}

			dp[index] = posssibleWays;
			return dp[index];
		}
	}

	public static void main(String[] args){
		System.out.println(numDecodings(""));
	}
}
