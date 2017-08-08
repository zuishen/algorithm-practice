/*
*   Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
*   return the length of last word in the string. If the last word does not exist, return 0.
*   ** A word is defined as a character sequence consists of non-space characters only.
*   s="Hello World" ==> 5
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = -1;
        int end = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                end = i;
                break;
            }
        }
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                start = i;
                break;
            }
        }
        return end - start;
    }
}
/*
*   思路：考虑了由前往后的遍历方法，难以做出，又因为是find last，所以考虑从后往前找。
*       首先考虑一下几种情况："hello word", "", " ", "a","a  ";  然后想解法
*       1.首先从后往前找到第一个非空格字符的位置，记录在end中
*       2.然后找到end前最后一个空格字符的位置
*       3.start-end 得出长度   
*       ** 因为start代表的是last word的第一个字符前的空格的位置，如果没有空格，则不会给start赋值，所以看作start自动减1，因此默认值为-1。
*/
