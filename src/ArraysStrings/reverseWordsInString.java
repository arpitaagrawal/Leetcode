package ArraysStrings;

import java.util.HashSet;
import java.util.Set;

public class reverseWordsInString {

	public static String reverseWords(String s) {

		String[] parts = s.trim().split("\\s+");
		StringBuilder out = new StringBuilder();
		for (int i = parts.length - 1; i > 0; i--) {
			out.append(parts[i] + " ");
		}
		return out.append(parts[0]).toString();
	}

	public static String reverseVowels(String s) {
		StringBuilder reverseStringSb = new StringBuilder(s);
		int startId = 0;
		int endID = s.length() - 1;

		Set<Character> charSet = getVowelsSet();

		while (startId < endID) {
			boolean isStartIndexVowel = charSet.contains(Character.toLowerCase(reverseStringSb.charAt(startId)));
			boolean isSEndIndexVowel = charSet.contains(Character.toLowerCase(reverseStringSb.charAt(endID)));
			// If both vowels just replace them
			if (isSEndIndexVowel && isStartIndexVowel) {
				char ch = reverseStringSb.charAt(startId);
				reverseStringSb.setCharAt(startId, reverseStringSb.charAt(endID));
				reverseStringSb.setCharAt(endID, ch);
				startId++;
				endID--;
			} else if (isSEndIndexVowel) {
				startId++;
			} else if (isStartIndexVowel) {
				endID--;
			} else {
				startId++;
				endID--;
			}
		}

		return reverseStringSb.toString();
	}
	
	public static String reverseString(String s) {
        if(s == null || s.isEmpty())
        	return s;
        char[] char_arr = s.toCharArray();
        StringBuilder reverseSb = new StringBuilder();
        for(int i=(char_arr.length-1); i>=0; i--){
        	reverseSb.append(char_arr[i]);
        }
        
        return reverseSb.toString();
    }

	public static void main(String[] args) {
		// System.out.println(reverseWords("hello how are tou"));
		System.out.println(reverseString("arpita"));
	}

	public static Set<Character> getVowelsSet() {
		Set<Character> charSet = new HashSet<Character>();
		charSet.add('a');
		charSet.add('e');
		charSet.add('i');
		charSet.add('o');
		charSet.add('u');
		return charSet;
	}
}
