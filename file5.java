//Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

import java.util.Arrays;

class file5 {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Pointer for next position to place non-val element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        file5 solution = new file5();

        // Example 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int k1 = solution.removeElement(nums1, val1);
        System.out.println("Returned k: " + k1);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums1, k1)));

        // Example 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int k2 = solution.removeElement(nums2, val2);
        System.out.println("Returned k: " + k2);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums2, k2)));
    }
}
 
    

