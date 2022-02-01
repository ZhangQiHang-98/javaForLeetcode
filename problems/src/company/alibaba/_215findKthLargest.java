package company.alibaba;

import java.util.Random;

/**
 * @Description 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * @Author Zhang Qihang
 * @Date 2022/1/29 19:26
 */
public class _215findKthLargest {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return select(nums, 0, len - 1, len - k);
    }

    private int select(int[] nums, int left, int right, int k) {
        //只有一个值 说明找到了
        if (left == right) return nums[left];
        // random select pivotIndex between left and right
        int pivotIndex = left + random.nextInt(right - left);
        // do partition, move smaller than pivot number into pivot left
        // pos就是当前基准值在的索引
        int pos = partition(nums, left, right, pivotIndex);
        if (pos == k) {
            return nums[pos];
        } else if (pos > k) {
            return select(nums, left, pos - 1, k);
        } else {
            return select(nums, pos + 1, right, k);
        }
    }

    // 通用的写法，可以记忆一下模板
    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];
        // move pivot to end,先移动到最后面去
        swap(nums, right, pivotIndex);
        int pos = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                // 遍历找到小于refer的值，放到目前的左边
                swap(nums, pos++, i);
            }
        }
        // move pivot to original place，记得最后再交换回来
        swap(nums, right, pos);
        return pos;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
