package leetCode.StringsArrays;

public class AandS {

	public static void main(String args[]){
		String str1 = "arpita";
		String str2 = "pooja";
		boolean isAnagram = isAnagram(str1, str2);
		System.out.println(isAnagram);
		
		char[] str_arr = "Helllo how are you".toCharArray();
		replaceSpacewithSpecialChar(str_arr);
				
	}
	
	private static boolean isAnagram(String str1, String str2){
		
		int[] char_arr_rep = new int[26];
		for(int i=0; i< str1.length(); i++){
			int char_id = str1.charAt(i) - 'a';
			char_arr_rep[char_id] += 1;
		}
		
		for(int i=0; i< str2.length(); i++){
			int char_id = str2.charAt(i) - 'a';
			char_arr_rep[char_id] -= 1;
		}
		
		for(int i=0; i< char_arr_rep.length; i++){
			if(char_arr_rep[i] != 0){
				return false;
			}
		}
		
		return true;
	}
	
	private static void replaceSpacewithSpecialChar(char[] sample_str){
		int count_of_spaces = 0;
		for(int i=0; i<sample_str.length; i++){
			if(sample_str[i]== ' '){
				count_of_spaces ++ ;
			}
		}
		
		int new_string_length = sample_str.length + (count_of_spaces*2);
		char[] extended_arr = new char[new_string_length];
		int cur_index = new_string_length - 1;
		for(int i=sample_str.length -1; i>=0; i--){
			if(sample_str[i] == ' '){
				//System.out.println(i);
				extended_arr[cur_index] = '0';
				cur_index --;
				extended_arr[cur_index] = '2';
				cur_index --;
				extended_arr[cur_index] = '%';
				
			}else{
				extended_arr[cur_index] = sample_str[i];
				System.out.println(extended_arr[cur_index]);
			}
			//System.out.println(cur_index);
			cur_index --;
		}
		System.out.println(new String(extended_arr));
	}
}
