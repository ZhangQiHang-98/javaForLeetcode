package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_01 {


    // 方法2 一次遍历，利用hash字典的查找，查找的时候复杂度为O(1)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
            int[] res = {1,2};
            // 逆序输出
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] test = {2, 7, 11, 15};
        TwoSum_01 t = new TwoSum_01();
        t.twoSum(test, 9);
    }
}
