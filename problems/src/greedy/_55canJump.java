package greedy;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.Arrays;

/**
 * @className: _55canJump
 * @Description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 * @author: Zhang Qihang
 * @date: 2021/11/22 13:35
 */
public class _55canJump {

    // 局部最优：每次取最大跳跃步数（取最大覆盖范围）
    // 全局最优：得到整体覆盖
    public boolean canJump(int[] nums) {
        // cover表示一个[0,cover]的覆盖区间
        int cover = 0;

        if (nums.length == 1) {
            return true;
        }
        // 终止处为cover的值，如果没有覆盖的话，就跳不过去，因此不能简单的遍历
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _55canJump test = new _55canJump();
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(test.canJump(nums));
    }
}
