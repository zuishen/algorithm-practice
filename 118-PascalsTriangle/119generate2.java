/*
*   Given an index k, return the kth row of the Pascal's triangle
*   For example, given k = 3, return [1,3,3,1]
*
*   Could you optimize your algorithm to use only O(k) extra space?
*/
//  rowIndex 为数组下标

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr = new ArrayList<>();
        if (rowIndex < 0) return curr;
        curr.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> prev = curr;
            curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < i; j++) {
                curr.add(prev.get(j - 1) + prev.get(j));
            }
            curr.add(1);
        }
        
        return curr;
    }
}
