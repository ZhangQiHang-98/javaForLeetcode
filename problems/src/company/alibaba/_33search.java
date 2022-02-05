package company.alibaba;

/**
 * @Description 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * @Author Zhang Qihang
 * @Date 2022/2/5 17:24
 */
public class _33search {
    public int search(int[] nums, int target) {
        // 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
        // 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
        // 判断子数组是否有序，要看nums[mid]和nums[start]，注意理解题意
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 判断左右哪个有序
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左侧有序
            if (nums[mid] >= nums[left]) {
                // 判断target是否在左侧[left,mid-1]区间
                if (nums[left] <= target && target < nums[mid]) {
                    // 如果是的话，往左收缩区间
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 判断target是否在右侧[mid+1,right]区间
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
