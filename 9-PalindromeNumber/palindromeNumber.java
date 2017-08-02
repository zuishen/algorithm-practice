/*  
*  For this question:
*  1. Could negative integers be palindromes? No
*  2. Overflow?  (1) 2147483647最大范围内的palindrome位21474 47412，再大则不是，若继续增长则发生溢出，
*     又因为题目参数是int，因此溢出可以一律视为不是。 
*/
public class Solution {
    public boolean palindromeNumber(int x) {
        if (x < 0) {
            return false;
        }
        int ret = 0;
        int num = x;
        while (num != 0) {
            int digit = num % 10;
            //int tmp = ret;
            ret = 10 * ret + digit;
            /*
            if (tmp != ret / 10) {
                return false;
            }
            */
            num = num / 10;
        }
        if (ret == x) {
            return true;
        }
        return false;
    }
}
