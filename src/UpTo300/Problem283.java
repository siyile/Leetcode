package UpTo300;

public class Problem283 {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[j++] = nums[i];
        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }
}
