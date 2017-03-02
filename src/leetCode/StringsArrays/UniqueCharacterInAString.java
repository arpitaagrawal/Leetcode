package leetCode.StringsArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;



public class UniqueCharacterInAString {

	/**
	 * @param words
	 * @param more
	 * @return merged list of words
	 * 
	 *  ["hello", "how are you?", "I am good!"], ["one","two","three"]
	 *  
	 *  This method basically helps you to increase the size of your list by concatenating 
	 *  the two list provided in the arguments and returning a complete list of strings
	 *  
	 */
	public static ArrayList<String> mergeList(ArrayList<String> words, ArrayList<String> more){
		ArrayList<String> updated_List_of_words = new ArrayList<String>();
		updated_List_of_words.addAll(words);
		updated_List_of_words.addAll(more);
		return updated_List_of_words;
	}
	
	public enum string_unique_check{ ASCII, HASHMAP, SORT, BRUTE_FORCE }
	
	/**
	 * @param sample
	 * @param method
	 * @return
	 * @throws InvalidArgumentException
	 * 
	 * Retunrs whether a string has unique characters or not, based on the method specified in the argument.
	 * If sample string passed is empty or is null, false is returned 
	 */
	public static boolean hasUniqueChar(String sample, string_unique_check method ) throws InvalidArgumentException {
		
		if(null == sample || sample.isEmpty()){
			return false;
		}
		if(method == string_unique_check.ASCII){
			return hasUniqueChar_ascii(sample);
		}else if(method == string_unique_check.HASHMAP){
//			Method 2: Create a hashMap of character vs count, if count goes greater than 1, characters are duplicated
			return hasUniqueChar_hashMap(sample);
		}else if(method == string_unique_check.SORT){
//			Method 3: If no additional space can be added, sort the characters and then traverse once to see if any character is repeated			
			return hasUniqueChar_sort(sample);
		}else if(method == string_unique_check.BRUTE_FORCE){
//	 		Method 4: Brute Force, Compare each character with every other character O(n^2)		
			return hasUniqueChar_bruteForce(sample);
		}else{
			throw new InvalidArgumentException("method");
		}
	}
	
	
	
	/**
	 * @param sample String
	 * @return boolean, specifying whether the string had unique characters or not
	 * 
	 * Method 1: Convert all the characters into ascii values, create a new array and keep a count of 
	 * number of characters of a particular ascii value where index is the ASCII number
	 */
	public static boolean hasUniqueChar_ascii(String sample){
		int[] ascii_arr = new int[130];
		for(int i=0; i<sample.length(); i++){
			int c_ascii = (int)sample.charAt(i);
			ascii_arr[c_ascii] =  ascii_arr[c_ascii] + 1;
			if(ascii_arr[c_ascii] > 1){
				System.out.println("Duplicate characters found!");
				return false;
			}
		}
		System.out.print("No duplicates found!");
		return true;
	}
	
	/**
	 * @param sample_str
	 * @return boolean, specifying whether the string had unique characters or not
	 * 
	 * Cases: If empty string is passed.
	 * 2) If length one string is passed
	 * 
	 * Checks if a string has unique characters, by making a hashmap, 
	 * where keys are the characters and the values are the count of each character in the string
	 */
	public static boolean hasUniqueChar_hashMap(String sample_str){
		HashMap<Character, Integer> char_map = new HashMap<Character, Integer>();
		
		for(int i=0; i<sample_str.length(); i++){
			int val = (char_map.get(sample_str.charAt(i)) == null? 1 : (char_map.get(sample_str.charAt(i)) + 1));
			char_map.put(Character.valueOf(sample_str.charAt(i)), val);
			
			if(char_map.get(sample_str.charAt(i)) > 1){
				// If length becomes > 1, characters are getting repeated.
				return false;
			}
		}
		// If none of the characters are repeated return true
		return true;
	}
	
	/**
	 * @param sample
	 * @return boolean, specifying whether the string had unique characters or not
	 * 
	 */
	public static boolean hasUniqueChar_sort(String sample){
		char[] char_array = sample.toCharArray();
		Arrays.sort(char_array);
		
		if(sample.length() == 1){
			return true;
		}
		
		for(int i=1; i<char_array.length; i++){
			if(char_array[i] == char_array[i-1]){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @param sample
	 * @return boolean, specifying whether the string had unique characters or not
	 * 
	 */
	public static boolean hasUniqueChar_bruteForce(String sample){
			for(int i=0; i<sample.length()-1; i++){
				for(int j=i+1; j<sample.length(); j++){
					if(sample.charAt(i) == sample.charAt(j)){
						return false;
					}
				}
			}
			return true;
	}
	
	public static String removeDuplicates(String str){
		return "";
	}
	
	
}
