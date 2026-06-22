package dsa.tuf.arrays.easy;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 0, 0, 1, 1, 1, 0};
        int[] arr2 = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(arr2));
    }

    public static int findMaxConsecutiveOnes(int[] nums){
        int consecutiveOnes = 0;
        int max = 0;
        for (int i : nums){
            if (i == 1) {
                consecutiveOnes++;
            }
            else{
                max = Math.max(max, consecutiveOnes);
                consecutiveOnes = 0;
            }
        }
        return (int) Math.max(max, consecutiveOnes);
    }
}
