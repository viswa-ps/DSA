package dsa.tuf.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {2, -2, 0, 3, -3, 5};
        System.out.println(threeSum(arr));
    }

    //NOTE: Optimal Approach
    // Complexity Analysis
    // Time Complexity: OO(NlogN)+O(N2)
    // Space Complexity: O(1)
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            findTargetSum(nums, i, result);
        }
        return result;
    }

    private static void findTargetSum(int[] nums, int start, List<List<Integer>> result){
        int currNum = nums[start];
        int first = start + 1;
        int last = nums.length - 1;
        while (first < last){
            int sum = currNum + nums[first] + nums[last];
            if (sum == 0) {
                result.add(Arrays.asList(currNum, nums[first], nums[last]));
                first++;
                last--;
                while (first < last && nums[first] == nums[first - 1]) first++;
                while (first < last && nums[last] == nums[last + 1]) last--;
            }
            else if (sum > 0) last--;
            else first++;
        }
    }
}
