package company.alibaba;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * @Author Zhang Qihang
 * @Date 2022/2/1 23:36
 */
public class _169majorityElement {
    // 哈希表的解法
    public int majorityElement(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long limit = nums.length >> 1;
        for (Map.Entry<Integer, Long> entry : map.entrySet())
            if (entry.getValue() > limit)
                return entry.getKey();
        return -1;
    }
    // 如果是排序的话，众数肯定在中间索引，直接返回nums[len/2]就行
/*    候选人(cand_num)初始化为nums[0]，票数count初始化为1。
    当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
    当票数count为0时，更换候选人，并将票数count重置为1。
    遍历完数组后，cand_num即为最终答案*/



}
