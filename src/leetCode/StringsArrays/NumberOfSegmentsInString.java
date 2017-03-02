package leetCode.StringsArrays;

/**
 * @author arpita agrawal
 * 
 *         Count the number of segments in a string, where a segment is defined
 *         to be a contiguous sequence of non-space characters.
 * 
 *         Please note that the string does not contain any non-printable
 *         characters.
 * 
 *         Example:
 * 
 *         Input: "Hello, my name is John" Output: 5
 *
 * 
 */
public class NumberOfSegmentsInString {

	public static int countSegments(String s) {
		
		if(s== null || s.isEmpty()){
			return 0;
		}
		
		String[] segmentsArray = s.split("\\s+");
		return segmentsArray.length;
		
		
		
	}
	
	public static void main(String args[]){
		System.out.println(countSegments("               "));
	}
}
