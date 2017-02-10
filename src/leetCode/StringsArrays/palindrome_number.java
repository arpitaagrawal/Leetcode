package leetCode;

public class palindrome_number {
	public static boolean isPalindrome(int x) {

		// 729 = rem1 =9,q=72, rev=1*9 --> rem =2, q=7,rev=9*10 +2 ---> rem =7,
		// q=0, rev=92*10 +7 : Formula: rev = rev*10 + remainder
		// 720 = rem1 =0,q=72, rev=0 --> rem =2, q=7,rev=9*10 +2 ---> rem =7,
		// q=0, rev=92*10 +7 : Formula: rev = rev*10 + remainder

		boolean isPalindrome = true;
		int rev = 0;
		int cur_x = x;
		if (x < 0)
			return false;

		while (cur_x > 0) {
			rev = rev * 10 + cur_x % 10;
			cur_x = cur_x / 10;
		}
		System.out.println(rev);
		if (rev != x) {
			isPalindrome = false;
		}
		return isPalindrome;

	}

	public static void main(String[] args) {
		isPalindrome(121);
	}
}
