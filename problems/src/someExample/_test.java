package someExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @className: _test
 * @Description: TODO
 * @author: Zhang Qihang
 * @date: 2022/3/15 11:24
 */
public class _test {
    public static int[] merge(int[] arr) {
        // 给定一个未排序的整形算法，非零的放在数组前面，所有0元素排在数组后面
        for (int i = 0; i < arr.length; i++) {
            int fast = 0;
            for (int slow = 0; slow < arr.length; slow++) {
                if (arr[slow] != 0) {
                    int temp = arr[fast];
                    arr[fast] = arr[slow];
                    arr[slow] = temp;
                    fast++;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void random(double moneySum, int redNum) {
        double moneyMin = 1;
        Random random = new Random();
        int test = 0;
        for (int i = 1; i < redNum; i++) {
            // 设计红包的上下界
            double moneyMax = moneySum / (redNum - i);
            double money = random.nextDouble() * (moneyMax - moneyMin) + moneyMin;
            moneySum -= money;
            test += money;
            System.out.println(money);
        }
        System.out.println(test);
    }

    public static void random(Double moneySum, int peopleNum) {
        List<Double> amountList = new ArrayList<>();
        double restAmount = moneySum;
        int restPeopleNum = peopleNum;
        Random random = new Random();
        for (int i = 0; i < peopleNum - 1; i++) {
            //随机范围：[1，剩余人均金额的2倍-1] 分
            Double amount = random.nextDouble(restAmount / restPeopleNum * 2 - 1) + 1;
            amountList.add(amount);
            restAmount = restAmount - amount;
            restPeopleNum--;
        }
        amountList.add(restAmount);
    }

    public static void main(String[] args) {
        random(100, 10);
    }
}
