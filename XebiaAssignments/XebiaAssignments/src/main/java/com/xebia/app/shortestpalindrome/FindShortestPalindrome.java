package com.xebia.app.shortestpalindrome;

public class FindShortestPalindrome {

	/**
	 * Below Method returns the shortest palindrome
	 * @param input
	 * @return
	 */
	public String findShortestPalindrome(String input) {
		int index = 0;
		for (int i = input.length() - 1; i >= 0; i--) {
			if (input.charAt(i) == input.charAt(index))
				index = index + 1;

		}
		if (index == input.length())
			return input;

		String suffix = input.substring(index);
		String palindrome = new StringBuilder(suffix).reverse().toString()
				+ findShortestPalindrome(input.substring(0, index)) + suffix;

		if (isPalindrome(palindrome)) {
			return palindrome;
		} else {
			return "String is not palindrome";
		}
	}

	public boolean isPalindrome(String str) {
	    return str.equals(new StringBuilder(str).reverse().toString());
	}

}
