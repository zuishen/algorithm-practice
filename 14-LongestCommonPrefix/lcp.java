/*
* Write a function to find the longest common prefix string among an array of strings
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {        //strs[0]的每一个字符
            for (int j = 1; j < strs.length; j++) {         //分别与数组中的字符串的相应字符进行比较
                if (strs[j].length() == i || strs[0].charAt(i) != strs[j].charAt(i)) {  //注意字符串长度
                    return strs[0].substring(0, i);   
                }
            }
        }
        return strs[0];
    }
}
