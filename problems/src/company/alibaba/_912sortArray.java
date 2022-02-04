package company.alibaba;

import java.util.Random;

/**
 * @Description 给你一个整数数组nums，请你将该数组升序排列。
 * @Author Zhang Qihang
 * @Date 2022/2/3 14:53
 */
public class _912sortArray {

    //1. 快排
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int l, int r) {
        // 区间里至少有一个值
        if (l < r) {
            // 返回的是随机选的一个哨兵的正确位置
            int pos = partition(nums, l, r);
            // 根据这个哨兵，归并排序
            quickSort(nums, l, pos - 1);
            quickSort(nums, pos + 1, r);
        }
    }

    public int partition(int[] nums, int l, int r) {
        // 随机选择一个元素，因为是右开区间，所以+1
        int index = new Random().nextInt(r - l + 1) + l;
        // 将这个元素放到最末尾
        swap(nums, r, index);
        // 标记该元素的值
        int pivot = nums[r];

        // 两个指针开始走,i一直指的是小于pivot的值
        int i = l;
        for (int j = l; j <= r - 1; j++) {
            // 找到了比pivot小的值，就往前放
            if (nums[j] <= pivot) {
                // 让i往后走一步
                swap(nums, i, j);
                i++;
            }
        }
        // 将哨兵元素放回来
        swap(nums, i, r);
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 2. 归并排序

    int[] tmp;

    public int[] _sortArray(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r) {
        // 已经局部有序
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        // 先对局部进行排序
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        // 然后对这两个数组进行整理合并,创建两个指针
        int p1 = l;
        int p2 = mid + 1;
        int count = l;
        while (p1 <= mid && p2 <= r) {
            if (nums[p1] <= nums[p2]) {
                tmp[count++] = nums[p1++];
            } else {
                tmp[count++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            tmp[count++] = nums[p1++];
        }
        while (p2 <= r) {
            tmp[count++] = nums[p2++];
        }
        // 把tmp沾到nums中
        for (int k = l; k <= r; k++) {
            nums[k] = tmp[k];
        }
    }
}
