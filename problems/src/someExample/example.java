package someExample;

/**
 * @className: example
 * @Description: TODO
 * @author: Zhang Qihang
 * @date: 2022/3/28 16:13
 */
public class example {

    public static double compute(String func) {

        //test


        // 遇到等号就变为-1
        int flag = 1;
        int op = 1;
        int curVal = 0;
        int x = 0;
        char[] arr = func.toCharArray();
        int index = 0;
        while (index < arr.length) {
            if (arr[index] == '=') {
                flag = -1;
                op = 1;
            } else if (arr[index] >= '0' && arr[index] <= '9') {
                StringBuffer sb = new StringBuffer();
                sb.append(arr[index]);
                index++;
                while (index < arr.length && arr[index] != '=' && arr[index] != '+' && arr[index] != '-') {
                    sb.append(arr[index]);
                    index++;
                }
                // 得到了当前的数字或未知数
                double cur = 0;
                for (int i = 0; i < sb.length(); i++) {
                    if (sb.charAt(i) == 'x') {
                        x += flag * cur;
                        break;
                    }
                    cur = cur * 10 + sb.charAt(i) - '0';
                }
                curVal += cur * flag * op;
            } else if (arr[index] == '+') {
                op = 1;
            } else if (arr[index] == '-') {
                op = -1;
            }
            index++;
        }
        return curVal / x;
    }

    public static void main(String[] args) {
        compute("2x+3=5x");
    }
}
