/*
*   You are climbing a stair case. It takes n steps to reach to the top.
*   Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

//使用dynamic programming，数组steps[i]表示到了第i step时所有不同方法的数。O(n) O(n)
public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return n;           //条件应根据下面的下标使用情况 和 程序不能handle的特殊情况定
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        for (int i = 2; i < steps.length; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }
    
    //也可以使用brute force方法，计算每一种方法。O(2^n)
    public int climb(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        // if (memo[i] > 0) return memo[i];
        // memo[i] = climb(i + 1, n) + climb(i + 2, n); return memo[i];
        return climb(i + 1, n) + climb(i + 2, n);
    }
    //public int climbStairs(int n) {return climb(0, n);}
    
    //因为是前面i - 1 和 i - 2 相加，可以使用 fibonacci number来做， fib(n) = fib(n-1) + fib(n-2);
    //这样的到 O(N)的时间复杂度以及O(1)的空间复杂度
}
