package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @Description 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * @Author Zhang Qihang
 * @Date 2021/11/24 17:06
 */
public class _406reconstructQueue {
    // 两个条件的一定是先确定一个条件，再按照另外一个条件去做
    // 局部最优：优先按身高高的people的k来插入。插入操作过后的people满足队列属性
    // 把矮的排后面，前面都是搞的，所以直接排也可以
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);
        }

        return que.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {

    }
}
