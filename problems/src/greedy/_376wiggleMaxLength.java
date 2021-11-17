package greedy;

/**
 * @Description 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * @Author Zhang Qihang
 * @Date 2021/11/17 22:21
 */
public class _376wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        // 序列的问题可以画成峰值图，要使摆动序列尽可能多，那么就要有尽可能多的峰与谷
        // 局部最优：不含单调序列，局部就是一个摆动序列，因此删除单调坡上的节点（不删除起始点和结束点）
        // 全局最优：整个序列有最多的局部峰值，从而达到最长摆动序列

        if (nums.length <= 1 || nums == null) {
            return nums.length;
        }
        // 最左侧进行了特殊处理（preDiff为0，相当于[2,5]变成了[2,2,5]），默认最右侧一个峰，因此+1
        int result = 1;
        // 记录两个差值，这样就可以防止最前和最后,preDiff相当于添加了一个相同的数字。
        int preDiff = 0;
        int curDiff;
        for (int i = 0; i < nums.length - 1; i++) {
            // curDiff是当前节点往前延申，因此为0说明进入平坡，那该元素不可以被统计。
            // 而preDiff是否可以为0，与当前无关，如果preDiff为0，当前不为0，那么是平坡变斜的情况
            curDiff = nums[i + 1] - nums[i];
            if ((curDiff > 0 && preDiff <= 0) || (preDiff >= 0 && curDiff < 0)) {
                result++;
                // 如果preDiff = curDiff在if外，那么我们就是把平坡也统计进来了，如果是一个下坡、平坡、下坡的情况，
                // 我们就会统计到平坡和下坡之间的峰值，但按要求，我们应该忽视这个平坡，将两个下坡拼起来，统计这个下坡的峰值。
                // 因此preDiff永远保留的是上一个摆动的形态（往上或往下）,在中间过程中，preDiff应该永远不为0。
                preDiff = curDiff;
            }
        }
        return result;
    }
}
