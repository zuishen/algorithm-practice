/*
*   Given a string, find the length of the longest substring without repeating characters.
*   "abcabcbb" -> "abc" -> 3
*   "bbbbbb" -> "b" -> 1
*   "pwwkew" -> "wke" -> 3
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int maxLength = 1;
        
        while (end < s.length()) {
            if (!set.add(s.charAt(end))) {
                while (start < end) {
                    if (s.charAt(start) == s.charAt(end)) {
                        start++;
                        break;
                    } else {
                        set.remove(s.charAt(start));
                        start++;
                    }
                }
            }
            if (maxLength < end - start + 1) {
                maxLength = end - start + 1;
            }
            end++;
        }
        return maxLength;
    }
}
