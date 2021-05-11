package array;

public class _34searchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = leftBound(nums, target);
        int right = rightBound(nums, target);
        if (left < right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] >= target) { // 找到了target，但是不一定是第一次出现的，但第一次出现的地方一定在target左边，缩小为左区间
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            }
        }
        return left;
    }

    public int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            if (nums[middle] <= target) { // 找到了target，但是不一定是第一次出现的，但第一次出现的地方一定在target左边，缩小为左区间
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        return right;
    }
}
