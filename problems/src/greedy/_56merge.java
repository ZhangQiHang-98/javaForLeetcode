package greedy;

import java.util.*;

/**
 * @Description 给出一个区间的集合，请合并所有重叠的区间。
 * @Author Zhang Qihang
 * @Date 2021/11/26 20:43
 */
public class _56merge {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 存在重叠部分，注意这里是跟curEnd比较
            if (intervals[i][0] <= curEnd) {
                curEnd = Math.max(intervals[i][1], curEnd);
            } else {
                res.add(new int[]{curStart, curEnd});
                curStart = intervals[i][0];
                curEnd = intervals[i][1];
            }
        }
        // 添加最后一个区间
        res.add(new int[]{curStart, curEnd});
        return res.toArray(new int[res.size()][]);
    }


    public static void main(String[] args) {
        _56merge test = new _56merge();
        int[][] intervals = {{1, 10}, {2, 3}, {4, 5}, {6, 7}, {8, 9}};
        test.merge(intervals);
    }

}
