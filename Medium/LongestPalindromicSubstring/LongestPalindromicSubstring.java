/*
Given a string s, return the longest palindromic substring  in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
*/
class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] result = new int[]{0, 0};
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                result[0] = i;
                result[1] = i + 1;
            }
        }
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int k = i + j;
                if (s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1]) {
                    dp[j][k] = true;
                    result[0] = j;
                    result[1] = k;
                }
            }
        }
        return s.substring(result[0], result[1] + 1);
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println("Longest Palindromic Substring: "+longestPalindrome(s));
    }
}