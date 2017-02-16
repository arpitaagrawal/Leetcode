package ArraysStrings;

public class longestSubstring {
	
	    public String longestPalindrome(String s) {
	        String substring = " ";
	        boolean[][] string_arr = new boolean[s.length()][s.length()];
	        initialize_arr(string_arr);
	        
	        //Set length 1 palindromes to be true
	        for(int i=0; i<string_arr.length; i++){
	        	string_arr[i][i] = true;
	        }
	        
	       //Set length 2 palindromes to be true
	        for(int i=0; i<string_arr.length-1; i++){
	        	if(s.charAt(i) == s.charAt(i+1)){
	        		string_arr[i][i+1] = true;
	        	}
	        }
	        
	        // Think of how u want to do this
	        
	        for(int i=2; i<s.length()-3; i++){
//	        	for(j=0; j<)
	        	
	        }
	    	return substring;
	    }
	    
	    private boolean[][] initialize_arr(boolean[][] string_arr){
	    	for(int i=0; i<string_arr.length; i++){
	    		for(int j=0; j<string_arr.length; j++){
	    			string_arr[i][j] = false;
	    		}
	    	}
	    	return string_arr;
	    }
	    
	
}
