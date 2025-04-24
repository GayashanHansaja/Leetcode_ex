#Count Complete Subarrays in an Array

/* You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.

 

Example 1:

Input: nums = [1,3,1,2,2]
Output: 4
Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
Example 2:

Input: nums = [5,5,5,5]
Output: 10
Explanation: The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10. */

public class Solution {
    public int CountCompleteSubarrays(int[] nums) {
        // Step 1: Get the number of distinct elements in the entire array
        HashSet<int> fullDistinct = new HashSet<int>(nums);
        int targetDistinctCount = fullDistinct.Count;

        int completeCount = 0;

        // Step 2: Check all subarrays
        for (int start = 0; start < nums.Length; start++) {
            HashSet<int> subarrayDistinct = new HashSet<int>();

            for (int end = start; end < nums.Length; end++) {
                subarrayDistinct.Add(nums[end]);

                // Step 3: If distinct count matches, it’s a complete subarray
                if (subarrayDistinct.Count == targetDistinctCount) {
                    completeCount++;
                }
            }
        }

        // Step 4: Return the result
        return completeCount;
    }
}
