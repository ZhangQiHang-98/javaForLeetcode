package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * @Author Zhang Qihang
 * @Date 2021/11/26 18:38
 */
public class _452findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        // 判断是否为空
        if (points.length == 0) {
            return 0;
        }
        // 先将气球按照start从小到大进行排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int result = 1;
        // 遍历气球 ,初始化时[i][1]代表上边界，后面point[i][1]更新为当前能满足一箭的最低点
        for (int i = 1; i < points.length; i++) {
            //如果气球i和气球i-1不挨着【i的最低值要比i-1的最高值大】
            if (points[i][0] > points[i - 1][1]) {
                result++;
            } else {
                // 如果挨着，更改当前最高高度为较小的那个值
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return result;
    }
}
