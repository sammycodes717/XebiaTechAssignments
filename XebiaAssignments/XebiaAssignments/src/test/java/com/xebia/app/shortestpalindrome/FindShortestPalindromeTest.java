/**
 * 
 */
package com.xebia.app.shortestpalindrome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Sumit Agrawal
 *
 */
class FindShortestPalindromeTest {

	/**
	 * @throws java.lang.Exception
	 */
	FindShortestPalindrome findShortestPalindrome;

	@BeforeEach
	void setUp() throws Exception {
		findShortestPalindrome = new FindShortestPalindrome();

	}

	/**
	 * Test method for
	 * {@link com.xebia.app.shortestpalindrome.FindShortestPalindrome#findShortestPalindrome(java.lang.String)}.
	 */
	@Test
	void testFindShortestPalindrome1() {
		
		List<String> list = Arrays.asList("palin","a","ab","aba");
		
		list.forEach(arg->{
			assertEquals(true, findShortestPalindrome.isPalindrome(findShortestPalindrome.findShortestPalindrome(arg)));
		});
		
	}
}
