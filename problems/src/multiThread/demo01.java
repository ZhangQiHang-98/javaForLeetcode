package multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 使用两个线程，轮流打印1到100
 * @Author Zhang Qihang
 * @Date 2022/3/8 10:03
 */
public class demo01 {
    private static volatile int num = 1;
    private static volatile boolean flag = false;
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        // 线程1
        Thread t1 = new Thread(() -> {
            while (num <= 100) {
                if (flag) {
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + "打印" + num);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
    }
}
