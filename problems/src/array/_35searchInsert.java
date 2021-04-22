package array;

// 题解：https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
public class _35searchInsert {
    /*    public int searchInsert(int[] nums, int target) {
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
        }*/
    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        int left = 0;
        int right = size;//  定义 target 是在一个在左闭右开的区间里，也就是[left, right) 。
        while (left < right) { // 如果left == right了，那么区间[left,right)里面不存在值了，就无效了，在left==right的时候就停止了，
            // 也就是退出循环时 left == right
            int middle = left + ((right - left) / 2);
            if (nums[middle] > target) {
                right = middle; // target在左区间，在[left,middle)中，此时middle已经比较过了
            } else if (nums[middle] < target) {
                left = middle + 1; //target 在右区间，在 [middle+1, right)中
            } else {
                // nums[middle] == target
                return middle;
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前 区间为[0,0)
        // 目标值等于数组中某一个元素 return middle
        // 目标值插入数组中的位置 [left, right) ，return right 即可
        // 目标值在数组所有元素之后的情况 [left, right)，return right 即可
        return right;
    }
}
