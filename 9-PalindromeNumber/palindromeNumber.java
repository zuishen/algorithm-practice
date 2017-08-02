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
            int ret = 10 * ret + digit;
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
