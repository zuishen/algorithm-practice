/*
*   Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
*   For example, "A man, a plan, a canal: Panama" is a palindrome.
*   "race a car" is not a palindrome.
*/
//  需要考虑如何跳过非字母或数字的字符 Character.isLetter(), Character.isDigit()
//  将字符全部转化为小写后比较，以达到忽略大小写比较 Character.toLowerCase()

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < s.length() && 
                   !Character.isLetter(s.charAt(start)) && 
                   !Character.isDigit(s.charAt(start)) ) {
                start++;
            }
            while (end >= 0 &&
                   !Character.isLetter(s.charAt(end)) &&
                   !Character.isDigit(s.charAt(end)) ) {
                end--;
            }
            if (start >= end) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
