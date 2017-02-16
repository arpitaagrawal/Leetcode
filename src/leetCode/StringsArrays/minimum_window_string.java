package ArraysStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class minimum_window_string {

	public static String minWindow(String s, String t) {
		
		String min_window_substring = "";
		Map<Character, ArrayList<Integer>> char_index_list_map = create_index_char_map(t);
		int min_window_length = s.length() + 1;
		for(int i=0; i<s.length(); i++){
			int count_chars = 0;
			
			int[] current_substring_char_state = new int[t.length()];
			int cur_index = i;
			while(cur_index < s.length()){
				Character c = s.charAt(cur_index);
				ArrayList<Integer> array_list_int = char_index_list_map.get(c);
				if(null != array_list_int){
					for(int ind: array_list_int){
						// Put one of the indices to 1- for multiple a's put one as 1, and let rest remain 0
						// Keep on adding ones to all a's as find more in the string
						if(current_substring_char_state[ind] != 1){
							current_substring_char_state[ind] = 1;
							++ count_chars;
							
							break;
						}
					}
				}
				
				cur_index ++ ;
				if(count_chars == t.length()){
					if((cur_index - i) < min_window_length){
						min_window_substring = s.substring(i, cur_index);
						min_window_length = min_window_substring.length();
					}
					break;
				}
			}
		}
		System.out.println("min_window_substring :::" +min_window_substring);
		return min_window_substring;
		
	}
	
	/**
	 * @param t = "ABC", any string for which you want to create a map of
	 * @return map of <character, list of indices where it occurs> = {A=[0], B=[1], C=[2]} 
	 */
	public static Map<Character, ArrayList<Integer>> create_index_char_map(String t){
		Map<Character, ArrayList<Integer>> char_index_list_map = new HashMap<Character, ArrayList<Integer>>();
		for (int i=0; i<t.length(); i++){
			ArrayList<Integer> index_list = char_index_list_map.get(t.charAt(i));
			if(null == index_list){
				index_list = new ArrayList<Integer>();
			}
			index_list.add(i);
			char_index_list_map.put(t.charAt(i), index_list);
		}
		return char_index_list_map;
	}
	
	public static void main(String[] args){
		String s= "ADOBECODEBANCA";
		String t = "ABC";
		minWindow(s,t);
	}
}
