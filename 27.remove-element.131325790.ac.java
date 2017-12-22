class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            while (i <= j && nums[j] == val) {
                j--;
            }

            while (i <= j && nums[i] != val) {
                i++;
            }

            if (i < j) {
                nums[i] = nums[j--];
            }
        }

        return i;
    }
}