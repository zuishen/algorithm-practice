/**
*   Implement strStr()
*    
*   Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}

// Use two loops to solve this question
// Watch out the outer loop condition: i <= haystack.length() - needle.length()
// This means if the left of haystack is shorter than needle, it's impossilbe to 
//  find this needle.
