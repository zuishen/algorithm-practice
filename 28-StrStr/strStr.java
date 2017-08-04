/*
*   Implement strStr().
*   Return the index of the first occurrence of needle in haystack or -1 if needle is not part of haystack.
*   "","" --> 0;  "a","" --> 0; "","a" --> -1;
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;   
        }
        boolean isReturn = true;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            isReturn = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isReturn = false;
                    break;
                }
            }
            if (isReturn) return i;
        }
        return -1;
    }
}
/*
*   常规方法，以haystack中的每一个字符为起点，去与needle进行比较。又因为当剩余字符长度小于needle时不可能相等，
*   所以范围为： [0...haystack.length()-needle.length()] 
*/

