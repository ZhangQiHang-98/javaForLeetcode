package someExample;

/**
 * @Description 两个线程交替打印奇偶
 * @Author Zhang Qihang
 * @Date 2022/3/10 16:16
 */
public class oddAndEven implements Runnable{
    static int value = 0;

    @Override
    public void run() {
        while (value <= 100){
            synchronized (oddAndEven.class){
                System.out.println(Thread.currentThread().getName() + ":" + value);
                value++;
                oddAndEven.class.notifyAll();
                try {
                    oddAndEven.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new oddAndEven(), "odd");
        Thread t2 = new Thread(new oddAndEven(), "even");
        t1.start();
        t2.start();
    }

/*        static Thread a = null, b = null;

        //永远是a先执行，因为b始终会执行一个park
        public static void main(String[] args) throws InterruptedException {
            a = new Thread(() -> {
                for (int i = 1; i <= 99; i += 2) {
                    System.out.println(i + Thread.currentThread().getName());
                    LockSupport.unpark(b);
                    LockSupport.park();
                }
            });

            b = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 2; i <= 100; i += 2) {
                        LockSupport.park();
                        System.out.println(i + Thread.currentThread().getName());
                        LockSupport.unpark(a);
                    }
                }
            });
            b.start();
            a.start();
        }*/

}


/*public class threeThread {
    // 线程A、线程B、线程C三个线程同时启动，因为变量num的初始值为0，所以线程B或线程C拿到锁后，进入while()循环，然后执行wait()方法，
    // 线程线程阻塞，释放锁。只有线程A拿到锁后，不进入while()循环，执行num++，打印字符A，最后唤醒线程B和线程C。
    // 此时num值为1，只有线程B拿到锁后，不被阻塞，执行num++，打印字符B，最后唤醒线程A和线程C，后面以此类推。
    private volatile int num = 0;
    // 锁对象
    private Object lock = new Object();

    private void printABC(int targetNum) {
        // 持有锁对象的线程才可以进入
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
            System.out.println(Thread.currentThread().getName());
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        threeThread threeThread = new threeThread();
        new Thread(() -> threeThread.printABC(1), "线程B").start();
        new Thread(() -> threeThread.printABC(2), "线程C").start();
        new Thread(() -> threeThread.printABC(0), "线程A").start();
    }
}*/
