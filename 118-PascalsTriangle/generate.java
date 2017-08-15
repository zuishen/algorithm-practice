/*
*   Given numRows, generate the first numRows of Pascal's triangle.
*   n=5, [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,5,4,1]]
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) return result;
        result.add(Arrays.asList(1));
        
        for (int i = 1; i < numRows; i++) {     // 第i+1行为当前行
            List<Integer> prev = result.get(i - 1);
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {      // tmp[j] = prev[j] + prev[j-1], [0],[i] = 1
                tmp.add(prev.get(j - 1) + prev.get(j));
            }
            tmp.add(1);
            result.add(tmp);
        }
        return result;
    }
}
