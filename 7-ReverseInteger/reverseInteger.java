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
                                        或者 if (tmp != (ret - digit) / 10) 
            */
                return 0;
            }
            x = x / 10;
        }
        return ret * flag;
       
        /*
        Solution 2: * long a = 1534236469 * 10;  依然会溢出，因为是以整型数计算，然后将计算的结果type cast后放入a中
                      而代码中先声明了一个long ret，所以计算 ret * 10 时会以long类型进行计算，1534236469L * 10.
                  
        int flag = x >= 0 ? 1: -1;
        x = Math.abs(x);
        long ret = 0;
        while (x != 0) {
            int digit = x % 10;
            if (10 * ret < 0) {
                return 0;
            }
            ret = 10 * ret + digit;
            if (ret > Integer.MAX_VALUE) {
                return 0;
            }
            //    if ((ret - digit) / 10 != original) {
            //        return 0;
            //    }
            //
            x = x / 10;
        }
        return (int)ret * flag;
        */
    }
}
