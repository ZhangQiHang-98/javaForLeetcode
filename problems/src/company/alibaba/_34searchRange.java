package company.alibaba;

/**
 * @Description 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * @Author Zhang Qihang
 * @Date 2022/2/3 17:19
 */
public class _34searchRange {
    // 第一个和最后一个，那就最左查找和最右查找都来一遍吧
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        if (left > right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchRight(int[] nums, int target) {
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
