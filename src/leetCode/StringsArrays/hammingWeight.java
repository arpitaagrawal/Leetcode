package leetCode.StringsArrays;

public class hammingWeight {

	public static int hammingWt(int n) {

		int count = 0;
		String binaryInt = Integer.toBinaryString(n);
		for (int i = 0; i < binaryInt.length(); i++) {
			if (binaryInt.charAt(i) == '1') {
				count++;
			}
		}

		return count;
	}

	public static int hammingWtbit(int n) {

		int ones = 0;
		while(n!=0){
			ones = ones + (1 & n);
			//right shift by one bit
			// keep right shifting till the number = 0
			// With this right shifting we can check each place by pushing it to the ones place
			n = n>>>1;
		}

		return ones;
	}

	public static void main(String[] args) {
		System.out.println(hammingWtbit(11));
	}
}
