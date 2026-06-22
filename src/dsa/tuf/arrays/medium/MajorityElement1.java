package dsa.tuf.arrays.medium;

public class MajorityElement1 {
    //TODO : Given an integer array nums of size n, return the majority element of the array.
    // The majority element of an array is an element that appears more than n/2 times in the array.
    // The array is guaranteed to have a majority element.
    // Example
    // Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
    // Output: 7
    // Explanation:
    // The number 7 appears 5 times in the 9 sized array
    public static void main(String[] args) {
        int[] arr1 = {7, 0, 0, 1, 7, 7, 2, 7, 7};
        int[] arr2 = {1, 1, 1, 2, 1, 2};
        int[] arr3 = {4,5,5};
        System.out.println(majorityElement(arr1));
        System.out.println(majorityElement(arr2));
        System.out.println(majorityElement(arr3));
    }


    //NOTE:Intuition
    // Imagine you are at a large party, and you want to determine which dish is the most popular.
    // Each guest has brought a dish, and some dishes are brought by more guests than others.
    // The party is large enough that one dish is guaranteed to be the majority dish,
    // meaning it was brought by more than half of the guests.
    // Initial observation is as we move around the party,
    // you decide to start keeping track of the dishes in a specific way.
    // Begin with no specific dish in mind and no count. On seeing each dish, do the following:
    // If you don’t have a dish you’re tracking yet, start tracking the current dish and set its count to 1.
    // If the current dish matches the one you’re tracking, increase its count by 1.
    // If the current dish doesn’t match the one you’re tracking, decrease the count by 1. If the count drops to zero, stop tracking that dish and start tracking the next dish.
    // The idea is that at any point where the count of tracked dishes drops to zero, it means up to that point, the popularity of different dishes has balanced out. This reset allows you to focus on potentially more popular dishes as you continue through the party. At the end check which dish you ended up tracking last. This dish is your candidate for the most popular dish. To confirm if this dish is indeed the majority dish, recount its appearances to see if it indeed makes up more than half of all dishes at the party. If it does, then you have found your majority dish. If it doesn’t, there was an error in the process, but for this scenario, we assume the party is large enough to guarantee one majority dish.

    //NOTE: Optimal Approach
    // Complexity Analysis
    // Time Complexity: O(N) + O(N)
    // Space Complexity: O(1)
    public static int majorityElement(int[] nums) {
       int max = nums[0];
       int count = 1;
       for (int i = 1; i < nums.length; i++){
           if (nums[i] == max){
               count++;
           }
           else{
               count--;
               if (count == 0){
                   max = nums[i];
                   count = 1;
               }
           }
       }
        int cnt1 = 0;
        for (int num : nums) {
            if (num == max) {
                cnt1++;
            }
        }
        if (cnt1 > (nums.length / 2)) {
            return max;
        }
       return -1;
    }
}
