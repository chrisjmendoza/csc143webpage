public class RecursionExamples {

	public static void main(String[] args) {
		System.out.println("Towers of Hanoi with 4 disks");
		moveDisks(4, 1, 2, 3);
		System.out.println("\n4! = " + factorial(4));
		String s = "wasitacatisaw";
		System.out.println(isPalindrome(s));
		s = "cat";
		System.out.println(isPalindrome(s));
	}

	/**
	 * Computes n! for a given positive integer n n! = 1*2*3*4*...*n-1*n =
	 * (n-1)!*n
	 */
	public static long factorial(long n) {
		// base case
		if (n == 1) {
			return 1;
		} else {
			// n! = n * (n-1)!
			return n * factorial(n - 1);
		}
	}

	/**
	 * Returns true if the given String is a palindrome and false if not
	 */
	public static boolean isPalindrome(String s) {
		// base case
		if (s.length() <= 1) {
			return true;
		} else {
			return s.charAt(0) == s.charAt(s.length() - 1)
					&& isPalindrome(s.substring(1, s.length() - 1));
		}
	}

	/**
	 * Solution of the towers of Hanoi game with n disks Move n disks from the
	 * left peg to the right peg
	 */
	public static void moveDisks(int n, int left, int mid, int right) {
		// base case: just one disk
		if (n == 1) {
			System.out.println("Move the top disk on peg " + left + " to peg "
					+ right);
		} else {
			moveDisks(n - 1, left, right, mid);
			moveDisks(1, left, mid, right);
			moveDisks(n - 1, mid, left, right);
		}

	}

}
