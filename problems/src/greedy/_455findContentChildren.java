package greedy;

import java.util.Arrays;

/**
 * @Description 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * @Author Zhang Qihang
 * @Date 2021/11/16 11:30
 */
public class _455findContentChildren {
    // s为饼干，g为小孩
    // 考虑局部最优和全局最优：局部最优就是大饼干喂给胃口大的，全局最优就是更多的小孩可以吃到
    // 遍历小孩，然后饼干用index，不用for循环
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        // index指向当前最大的饼干
        int index = s.length - 1;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = g.length - 1; i >= 0 && index >= 0; i--) {
            // 当前满足
            if (g[i] <= s[index]) {
                result++;
                index--;
            }
            // 如果不满足，继续遍历小孩即可。
        }
        return result;
    }

    public static void main(String[] args) {
        _455findContentChildren findContentChildren = new _455findContentChildren();
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren.findContentChildren(g, s));
    }
}


