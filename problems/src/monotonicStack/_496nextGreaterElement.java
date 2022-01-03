package monotonicStack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @Description 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。  请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * @Author Zhang Qihang
 * @Date 2022/1/3 15:56
 */
public class _496nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 定义一个和nums1长度相同的哈希表来存放结果
        int len1 = nums1.length;
        int len2 = nums2.length;
        // 预处理nums2，使查询nums1中每个元素在nums2中对应位置的右边第一个更大元素时不需要再遍历Nums2
        // 1. 怎么高效的计算nums2中每个元素右边第一个更大的值
        // 2. 如何存储第一个子问题的结果
        // 相当于对nums2做一个简单的单调栈，然后让nums1对应上nums2
        int[] res = new int[len1];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(res, -1);
        // 建立一个哈希表进行对应
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            hashMap.put(nums1[i], i);
        }
        // 单调栈常规操作
        for (int i = 0; i < len2; i++) {
            while (!st.empty() && nums2[i] > nums2[st.peek()]) {
                // 重点是这里，判断nums2中的值是否在nums1中，如果在的话，对应修改即可
                if (hashMap.containsKey(nums2[st.peek()])) {
                    res[hashMap.get(nums2[st.peek()])] = nums2[i];
                }
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
}
