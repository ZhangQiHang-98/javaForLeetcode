package array;

public class DeleteDuplicates_26 {
    public int removeDuplicates(int[] nums) {
        // 如果数组为空或者长度为0，直接返回0
        // 原地删除、去重的题，一般是用到两个指针，一个快指针，一个慢指针
        // 快指针匹配到要删除、重复的元素就跳过，直到不用调过后赋给慢指针应有的值
        // 前提条件已经给出是有序数组
        // sp之前的值肯定是对的
        if (nums == null || nums.length == 0) {
            return nums.length;
        }
        int sp = 0, fp = 1;
        for (fp = 1; fp < nums.length; fp++) {
            if (nums[fp] != nums[sp]) {
                nums[++sp] = nums[fp];
            }
        }

        return sp + 1;
    }
}
