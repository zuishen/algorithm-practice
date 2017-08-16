/*
*   Given an array of integers, every element appears twice except for one. Find that single one.
*   linear runtime complexity, without using extra memory.
*/

public class Solution {
    public int singleNumber1(int[] nums) {  // hashMap
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return 0;
    }
    
    public int singleNumber2(int[] nums) {  // xor
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }
    
    public int singleNumber3(int[] nums) {  // set
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                set.remove(i);
            }
        }
        return set.iterator().next();
    }
}
