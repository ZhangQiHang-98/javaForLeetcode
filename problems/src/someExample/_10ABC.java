package someExample;

/**
 * @Description 三线程轮流打印ABC各10次
 * @Author Zhang Qihang
 * @Date 2022/3/9 21:23
 */
public class _10ABC {
    private volatile int num = 0;
    // 锁对象
    private Object lock = new Object();

    private void printABC(int targetNum) {
        // 大家都ok了才完成一次循环
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                while (num % 3 != targetNum) {
                    try {
                        // 如果持有锁的线程不符合要求，则挂起当前线程，等待其他线程调用notify()方法
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.print(Thread.currentThread().getName());
                lock.notifyAll();
            }
        }
        // 持有锁对象的线程才可以进入
    }

    public static void main(String[] args) {
        _10ABC instance = new _10ABC();
        new Thread(() -> instance.printABC(1), "B").start();
        new Thread(() -> instance.printABC(2), "C").start();
        new Thread(() -> instance.printABC(0), "A").start();
    }
}
