package ArraysStrings;

public class longestPalindromSubstring {


    /**
     * 
     * Given a string s, find the longest palindromic substring 
     * in s. You may assume that the maximum length of s is 1000.
     * @param s, Input: "babad"
     * @return Output: "bab", "aba" is also a valid answer.
     * 
     */
	public static String longestPalindrome(String s) {
        int n = s.length();

        boolean isPal[][] = new boolean[n][n];
        // Initialise length 1 and length 2 palindromes to be 1
        for(int i=0;i<n; i++){
           isPal[i][i] = true;
           if((i+1)<n){
               if(s.charAt(i) == s.charAt(i+1)){
                   isPal[i][i+1] = true;        
               }
           }
        }
        int maxLen = 0;
        int longestBegin =0;
        
        //traverse and check if string i, j is a plaindrome or not
        
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n-len+1; i++) {
              int j = i+len-1;
              if (s.charAt(i) == s.charAt(j) && isPal[i+1][j-1]) {
            	isPal[i][j] = true;
                longestBegin = i;
                maxLen = len;
              }
            }
          }
        
        return s.substring(longestBegin, longestBegin + maxLen);
   }
    
    public static void main(String[] args){
    	String sample = "xyzarpitaatipraskdfh";
    	String longestPalindrome = longestPalindrome(sample);
    	System.out.print(longestPalindrome);
    }


}
