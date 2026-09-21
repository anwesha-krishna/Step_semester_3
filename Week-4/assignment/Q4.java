import java.util.HashMap;
import java.util.Map;

public class Q4 {
    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // empty prefix has sum 0, occurs once

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            count += prefixSumCount.getOrDefault(currentSum - k, 0);
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        System.out.println(subarraySum(nums1, 2));
        // Expected: 2

        int[] nums2 = {1, -1, 0};
        System.out.println(subarraySum(nums2, 0));
        // Expected: 3
    }
}
