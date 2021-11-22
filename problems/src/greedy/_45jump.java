package greedy;

/**
 * @className: _45jump
 * @Description: 给定一个非负整数数组，你最初位于数组的第一个位置。 假设你总是可以到达数组的最后一个位置，求最少的步数
 * @author: Zhang Qihang
 * @date: 2021/11/22 14:05
 */
public class _45jump {
    // 反向寻找，如果有多个位置都可以跳到最后一个位置，我们选择最远的那个位置（如果上一步跳不到这个位置，一定也跳不到后面的位置）
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        // 一直让position跳到最开始的位置
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                // 如果当前步能达到
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    // 贪心的正向寻找，每次找到可达的最远位置（多往后看一步）
    // 每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到max_far位置的点）作为下次的起跳点 ！
    // end初始化为0，代表从0号元素开始（第0步）
    public int jump1(int[] nums) {
        int maxPosition = 0; // 下一跳能够跳到的最远位置
        int step = 0; // 总步数
        int curIndex = 0; // 当前走到哪了， curIndex所处的范围，一定是当前步的覆盖范围
        int end = 0; // 当前跳的最远位置（边界位置）
        // 其精髓在于控制移动下标i只移动到nums.size() - 2的位置，所以移动下标只要遇到当前覆盖最远距离的下标，
        // 直接步数加一，不用考虑别的了
        while (end < nums.length - 1) { //当前这一步，跳不完的情况
            // 在便利的过程中，记录下一步能到达的最大值
            maxPosition = Math.max(maxPosition, nums[curIndex] + curIndex);
            // 如果本次到达了边界
            if (curIndex == end) {
                // 跳一步
                step++;
                // 更新当前边界
                end = maxPosition;
            }
            curIndex++;
        }
        return step;
    }
}
