package array;

public class RemoveVal_27 {
    public int removeElement(int[] nums, int val) {
        // 注意的是，这里需要一直将fast的值赋给slow,这里遍历fast的步骤包含在了循环里，赋值的步骤包含在了循环体内部。
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
