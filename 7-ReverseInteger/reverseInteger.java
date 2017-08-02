public class Solution {
    public int reverseInteger(int x) {
        int flag = x >= 0 ? 1 : -1;
        int ret = 0;
        x = Math.abs(x);
        while (x != 0) {
            int tmp = ret;
            int digit = x % 10;
            ret = 10 * ret + digit;
            if (tmp != ret / 10) {    
            /* 与2147483647同样数位时，最高位一定是<=2，而2147483640+8才会造成溢出，这意味着input为8463847412，
               因此此时所加的digit不会造成溢出。 if (tmp > (Integer.MAX_VALUE - digit) / 10)  --> 在符号一定相同情况下才可使用！
                                        或者 if (tmp != ret / 10)   --> 相除后不会保留各位 所以结果应当相同
            */
                return 0；
            }
            x = x / 10;
        }
        return ret;
    }
}
