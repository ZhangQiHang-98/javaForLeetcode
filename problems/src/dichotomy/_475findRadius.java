package dichotomy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _475findRadius {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int result = Integer.MIN_VALUE;
        for (int house : houses) {
            // 搜索适当的插入位置
            int index = searchInsert(heaters, house);
            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

            result = Math.max(result, Math.min(dist1, dist2));
        }
        return result;
    }

    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        // 这个时候target在一个左闭右闭的区间内，也就是[left,right]
        // 因此需要left<=right,这样即使只剩一个元素（left==right），区间仍然有效，还会再进行一次比较
        while (left <= right) {
            //midlle取中间前一个（偶数），正中间（奇数）的index
            int middle = left + ((right - left) / 2);   //防止溢出
            if (nums[middle] > target) {
                right = middle - 1; // target在左区间中，因此下一个区间更新为[left,middle-1]
            } else if (nums[middle] < target) {
                left = middle + 1;  // target在右区间中，因此下一个区间更新为[left,middle-1]
            } else {
                // nums[middle] == target
                return middle;
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前  [0, -1]
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置 [left, right]，return  right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， return right + 1
        return right + 1;
    }
}
