/*
*   Comute and return the square root of x.
*/

public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) {
            return x;
        }
        int start = 0;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end <= x / end) {
            return end;
        } else {
            return start;
        }
    }
}

/*
*   一般解法从0开始，循环往上找，负载度为O(n)
*   可以使用binary search, start=0，end=x;
*   但需要考虑因为数字过大造成square溢出，因此可用除法，或者使用long
*   使用除法因考虑除数不可为0
*/
