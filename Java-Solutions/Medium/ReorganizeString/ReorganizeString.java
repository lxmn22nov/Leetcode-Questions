/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
Return any possible rearrangement of s or return "" if not possible.

Example 1:
Input: s = "aab"
Output: "aba"

Example 2:
Input: s = "aaab"
Output: ""
*/
import java.util.*;
public class ReorganizeString {
    public static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        char maxFrequencyLetter = ' ';
        int n = s.length();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (maxFrequency < map.get(c)) {
                maxFrequency = map.get(c);
                maxFrequencyLetter = c;
            }
        }
        if (maxFrequency > (n + 1) / 2) {
            return "";
        }
        char[] letters = new char[s.length()];
        int idx = 0;
        idx = insertLetter(n, map, maxFrequencyLetter, letters, idx);
        map.remove(maxFrequencyLetter);
        for (Character key : map.keySet()) {
            idx = insertLetter(n, map, key, letters, idx);
        }
        return String.valueOf(letters);
    }
    private static int insertLetter(int n, Map<Character, Integer> map, char maxFrequencyLetter, char[] letters, int idx) {
        while (map.get(maxFrequencyLetter) > 0) {
            if (idx >= n) {
                idx = 1;
            }
            letters[idx] = maxFrequencyLetter;
            idx += 2;
            map.put(maxFrequencyLetter, map.get(maxFrequencyLetter) - 1);
        }
        return idx;
    }
    public static void main(String[] args) {
        String s = "aab";
        System.out.println("Reorganize String: "+reorganizeString(s));
    }
}