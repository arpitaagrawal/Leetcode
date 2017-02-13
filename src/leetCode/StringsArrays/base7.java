package leetCode.StringsArrays;

/**
 * @author arpita
 *
 *
 *         Given an integer, return its base 7 string representation.
 * 
 *         Example 1: Input: 100 Output: "202" Example 2: Input: -7 Output:
 *         "-10" Note: The input will be in range of [-1e7, 1e7].
 * 
 *         * Feb 13'2017
 *         Question taken from leetcode: https://leetcode.com/problems/base-7/
 */
public class base7 {

	public static String convertToBase7(int num) {

		if (num == 0)
			return "0";

		StringBuilder sb = new StringBuilder();
		boolean negative = false;

		if (num < 0) {
			negative = true;
		}
		while (num != 0) {
			sb.append(Math.abs(num % 7));
			num = num / 7;
		}

		if (negative) {
			sb.append("-");
		}

		return sb.reverse().toString();

	}

	public static void main(String[] args) {
		System.out.println(convertToBase7(100));
	}
}
