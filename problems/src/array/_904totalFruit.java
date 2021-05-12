package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _904totalFruit {
    // 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。 也就是说不可以跳过树
    // 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
    public int totalFruit(int[] tree) {
        // 定义两种树的初始值，
        int oneTree = tree[0], twoTree, len = tree.length;
        // 定义起始位置
        int start = 0, end = 1;
        int res = 0;
        while (end < len && tree[end] == oneTree) {
            end++;
        }
        if (end == len) {   // 只有一种树
            return len;
        }
        // 初始化第二种树，然后往后走一位开始遍历
        twoTree = tree[end++];

        for (; end < len; end++) {
            if (tree[end] != oneTree && tree[end] != twoTree) { // 如果出现了新的树
                res = Math.max(res, end - start);
                // 更新树
                oneTree = tree[end - 1];
                twoTree = tree[end];
                // 更新起始位置
                start = end - 1;
                while (tree[start - 1] == oneTree) {    // 如果start前面一个是oneTree，就让start往前移动一位
                    start -= 1;
                }
            }
        }
        return Math.max(res, end - start);
    }
}
