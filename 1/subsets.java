/**
*   Subsets
*
*   Given a set of ditinct integers, nums, return all possible subsets.
*   Note: The solution set must not contain duplicate subsets.
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<>();
        
        if (nums == null) {
            return ret;
        }
        
        Arrays.sort(nums);
        helper(result, 0, nums, ret);
        return ret;
    }
    
    private void helper(List<Integer> result, int start, int[] nums, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(result));
        for (int i = start; i < nums.length; i++) {
            result.add(nums[i]);
            helper(result, i + 1, nums, ret);
            result.remove(result.size() - 1);
        }
    }
}

// This is a permutation/combinamtion question, we can consider using bfs/dfs to solve it.
// Either bfs or dfs can solve it, but dfs would save more memory than bfs.
// Since the nums.length will not too big, we can implement dfs using recursion.
// 递归三要素： 1. 递归的定义（接收什么样的参数，返回什么值，做了什么事）
//            2. 递归的拆解
//            3. 递归的出口 （什么时候不忘下递归了， 可以直接找到答案出口）
