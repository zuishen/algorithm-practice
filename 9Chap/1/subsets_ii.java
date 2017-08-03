/**
*   Subsets II
*
*   Given a collection of integers that might contain duplicates, nums, return
*   all possible subsets.
* 
*   Note: The solution set must not contain duplicate subsets.
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null) {
            return ret;
        }
        Arrays.sort(nums);
        helperWithDup(result, 0, nums, ret);
        return ret;
    }
    
    private void helperWithDup(List<Integer> result, int pos, int[] nums, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(result));
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            result.add(nums[i]);
            helperWithDup(result, i + 1, nums, ret);
            result.remove(result.size() - 1);
        }
    }
}

// This is the follow-up of subsets
// According to the DFS tree we build, we need to avoid adding equal number at the same level (after sorting).
// So, just add a condition in the for loop.
// i != pos is to get rid of the situation that the number in first loop equals the last loop.
