package ArraysStrings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class substring_list_of_words {

//	String s: sample string given to us, from which substring indices have to be found
//	String[] words : list of words which have to be matched into our string	
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list_of_indices = new ArrayList<Integer>();
        
        Map<Character, ArrayList<String>> word_char_map = create_word_map(words);
        int length_of_words = words[0].length();
        
        // equal length words : lets say size 4, multiplied by the number of words in words list
        int total_length_substring = (words.length)*(length_of_words);
        Map<Character, ArrayList<String>> word_char_map_original;
        word_char_map_original = create_hashmap_copy(word_char_map);
        List<Integer> indices_array = new ArrayList<Integer>();
        int count_group = 0;
        //Loop 1: for each character in string - upto size of word list
        
        for(int i=0; i<= s.length() - total_length_substring; i++){
        	int index = i;
        	int start_index = i;
        	int word_count = 0;
        	
        	while(index <= (s.length()-length_of_words)){
        		char current_char = s.charAt(index);
        		ArrayList<String> word_list = word_char_map.get(current_char);
        		String cur_word = s.substring(index, (index + length_of_words));
        		if((null != word_list) && word_list.contains(cur_word)){
        			index += length_of_words;
        			word_list.remove(cur_word);
        			word_char_map.put(current_char,word_list );
        			word_count ++ ;
        			
        			if(word_count == words.length){
        				indices_array.add(start_index);
    	        		count_group ++;
    	        		break;
            		}
        		}else{
        			break;
        		}
        		
        	}
        	word_char_map = create_hashmap_copy(word_char_map_original);
        	
        }
        return indices_array;
        
    }

	private static Map<Character, ArrayList<String>> create_hashmap_copy(
			Map<Character, ArrayList<String>> word_char_map) {
		Map<Character, ArrayList<String>> word_char_map_original = new HashMap<Character, ArrayList<String>>();
		for(Character c: word_char_map.keySet()){
			ArrayList<String> word_list = new ArrayList<String>();
			ArrayList<String> old_list = word_char_map.get(c);
			word_list.addAll(old_list);
			word_char_map_original.put(c, word_list);
		}
		return word_char_map_original;
	}

	// This method will divide the word list into set of words: grouped by the starting alphabet
	private static Map<Character, ArrayList<String>> create_word_map(String[] words) {
		
		Map<Character, ArrayList<String>> word_char_map = new HashMap<Character, ArrayList<String>>();
		for (String word : words){
			char c = word.charAt(0);
			if(null == word_char_map.get(c)){
				ArrayList<String> word_list = new ArrayList<String>();
				word_list.add(word);
				word_char_map.put(c, word_list);
			}else{
				ArrayList<String> word_list = word_char_map.get(c);
				word_list.add(word);
				word_char_map.put(c, word_list);
			}
		}
		return word_char_map;
	}
	
	
	
	public static void main(String[] args){
		String[] words = new String[2];
		words[0] = "foo";
		words[1] = "bar";
		//words[2] = "aa";
		System.out.println(findSubstring("foobarmanhellofoobarhelo", words));
	}
}
