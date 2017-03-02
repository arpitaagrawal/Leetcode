package ArraysStrings;
import java.util.ArrayList;

import Excpetions.InvalidArgumentException;

public class ArraysAndStrings  {

	public static void main(String args[]){
		ArrayList<String> new_l = create_sample_stringList("heelo", "how are you?", "I am good!");
		ArrayList<String> new_l2 = create_sample_stringList("one", "two", "three");
		
		
		// Check if a string has unique characters
		try{
			boolean isUnique = UniqueCharacterInAString.hasUniqueChar("Strinng", UniqueCharacterInAString.string_unique_check.BRUTE_FORCE);
			if(isUnique){
				System.out.println("Unique Characters in string");
			}else{
				System.out.println("Characters in string are not unique");
			}
				
		}catch(InvalidArgumentException exception){
			System.out.println("Invalid Argument value passed for"+ exception);
		}
		
		String str= reverseStringWithNUll(" ");
		if(null == str){
			System.out.println("Null String");
		}else
			System.out.print(str);
		
	}
	
	
	/**
	 * @param str
	 * @return
	 * Cases: If null, returns NULL
	 * If empty, returns empty
	 * If length >1, just reverse the string.
	 * C style string: has a null character in it. If length 5 string, has one null character in it, and the rest 4 characters. Ignore the null chracter
	 * 
	 * Methods,1) use, a new string and keep adding a character to it traversing from the back, with the help of StrinBuilder
	 * 2) If we use same string, In efficient, because with each swap that we make, a new string will be created underneath.
	 * 
	 */
	public static String reverseStringWithNUll(String str){
		
		if(null == str || str.isEmpty()){
			return str;
		}
		int lenth = str.length();
		StringBuilder sb = new StringBuilder();
		for(int i= (lenth-2); i>=0; i--){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	/**
	 * @param strings
	 * @return a list of strings passed in the argument
	 * 
	 * An empty list is passed if no string is passed as argument
	 */
	private static ArrayList<String> create_sample_stringList(String... strings){

		ArrayList<String> str_list = new ArrayList<String>();
		ArrayList<String> str_list2 = new ArrayList<String>();
		if(str_list.equals(str_list2))
		for (String str: strings){
			str_list.add(str);
		}
		return str_list;
	}
	
}
