/* Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2] */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int curr = 1;

        for (int i = 0; i < n; i++) {
            result.add(curr);

            if (curr * 10 <= n) {
                curr *= 10; // go to next child
            } else {
                if (curr >= n) curr /= 10; // ensure we can go up safely

                // go to next sibling or backtrack to a valid sibling
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10;
                }

                curr += 1;
            }
        }

        return result;
    }
}
