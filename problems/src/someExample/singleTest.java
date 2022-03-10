package someExample;

/**
 * @Description 线程安全的单例
 * @Author Zhang Qihang
 * @Date 2022/3/9 20:56
 */
public class singleTest {
    // 未被初始化过
    private static volatile singleTest instance;
    private singleTest() {
    }

    private static singleTest getInstance() {
        // 先判断是否已经被实例化过了,如果没有实例化过,就进入同步代码块
        if (instance == null) {
            synchronized (singleTest.class) {
                if (instance == null) {
                    instance = new singleTest();
                }
            }
        }
        return instance;
    }
}
