package someExample;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: _331
 * @Description: TODO
 * @author: Zhang Qihang
 * @date: 2022/3/31 10:10
 */
public class _331 {
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        int index = 0;
        for (Integer e : res) {
            res.set(index++, 5);
        }
        System.out.println(res.toString());
    }
}
