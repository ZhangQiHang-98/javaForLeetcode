package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * @Author Zhang Qihang
 * @Date 2021/11/26 18:58
 */
public class _435eraseOverlapIntervals {
    //局部最优：优先选右边界小的区间，所以从左向右遍历，留给下一个区间的空间大一些，从而尽量避免交叉。全局最优：选取最多的非交叉区间
    public int eraseOverlapIntervals(int[][] intervals) {
        // 可以转换为求非交叉区间的数量，然后用总区间数量减去即可。
        if (intervals.length < 2) {
            return 0;
        }
        // 先将气球按照start从小到大进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int result = 1;
        // 遍历气球 ,初始化时[i][1]代表上边界，后面point[i][1]更新为当前能满足一箭的最低点
        for (int i = 1; i < intervals.length; i++) {
            //如果气球i和气球i-1不挨着【i的最低值要比i-1的最高值大】
            if (intervals[i][0] >= intervals[i - 1][1]) {
                result++;
            } else {
                // 如果挨着，更改当前最高高度为较小的那个值
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return intervals.length - result;
    }
}
