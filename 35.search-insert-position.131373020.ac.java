class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        if (target > nums[n - 1]) {
            return n;
        }
        
        int start = 0;
        int end = n - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}