package ArraysStrings;

import java.util.HashMap;
import java.util.Map;

public class min_char_window {
		
	public static String minWindow(String s, String t) {
			
			String min_window_substring = "";
			Map<Character, Integer> char_count_map = create_char_count_map(t);
			int min_window_length = s.length() + 1;
			for(int i=0; i<s.length(); i++){
				int count_chars = 0;
				Map<Character, Integer> cur_char_index_list_map = new HashMap<Character, Integer>();
				
				int cur_index = i;
				while(cur_index < s.length()){
					Character c = s.charAt(cur_index);
					// Number of times this character has occured till now
					int char_count = 0;
					if(cur_char_index_list_map.get(c) != null){
						char_count = cur_char_index_list_map.get(c);
					}
					// If we actually need this character to be present in our sample string s
					if(char_count_map.get(c) != null){
						++char_count;
						cur_char_index_list_map.put(c, char_count);
						if(char_count <= char_count_map.get(c)){
							++ count_chars;
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
	public static Map<Character, Integer> create_char_count_map(String t){
		Map<Character, Integer> char_index_list_map = new HashMap<Character, Integer>();
		for (int i=0; i<t.length(); i++){
			int char_count = 0;
			if(null != char_index_list_map.get(t.charAt(i))){
				char_count = char_index_list_map.get(t.charAt(i));
			}
			++ char_count; 
			char_index_list_map.put(t.charAt(i), char_count);
		}
		return char_index_list_map;
	}
	
	public static void main(String[] args){
		String s= "ADOBECODEBANCA";
		String t = "ABC";
		minWindow(s,t);
	}
}
