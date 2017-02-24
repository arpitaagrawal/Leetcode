package leetCode.StringsArrays;

import java.util.Map;
import java.util.TreeMap;

public class StrongPasswordChecker {

	public static int strongPasswordChecker(String s) {

		if (s == null || s.length() < 1) {
			return 6;
		}
		int strLen = s.length();
		int editsRequired,insertsRequired, deletionsRequired;
		insertsRequired = deletionsRequired = editsRequired =0;
		int lowerUpperEdits = hasLowerAndUpper(s);
		int consecutiveEditsRequired = getConsecutiveLetterModifies(s,0);
		if (strLen < 6) {
			insertsRequired = 6 - strLen;
		}else if(strLen >20){
			deletionsRequired = strLen -20;
			consecutiveEditsRequired = getConsecutiveLetterModifies(s,deletionsRequired);
		}
		editsRequired = Math.max(lowerUpperEdits, Math.max(consecutiveEditsRequired, insertsRequired));
		System.out.println("lowerUpperEdits::: " + lowerUpperEdits + ", insertsRequired:::: " + insertsRequired
				+ ",  consecutiveEditsRequired:::: " + consecutiveEditsRequired);
		return editsRequired;
	}

	private static int getConsecutiveLetterModifies(String s, int deletions) {
		int count = 0;
		char prevChar = s.charAt(0);
		int consCharCount = 1;
		int numConsBlocks = 0;
		Map<Integer, Integer> consecuteBlocksCount = new TreeMap<Integer, Integer>();
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == prevChar) {
				consCharCount++;
			} else {
				if(consCharCount > 2){
					numConsBlocks ++;
					Integer blockCount = consecuteBlocksCount.get(consCharCount);
					if (blockCount != null) consecuteBlocksCount.put(consCharCount, blockCount+ 1);
					else consecuteBlocksCount.put(consCharCount, 1);
					count += consCharCount / 3;
					consCharCount = 1;
				}
				consCharCount = 1;
			}
			prevChar = s.charAt(i);
		}
		count += consCharCount / 3;
		
		while((deletions > 0) && (numConsBlocks>0)){
			for (Integer blockSize: consecuteBlocksCount.keySet()){
				System.out.println("block Size ::" + blockSize + ", number of blocks ::"+ consecuteBlocksCount.get(blockSize));
				// First delete 
			}
		}
		return count;
	}

	public static int hasLowerAndUpper(String s) {

		boolean hasLower,hasUpper,hasDigit;
		hasLower = hasUpper = hasDigit = false;
		int editCount = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLowerCase(c))   hasLower = true;
			else if (Character.isUpperCase(c))  hasUpper = true;
			else if (Character.isDigit(c))  hasDigit = true;

			if (hasLower && hasUpper && hasDigit)   break;
		}

		if (!hasDigit)  editCount++;
		if (!hasLower)  editCount++;
		if (!hasUpper)  editCount++;
		return editCount;
	}

	public static void main(String[] args) {
		// System.out.println(hasLowerAndUpper("#$#$#$"));
		// System.out.println("Edits Required::");
		String sample = "aaaaaa11aaaaaaa1bbbbtttdddwerfhhhhhhreqqqcdddvrrrbttttt";
		System.out.println(sample);
		System.out.println("Edits Required::" + strongPasswordChecker(sample));
	}

	public void testSt() {
		// System.out.println("lowerUpperEdits ::: "+lowerUpperEdits);
		// System.out.println("consecutiveModifyReq ::::::" +
		// consecutiveModifyReq);
	}
}
