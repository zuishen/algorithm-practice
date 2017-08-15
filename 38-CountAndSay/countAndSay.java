/*
*   The count-and-say sequence is the sequence of integers with the first five terms as following:
*   1->1, 2->11, 3->21, 4->1211, 5->111221
*   Given an integer n, generate the nth term of the count-and-say sequence.
*/
//  通过上一个数得到下一个数的sequence。count num + count num + ....

public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "1";
        List<String> strs = new ArrayList<>();
        strs.add("1");
        for (int i = 1; i < n; i++) {
            String prev= strs.get(i - 1);
            StringBuilder tmp = new StringBuilder();
            int count = 1;
            int j = 0;
            while (j < prev.length() - 1) {
                if (prev.charAt(j) == prev.charAt(j + 1)) {
                    count++;
                } else {
                    tmp.append(count);
                    tmp.append(prev.charAt(j));
                    count = 1;
                }
                j++;
            }
            tmp.append(count);
            tmp.append(prev.charAt(j));
            strs.add(tmp.toString());
        }
        return strs.get(n - 1);
    }
}
