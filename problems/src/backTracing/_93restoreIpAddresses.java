package backTracing;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * @Author Zhang Qihang
 * @Date 2021/11/4 21:59
 */
public class _93restoreIpAddresses {
    // 结果存储变量
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        sb.append(s);
        backTracking(sb, 0, 0);
        return res;
    }

    // 回溯参数：多加一个pointNum，用来记录当前点的个数
    public void backTracking(StringBuilder sb, int startIndex, int pointNum) {
        // 回溯的终止条件，不是到末尾，只要是有三个.就说明已经要结束了
        if (pointNum == 3) {
            if (isValid(sb.substring(startIndex, sb.length()))) {
                res.add(sb.toString());
            }
            return;
        }
        // 当前为[startIndex,i]的闭区间
        // 回溯逻辑：如果当前切割子串有效的话，那么加.，然后继续切割，否则直接跳出当前循环，因为往后肯定也是无效的
        for (int i = startIndex; i < sb.length(); i++) {
            if (isValid(sb.substring(startIndex, i + 1))) {
                //加入一个点，添加一个点的数量，回溯
                sb.insert(i + 1, '.');
                backTracking(sb, i + 2, pointNum + 1);//这里插入后要从i+2开始
                sb.deleteCharAt(i + 1);

            } else {
                break;
            }
        }
    }

    public boolean isValid(String str) {
        if (str == null || str.length() == 0)
            return false;
        //0开头，且非单位数不合法
        if (str.charAt(0) == '0' && str.length() > 1)
            return false;
        //判断是否包含其他字符
        //判断是否在0~255的范围内
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0')
                return false;
            num = num * 10 + (str.charAt(i) - '0');
            if (num > 255)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _93restoreIpAddresses test = new _93restoreIpAddresses();
        System.out.println(test.restoreIpAddresses("25525511135"));
    }
}
