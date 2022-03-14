package stackAndQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @Description 寻找第K大
 * @Author Zhang Qihang
 * @Date 2022/3/11 21:02
 */
public class _offer76findKthLargest {
    // 利用堆的方法
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>(k + 1, Comparator.comparingInt(o -> o));
        for (int e : nums) {
            heap.add(e);
            // 如果超出了，要删除元素
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    // 快排方法
    public int _findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        int pos = getPivot(nums, start, end);
        while (pos != target) {
            if (pos > target) {
               end = pos - 1;
            }else{
                start = pos + 1;
            }
            pos = getPivot(nums,start,end);
        }
        return nums[pos];
    }

    public int getPivot(int[] nums, int start, int end) {
        int random = new Random().nextInt(end - start + 1) + start;
        swap(nums, random, end);
        int i = start;
        for (int j = start; j <= end; j++) {
            if (nums[i] < nums[j]) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, end);
        return end;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
