/*
*   Given a string s, find the longest palindromic substring in s.
*   You may assume that the maximum length of s is 1000.
*
*   "babad" -> "bab";   // "aba" is also a valid anser.
*   "cbbd" -> "bb"
*/

// 暴力解法 brute force: 两个嵌套循环得出所有的子串，共n(n+1)/2个子串，然后对每个子串用一个循环判断是否为palindrome
//                      过程中记录下最长回文子串的start和end位置， O(n^3), O(1)

// DP
// 优化时的第一反应是使用记忆化搜索，通过二维数组，想减少判断回文串的时间复杂度，失败
// 其实优化的应该是需要找到它们位置之间的关系，然后用[i+1][j-1]去推出[i][j]是否为回文串
// 因此
// 使用动态规划方法 建立一个二维数组，A[i][j], i表示起点位置，j表示重点位置，值代表该子串是否为回文串
// 然后首先给[i][i]赋值为1，然后通过判断赋值[i][i+1] (即，以字符串长度为递增量)
// 然后以长度为2，起点为0开始，根据条件s.charAt(i) == s.charAt(i + j) && A[i+1][i+j-1]判断
// O(n^2), O(n^2)

public class Solution {
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        boolean[][] A = new boolean[s.length()][s.length()];
        int start = 0;
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); i++) {
            A[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            A[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int j = 2; j < s.length(); j++) {
            for (int i = 0; i + j < s.length(); i++) {
                if (A[i + 1][i + j - 1] && s.charAt(i) == s.charAt(i + j)) {
                    A[i][i + j] = true;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (A[i][j] && maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLength);   // [start, end)
    }
    
// 寻找中心，然后向外扩展，中心共有 2n-1个，因此循环遍历每个中心，在用一个循环扩展
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int maxLength = 0;
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i + 1);
            int tmp = Math.max(len1, len2);
            if (maxLength < tmp) {
                maxLength = tmp;
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
        // right 和 left 超过范围才会返回，-1 将多余的left部分除去，而right多加的1则之后算在了长度里（end - start + 1）
    }
}
