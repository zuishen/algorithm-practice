/*
*   Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
*   You may assume the integer do not contain any leading zero, except the number 0 itself.
*   The digits are stored such taht the most significant digit is at the head of the list.
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }
        int carries = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carries;
            if (digits[i] >= 10) {
                carries = digits[i] / 10;
                digits[i] = digits[i] % 10;
            } else {
                carries = 0;
                break;
            }
        }
        int[] ret = digits;
        if (carries > 0) {
            ret = new int[digits.length + 1];
            ret[0] = carries;
            for (int i = 1; i < ret.length; i++) {
                ret[i] = digits[i - 1];
            }
        }
        return ret;
    }
}
