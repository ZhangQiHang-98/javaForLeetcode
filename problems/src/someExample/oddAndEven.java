package someExample;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description 两个线程交替打印奇偶
 * @Author Zhang Qihang
 * @Date 2022/3/10 16:16
 */
public class oddAndEven {
        static Thread a = null, b = null;

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
        }

}
